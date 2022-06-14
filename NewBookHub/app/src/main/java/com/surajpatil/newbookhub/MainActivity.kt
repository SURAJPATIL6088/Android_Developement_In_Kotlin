package com.surajpatil.newbookhub

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.FrameLayout
import android.widget.Toast
import android.widget.Toolbar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.circularreveal.coordinatorlayout.CircularRevealCoordinatorLayout
import com.google.android.material.navigation.NavigationView
import java.nio.channels.AsynchronousFileChannel.open

class MainActivity : AppCompatActivity() {

    lateinit var coordinatorlayput: CoordinatorLayout
    lateinit var toolbar: androidx.appcompat.widget.Toolbar
    lateinit var framelayout:FrameLayout
    lateinit var navigationbar: NavigationView
    lateinit var drawerLayout:DrawerLayout

    var PreviousItem: MenuItem? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        drawerLayout = findViewById(R.id.drawerLayout)
        navigationbar = findViewById(R.id.navigationbar)
        toolbar = findViewById(R.id.toolbar)
        coordinatorlayput = findViewById(R.id.coordinatorlayput)
        framelayout = findViewById(R.id.framelayout)

        setUpToolbar()
        val actionBarDrawerToggle = ActionBarDrawerToggle(this@MainActivity,drawerLayout, R.string.open_drawer, R.string.close_drawer)

        drawerLayout.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()

        // Open the By default -> DASHBOARD activity
        openDashboard()

        navigationbar.setNavigationItemSelectedListener {

            // for highlighted fragment
            if( PreviousItem != null)
            {
                PreviousItem?.isChecked = false
            }
            it.isChecked = true
            it.isCheckable = true
            PreviousItem = it

            when(it.itemId)
            {
                R.id.dashboard ->
                {
                    Toast.makeText(this@MainActivity, "Dashboard Page",Toast.LENGTH_SHORT).show()
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.framelayout, DashboardFragment())
                        .commit()

                    supportActionBar?.title = "Dashboard"
                    drawerLayout.closeDrawers()
                }

                R.id.favourites ->
                {
                    Toast.makeText(this@MainActivity, "Favourites Page", Toast.LENGTH_SHORT).show()
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.framelayout, FavouriteFragment())
                        .commit()

                    supportActionBar?.title = "Favourites"
                    drawerLayout.closeDrawers()
                }

                R.id.profile ->
                {
                    Toast.makeText(this@MainActivity, "Profile Page", Toast.LENGTH_SHORT).show()
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.framelayout, ProfileFragment())
                        .commit()

                    supportActionBar?.title = "Profile"
                    drawerLayout.closeDrawers()
                }

                R.id.nearme ->
                {
                    Toast.makeText(this@MainActivity,"Near By Tutor Page",Toast.LENGTH_SHORT).show()
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.framelayout, NearFragment())
                        .commit()

                    supportActionBar?.title = "Near By Tutor"
                    drawerLayout.closeDrawers()
                }

                R.id.settings ->
                {
                    Toast.makeText(this@MainActivity,"Settings Page",Toast.LENGTH_SHORT).show()
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.framelayout, SettingsFragment())
                        .commit()

                    supportActionBar?.title = "Settings"
                    drawerLayout.closeDrawers()
                }

                R.id.aboutapp ->
                {
                    Toast.makeText(this@MainActivity,"About App Page",Toast.LENGTH_SHORT).show()
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.framelayout, AboutFragment())
                        .commit()

                    supportActionBar?.title = "About App"
                    drawerLayout.closeDrawers()
                }
            }

            return@setNavigationItemSelectedListener true
        }

    }

    fun setUpToolbar()
    {
        setSupportActionBar(toolbar)
        supportActionBar?.title = "New Book Hub"
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    fun setSupportActionBar(toolbar: Toolbar) {

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        val id = item.itemId

        if(id == android.R.id.home)
        {
            drawerLayout.openDrawer(GravityCompat.START)
        }
        return super.onOptionsItemSelected(item)
    }

    fun openDashboard()
    {
        // val fragment = DashboardFragment
        val trans = supportFragmentManager.beginTransaction()
            trans.replace(R.id.framelayout, DashboardFragment())
            trans.commit()

        supportActionBar?.title = "Dashboard"
        navigationbar.setCheckedItem(R.id.dashboard)
    }

    // after click on the back button we reach the dashboard fragment
    override fun onBackPressed() {
        val frag = supportFragmentManager.findFragmentById(R.id.framelayout)

        when(frag)
        {
            !is DashboardFragment -> openDashboard()
            else -> super.onBackPressed()
        }
    }
}