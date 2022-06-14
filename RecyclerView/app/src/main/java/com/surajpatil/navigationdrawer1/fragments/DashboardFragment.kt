package com.surajpatil.navigationdrawer1.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.surajpatil.navigationdrawer1.R
import com.surajpatil.navigationdrawer1.adapter.DashboardRecyclerAdapter
import com.surajpatil.navigationdrawer1.model.Book


class DashboardFragment : Fragment() {
    lateinit var recyclerDashboard: RecyclerView
    lateinit var layoutManager: RecyclerView.LayoutManager

    // for adding the data
    val bookList = arrayListOf(
        "Dr.Sarvepalli Radhakrishnan",
        "Dr.APJ Abdul Kalam",
        "Swami Dayanand Saraswati",
        "Rabindra Nath Tagore",
        "Savitribai Phule",
        "Swami Vivekananda",
        "Srinivasa Ramanujan",
        "Michael Soskil (USA)",
        "Joe Fatheree (USA)",
        "C.V. raman"
    )

    lateinit var recyclerAdapter: DashboardRecyclerAdapter

    val bookInfoList = arrayListOf<Book>(
        Book("Dr.Sarvepalli Radhakrishnan", "Dr.Sarvepalli Radhakrishnan", "Rs. 4500", "4.8", R.drawable.radha),
        Book("Dr.APJ Abdul Kalam", "Dr.APJ Abdul Kalam", "Rs. 4200", "4.9", R.drawable.apj),
        Book("Swami Dayanand Saraswati", "Swami Dayanand Saraswati", "Rs. 2500", "4.1", R.drawable.dayanand),
        Book("Rabindra Nath Tagore", "Rabindra Nath Tagore", "Rs. 1500", "4.3", R.drawable.ravindranatetagor),
        Book("Savitribai Phule", "Dr.Sarvepalli Radhakrishnan", "Rs. 500", "4.4", R.drawable.savitribai),
        Book("Swami Vivekananda", "Dr.Sarvepalli Radhakrishnan", "Rs. 800", "4.9", R.drawable.vivekanand),
        Book("Srinivasa Ramanujan", "Dr.Sarvepalli Radhakrishnan", "Rs. 1200", "4.7", R.drawable.ramanu),
        Book("Michael Soskil (USA)", "Dr.Sarvepalli Radhakrishnan", "Rs. 100", "4.7", R.drawable.sos),
        Book("Joe Fatheree (USA)", "Dr.Sarvepalli Radhakrishnan", "Rs. 200", "4.7", R.drawable.joe),
        Book("C.V. raman", "Dr.Sarvepalli Radhakrishnan", "Rs. 3200", "4.7", R.drawable.cv)
    )


    override fun onCreateView(
        inflater: LayoutInflater , container: ViewGroup? ,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_dashboard , container , false)

        recyclerDashboard = view.findViewById(R.id.recycleDashboard)
        layoutManager = LinearLayoutManager(activity)

        recyclerAdapter = DashboardRecyclerAdapter(activity as Context, bookInfoList)

        // we have to setup with recycler view -> adapter, manager
        recyclerDashboard.adapter = recyclerAdapter
        recyclerDashboard.layoutManager = layoutManager

        return view
    }

}