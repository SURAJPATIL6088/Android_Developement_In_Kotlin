package com.surajpatil.smarttutor

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
import com.google.android.material.navigation.NavigationView
import com.surajpatil.smarttutor.navigation.*

class MainActivity : AppCompatActivity() {

    lateinit var drawerLayout: DrawerLayout
    lateinit var coordinatorlayout: CoordinatorLayout
    lateinit var toolbar: androidx.appcompat.widget.Toolbar
    lateinit var framelayout: FrameLayout
    lateinit var navigationView: NavigationView

    var PreviousItem: MenuItem? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        drawerLayout = findViewById(R.id.drawerLayout)
        coordinatorlayout = findViewById(R.id.coordinatorLayout)
        toolbar = findViewById(R.id.toolbar)
        framelayout = findViewById(R.id.frameLayout)
        navigationView = findViewById(R.id.navigationView)

        // setup the toolbar/ action bar
        setUpToolbar()

        val actionBarDrawerToggle = ActionBarDrawerToggle(
            this@MainActivity ,
            drawerLayout ,
            R.string.open_drawer ,
            R.string.close_drawer
        )

        drawerLayout.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()
/*
        // Open the By default -> DASHBOARD activity
        openDashboard()

        navigationView.setNavigationItemSelectedListener {

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
                        .replace(R.id.frameLayout, DashboardFragment())
                        .commit()

                    supportActionBar?.title = "Dashboard"
                    drawerLayout.closeDrawers()
                }

                R.id.profile ->
                {
                    Toast.makeText(this@MainActivity, "Profile Page", Toast.LENGTH_SHORT).show()
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frameLayout, ProfileFragment())
                        .commit()

                    supportActionBar?.title = "Profile"
                    drawerLayout.closeDrawers()
                }

                R.id.favourites ->
                {
                    Toast.makeText(this@MainActivity, "Favourites Page", Toast.LENGTH_SHORT).show()
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frameLayout, FavFragment())
                        .commit()

                    supportActionBar?.title = "Favourites"
                    drawerLayout.closeDrawers()
                }

                R.id.nearbyme ->
                {
                    Toast.makeText(this@MainActivity,"About App Page",Toast.LENGTH_SHORT).show()
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frameLayout, NearMeFragment())
                        .commit()

                    supportActionBar?.title = "About App"
                    drawerLayout.closeDrawers()
                }

                R.id.aboutapp ->
                {
                    Toast.makeText(this@MainActivity,"About App Page",Toast.LENGTH_SHORT).show()
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frameLayout, AboutFragment())
                        .commit()

                    supportActionBar?.title = "About App"
                    drawerLayout.closeDrawers()
                }

                R.id.settings ->
                {
                    Toast.makeText(this@MainActivity,"About App Page",Toast.LENGTH_SHORT).show()
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frameLayout, SettingsFragment())
                        .commit()

                    supportActionBar?.title = "About App"
                    drawerLayout.closeDrawers()
                }

            }

            return@setNavigationItemSelectedListener true
        }
 */

    }


    fun setUpToolbar() {
        setSupportActionBar(toolbar)
        supportActionBar?.title = "Smart Tutor Application"
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        val id = item.itemId

        if (id == android.R.id.home) {
            drawerLayout.openDrawer(GravityCompat.START)
        }

        return super.onOptionsItemSelected(item)
    }
/*
    fun openDashboard()
    {
        val fragment = DashboardFragment
        val trans = supportFragmentManager.beginTransaction()
        trans.replace(R.id.frameLayout, DashboardFragment())
        trans.commit()

        supportActionBar?.title = "Dashboard"
        navigationView.setCheckedItem(R.id.dashboard)
    }

    // after click on the back button we reach the dashboard fragment
    override fun onBackPressed() {
        val frag = supportFragmentManager.findFragmentById(R.id.frameLayout)

        when(frag)
        {
            !is DashboardFragment -> openDashboard()

            else -> super.onBackPressed()
        }
    }

 */
}
