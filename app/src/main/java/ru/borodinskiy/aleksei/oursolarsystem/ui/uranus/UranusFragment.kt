package ru.borodinskiy.aleksei.oursolarsystem.ui.uranus

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import dagger.hilt.android.AndroidEntryPoint
import ru.borodinskiy.aleksei.oursolarsystem.R
import ru.borodinskiy.aleksei.oursolarsystem.databinding.FragmentUranusBinding

@AndroidEntryPoint
class UranusFragment : Fragment() {

    private companion object {
        const val INFO_TAG = "INFO_TAG"
        const val GALLERY_TAG = "GALLERY_TAG"
        const val SATELLITES_TAG = "SATELLITES_TAG"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentUranusBinding.inflate(inflater, container, false)

        if (childFragmentManager.findFragmentById(R.id.container) == null) {
            loadFragment(INFO_TAG) { UranusInfoFragment() }
        }

        binding.bottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.info_menu -> {
                    loadFragment(INFO_TAG) { UranusInfoFragment() }
                    true
                }

                R.id.gallery_menu -> {
                    loadFragment(GALLERY_TAG) { UranusGalleryFragment() }
                    true
                }

                R.id.satellites_menu -> {
                    loadFragment(SATELLITES_TAG) { UranusSatellitesFragment() }
                    true
                }

                else -> false
            }
        }

        return binding.root
    }

    private fun loadFragment(tag: String, fragmentFactory: () -> Fragment) {
        val cachedFragment = childFragmentManager.findFragmentByTag(tag)
        val currentFragment = childFragmentManager.findFragmentById(R.id.container)

        if (currentFragment?.tag == tag) return

        childFragmentManager.commit {
            if (currentFragment != null) {
                detach(currentFragment)
            }
            if (cachedFragment != null) {
                attach(cachedFragment)
            } else {
                replace(R.id.container, fragmentFactory(), tag)
            }
        }
    }
}