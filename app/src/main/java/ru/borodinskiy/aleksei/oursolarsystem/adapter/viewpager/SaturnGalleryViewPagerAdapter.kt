package ru.borodinskiy.aleksei.oursolarsystem.adapter.viewpager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import ru.borodinskiy.aleksei.oursolarsystem.ui.saturn.gallery.SaturnPlanetGalleryFragment
import ru.borodinskiy.aleksei.oursolarsystem.ui.saturn.gallery.SaturnSatelliteGalleryFragment

class SaturnGalleryViewPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> SaturnPlanetGalleryFragment()
            1 -> SaturnSatelliteGalleryFragment()
            else -> SaturnPlanetGalleryFragment()
        }
    }
}