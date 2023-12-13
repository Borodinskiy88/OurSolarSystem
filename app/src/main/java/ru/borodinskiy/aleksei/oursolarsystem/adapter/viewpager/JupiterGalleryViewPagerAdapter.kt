package ru.borodinskiy.aleksei.oursolarsystem.adapter.viewpager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import ru.borodinskiy.aleksei.oursolarsystem.ui.jupiter.gallery.JupiterPlanetGalleryFragment
import ru.borodinskiy.aleksei.oursolarsystem.ui.jupiter.gallery.JupiterSatelliteGalleryFragment

class JupiterGalleryViewPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> JupiterPlanetGalleryFragment()
            1 -> JupiterSatelliteGalleryFragment()
            else -> JupiterPlanetGalleryFragment()
        }
    }
}