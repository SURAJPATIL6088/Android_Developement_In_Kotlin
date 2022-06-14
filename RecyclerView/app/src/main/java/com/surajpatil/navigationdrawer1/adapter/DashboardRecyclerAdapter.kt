package com.surajpatil.navigationdrawer1.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.surajpatil.navigationdrawer1.R
import com.surajpatil.navigationdrawer1.model.Book
import java.util.ArrayList

class DashboardRecyclerAdapter(val context:Context, val itemList :ArrayList<Book>) : RecyclerView.Adapter<DashboardRecyclerAdapter.DashboardViewHolder> (){

    override fun onCreateViewHolder(parent: ViewGroup , viewType: Int): DashboardViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_dashboard, parent, false)

        return DashboardViewHolder(view)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: DashboardViewHolder , position: Int) {
        val book = itemList[position]
        holder.txtBookName.text = book.Name
        holder.txtBookAuthor.text = book.bookAuthor
        holder.txtBookPrice.text = book.bookCost
        holder.txtBookRatiing.text = book.bookRating
        holder.imgBookImage.setBackgroundResource(book.bookImage)

        holder.recyclerLayout.setOnClickListener {
            Toast.makeText(context, "Clicked On ${holder.txtBookName.text} Book !!", Toast.LENGTH_SHORT).show()
        }
    }

    class DashboardViewHolder(view:View) : RecyclerView.ViewHolder(view)
    {
        val txtBookName: TextView = view.findViewById(R.id.txtBookName)
        val txtBookAuthor: TextView = view.findViewById(R.id.txtBookAuthor)
        val txtBookPrice: TextView = view.findViewById(R.id.txtBookPrice)
        val txtBookRatiing: TextView = view.findViewById(R.id.txtBookRating)
        val imgBookImage: ImageView = view.findViewById(R.id.imgBookImage)
        val recyclerLayout:RelativeLayout = view.findViewById(R.id.recyclerLayout)
    }
}