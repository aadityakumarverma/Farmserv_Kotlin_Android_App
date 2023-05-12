package com.example.farmserv

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.home_flow.*

private val homeFragment=  HomeFragment()
private  val cartFragment = CartFragment()
private  val marketFragment = MarketFragment()
private val mandiFragment = MandiFragment()


class Home : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_flow)





        bottomNav.setOnItemSelectedListener {
            when(it.itemId){
                R.id.nav_home -> replaceFragment(homeFragment)
                R.id.nav_cart -> replaceFragment(cartFragment)
                R.id.nav_market -> replaceFragment(marketFragment)
                R.id.nav_mandi -> replaceFragment(mandiFragment)
            }
            true
        }
//hvgvhfgyftyftyf hugyu

        replaceFragment(homeFragment)




    }

    override fun onBackPressed() {
        var count = supportFragmentManager.backStackEntryCount


        if (count == 1) {
            super.onBackPressed()
            super.onBackPressed()
            //additional code
        } else {

            bottomNav.setSelectedItemId(R.id.nav_home)
            for (i in 1..count)
            {
                supportFragmentManager.popBackStack()
            }

            Toast.makeText(this, "Press again to exit", Toast.LENGTH_SHORT).show()

        }

    }

    private fun replaceFragment(fragment: Fragment){
        if(fragment!= null)
        {
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.home_frame,fragment).addToBackStack("a2b")
            transaction.commit()
        }
    }
}