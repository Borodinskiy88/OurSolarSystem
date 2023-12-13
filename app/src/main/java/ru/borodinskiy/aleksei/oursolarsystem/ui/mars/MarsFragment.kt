package ru.borodinskiy.aleksei.oursolarsystem.ui.mars

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import dagger.hilt.android.AndroidEntryPoint
import ru.borodinskiy.aleksei.oursolarsystem.R
import ru.borodinskiy.aleksei.oursolarsystem.databinding.FragmentMarsBinding
import ru.borodinskiy.aleksei.oursolarsystem.ui.mars.gallery.MarsGalleryFragment

@AndroidEntryPoint
class MarsFragment : Fragment() {

    private companion object {
        const val INFO_TAG = "INFO_TAG"
        const val GALLERY_TAG = "GALLERY_TAG"
        const val TERRAFORM_TAG = "TERRAFORM_TAG"
        const val SATELLITES_TAG = "SATELLITES_TAG"
        const val ROVER_TAG = "ROVER_TAG"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentMarsBinding.inflate(inflater, container, false)

        if (childFragmentManager.findFragmentById(R.id.container) == null) {
            loadFragment(INFO_TAG) { MarsInfoFragment() }
        }

        binding.bottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.info_menu -> {
                    loadFragment(INFO_TAG) { MarsInfoFragment() }
                    true
                }

                R.id.gallery_menu -> {
                    loadFragment(GALLERY_TAG) { MarsGalleryFragment() }
                    true
                }

                R.id.terraform_menu -> {
                    loadFragment(TERRAFORM_TAG) { MarsTerraformFragment() }
                    true
                }

                R.id.satellites_menu -> {
                    loadFragment(SATELLITES_TAG) { MarsSatellitesFragment() }
                    true
                }

                R.id.mars_rover_menu -> {
                    loadFragment(ROVER_TAG) { MarsRoverFragment() }
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