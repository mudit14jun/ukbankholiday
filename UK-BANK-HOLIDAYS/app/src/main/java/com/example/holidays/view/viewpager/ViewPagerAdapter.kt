package com.example.holidays.view.viewpager

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.holidays.view.fragment.HolidayFragment

class ViewPagerAdapter(activity: AppCompatActivity, val itemsCount: Int) :
    FragmentStateAdapter(activity) {

    override fun getItemCount(): Int {
        return itemsCount
    }

    override fun createFragment(position: Int): Fragment {
        var fragment: Fragment = HolidayFragment()

        val args = Bundle()
        args.putInt("position", position)
        fragment.arguments = args
        return fragment
    }
}


