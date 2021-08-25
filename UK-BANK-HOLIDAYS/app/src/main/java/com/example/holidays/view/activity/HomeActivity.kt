package com.example.holidays.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.example.holidays.R
import com.example.holidays.view.viewpager.ViewPagerAdapter

class HomeActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val viewPager = findViewById<ViewPager2>(R.id.viewPager)
        if (viewPager != null) {
            val adapter = ViewPagerAdapter(this,3)
            viewPager.adapter = adapter
        }
    }
}
