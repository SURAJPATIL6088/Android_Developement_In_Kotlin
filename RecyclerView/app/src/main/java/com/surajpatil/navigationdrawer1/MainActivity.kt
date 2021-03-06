package com.surajpatil.navigationdrawer1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.FrameLayout
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import com.surajpatil.navigationdrawer1.fragments.*

class MainActivity : AppCompatActivity() {

    lateinit var drawerLayout: DrawerLayout
    lateinit var coordinatorLayout: CoordinatorLayout
    lateinit var toolbar: Toolbar
    lateinit var frameLayout: FrameLayout
    lateinit var navigationView: NavigationView

    var previousMenuItem : MenuItem?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        drawerLayout = findViewById(R.id.drawerLayout)
        coordinatorLayout = findViewById(R.id.coordinatorLayout)
        toolbar = findViewById(R.id.toolbar)
        frameLayout = findViewById(R.id.frame)
        navigationView = findViewById(R.id.navigationView)

        // calling function setUpToolbar
        setUpToolbar()

        // by default open dashboard fragment
        openDashboard()

        val actionBarDrawerToggle = ActionBarDrawerToggle(
            this@MainActivity ,
            drawerLayout ,
            R.string.open_drawer ,
            R.string.close_drawer
        )

        drawerLayout.addDrawerListener(actionBarDrawerToggle)

        // back arrow and hamburger icon vice-virca
        actionBarDrawerToggle.syncState()

        navigationView.setNavigationItemSelectedListener {

            if(previousMenuItem != null)
            {
                previousMenuItem?.isChecked = false
            }

            it.isCheckable = true
            it.isChecked = true
            previousMenuItem = it

            when (it.itemId) {
                R.id.dashboard -> {
                    Toast.makeText(this@MainActivity , "Clicked On Dashboard" , Toast.LENGTH_SHORT)
                        .show()

                    supportFragmentManager.beginTransaction().replace(R.id.frame , DashboardFragment()).commit()

                    supportActionBar?.title = "Dashboard"
                    drawerLayout.closeDrawers()
                }
                R.id.favourites -> {
                    Toast.makeText(this@MainActivity , "Clicked On Favourites" , Toast.LENGTH_SHORT)
                        .show()

                    supportFragmentManager.beginTransaction().replace(R.id.frame , FavouritesFragment()).commit()

                    supportActionBar?.title = "Favourites"
                    drawerLayout.closeDrawers()
                }
                R.id.profile -> {
                    Toast.makeText(this@MainActivity , "Clicked On Profile" , Toast.LENGTH_SHORT)
                        .show()

                    supportFragmentManager.beginTransaction().replace(R.id.frame , ProfileFragment()).commit()

                    supportActionBar?.title = "Profile"
                    drawerLayout.closeDrawers()
                }
                R.id.setting -> {
                    Toast.makeText(this@MainActivity , "Clicked On Settings" , Toast.LENGTH_SHORT)
                        .show()

                    supportFragmentManager.beginTransaction().replace(R.id.frame , SettingsFragment()).commit()

                    supportActionBar?.title = "Settings"
                    drawerLayout.closeDrawers()
                }
                R.id.about -> {
                    Toast.makeText(this@MainActivity , "Clicked On About App" , Toast.LENGTH_SHORT)
                        .show()

                    supportFragmentManager.beginTransaction().replace(R.id.frame , AboutFragment()).commit()

                    supportActionBar?.title = " About App"
                    drawerLayout.closeDrawers()
                }
            }

            return@setNavigationItemSelectedListener true
        }
    }

    fun setUpToolbar() {
        setSupportActionBar(toolbar)
        supportActionBar?.title = "Toolbar Title"
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

    fun openDashboard()
    {
        val fragment = DashboardFragment()
        val transcation = supportFragmentManager.beginTransaction()
        transcation.replace(R.id.frame, fragment)
        transcation.commit()
        supportActionBar?.title = "Dashboard"
        navigationView.setCheckedItem(R.id.dashboard)
    }

    override fun onBackPressed() {
        val frag = supportFragmentManager.findFragmentById(R.id.frame)

        when(frag)
        {
            !is DashboardFragment -> openDashboard()

            else -> super.onBackPressed()
        }
    }
}