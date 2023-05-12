package com.example.farmserv
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.categories.*
import kotlinx.android.synthetic.main.otp_verification.*


class Categories : AppCompatActivity() {
    lateinit var arrowPath: String

    override fun onCreate(savedInstanceState: Bundle?) {
        arrowPath =intent.getStringExtra("homeToCategory").toString()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.categories)


//        Toast.makeText(this, "arrow>"+arrowPath, Toast.LENGTH_SHORT).show()
        if (arrowPath=="protectionToCategory")
        {
            viewPager.setCurrentItem(1,true)
        }
        else if (arrowPath=="nutritionToCategory")
        {
            viewPager.setCurrentItem(2,true)
        }
        else if (arrowPath=="otherToCategory")
        {
            viewPager.setCurrentItem(3,true)
        }
        else{
            viewPager.setCurrentItem(0,true)
        }

        iv_backButtonCategory.setOnClickListener {
            finish()
        }


        iv_seedsIcon.setBackgroundResource(R.drawable.category_selected_bg)
        iv_seedsIcon.setOnClickListener {
            viewPager.setCurrentItem(0,true)
        }
        iv_protectionIcon.setOnClickListener {
            viewPager.setCurrentItem(1,true)
        }
        iv_nutritionIcon.setOnClickListener {
            viewPager.setCurrentItem(2,true)
        }

        iv_othersIcon.setOnClickListener {
           viewPager.setCurrentItem(3,true)
        }

        // set the references of the declared objects above


        // Initializing the ViewPagerAdapter
        val adapter = ViewPagerAdapter(supportFragmentManager)

        // add fragment to the list
        adapter.addFragment(FragmentSeeds(), "  Seeds   ")
        adapter.addFragment(FragmentProtection(), "Protection")
        adapter.addFragment(FragmentNutritions(), "Nutritions")
        adapter.addFragment(FragmentOthers(), "  Others  ")



        // Adding the Adapter to the ViewPager
        viewPager.adapter = adapter

        // bind the viewPager with the TabLayout.
        tabs.setupWithViewPager(viewPager)

        tabs.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                viewPager!!.currentItem = tab.position

                if(tab.position==0)
                {
                    iv_seedsIcon.setBackgroundResource(R.drawable.category_selected_bg)
                    iv_protectionIcon.setBackgroundResource(R.drawable.category_bg)
                    iv_nutritionIcon.setBackgroundResource(R.drawable.category_bg)
                    iv_othersIcon.setBackgroundResource(R.drawable.category_bg)
                }
                else if(tab.position==1)
                {
                    iv_seedsIcon.setBackgroundResource(R.drawable.category_bg)
                    iv_protectionIcon.setBackgroundResource(R.drawable.category_selected_bg)
                    iv_nutritionIcon.setBackgroundResource(R.drawable.category_bg)
                    iv_othersIcon.setBackgroundResource(R.drawable.category_bg)
                }
                else if(tab.position==2)
                {
                    iv_seedsIcon.setBackgroundResource(R.drawable.category_bg)
                    iv_protectionIcon.setBackgroundResource(R.drawable.category_bg)
                    iv_nutritionIcon.setBackgroundResource(R.drawable.category_selected_bg)
                    iv_othersIcon.setBackgroundResource(R.drawable.category_bg)
                }
                else if(tab.position==3)
                {
                    iv_seedsIcon.setBackgroundResource(R.drawable.category_bg)
                    iv_protectionIcon.setBackgroundResource(R.drawable.category_bg)
                    iv_nutritionIcon.setBackgroundResource(R.drawable.category_bg)
                    iv_othersIcon.setBackgroundResource(R.drawable.category_selected_bg)
                }

            }
            override fun onTabUnselected(tab: TabLayout.Tab) {
                viewPager.getChildAt(tab.position)

            }
            override fun onTabReselected(tab: TabLayout.Tab) {


            }
        })


        if (arrowPath=="protectionToCategory")
        {
            viewPager.setCurrentItem(1,true)
        }
        else if (arrowPath=="nutritionToCategory")
        {
            viewPager.setCurrentItem(2,true)
        }
        else if (arrowPath=="otherToCategory")
        {
            viewPager.setCurrentItem(3,true)
        }
        else{
            viewPager.setCurrentItem(0,true)
        }

    }



}
