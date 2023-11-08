package ru.borodinskiy.aleksei.oursolarsystem.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import ru.borodinskiy.aleksei.oursolarsystem.ui.photoday.PhotoDayArchiveFragment
import ru.borodinskiy.aleksei.oursolarsystem.ui.photoday.PhotoDayTodayFragment

class ViewPagerPhotoDayAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> PhotoDayTodayFragment()
            1 -> PhotoDayArchiveFragment()
            else -> PhotoDayTodayFragment()
        }
    }
}