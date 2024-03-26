package com.example.kietmart





import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import android.view.Window
import android.view.WindowManager

import com.example.kietmart.databinding.ActivityMainBinding

import com.google.android.material.navigation.NavigationView


class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    private lateinit var drawerlayout: DrawerLayout


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        changeStatusBarColor("#0074D9") // Replace with your desired color code

        val binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //support action
        val toolbar =findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        //navview
        drawerlayout = binding.navdrawer

        binding.navView.setNavigationItemSelectedListener(this)

        val toggle = ActionBarDrawerToggle(this,drawerlayout,toolbar,
            R.string.open_nav,
            R.string.closed_nav
        )
        drawerlayout.addDrawerListener(toggle)
        toggle.syncState()

        if(savedInstanceState == null){
            replacefragment(Home())
            binding.navView.setCheckedItem(R.id.Home)
        }
        binding.bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.Home -> replacefragment(Home())
                R.id.Person -> replacefragment(Account())
                R.id.Sell -> replacefragment(Sell())
                R.id.Cart -> replacefragment(cart())
                else ->{
                }
            }
            true



        }



    }
    private fun changeStatusBarColor(color: String) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val window: Window = window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor = android.graphics.Color.parseColor(color)
        }
    }




    override fun onBackPressed() {
        super.onBackPressed()
        if (drawerlayout.isDrawerOpen(GravityCompat.START)){
            drawerlayout.closeDrawer(GravityCompat.START)
        }else{
            onBackPressedDispatcher.onBackPressed()
        }
    }

    private fun replacefragment(fragment : Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.main_framelayout,fragment)
        fragmentTransaction.commit()

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.nav_Home -> replacefragment(Home())
            R.id.nav_Person -> replacefragment(Account())
            R.id.nav_Sell -> replacefragment(Sell())
            R.id.nav_Cart -> replacefragment(cart())
            R.id.nav_logout ->Toast.makeText(this,"Log_Out",Toast.LENGTH_SHORT).show()

        }
        drawerlayout.closeDrawer(GravityCompat.START)
        return true


    }
    

}
