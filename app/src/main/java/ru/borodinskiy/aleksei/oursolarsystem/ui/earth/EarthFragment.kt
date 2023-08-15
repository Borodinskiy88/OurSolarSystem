package ru.borodinskiy.aleksei.oursolarsystem.ui.earth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import dagger.hilt.android.AndroidEntryPoint
import ru.borodinskiy.aleksei.oursolarsystem.R
import ru.borodinskiy.aleksei.oursolarsystem.databinding.FragmentEarthBinding

@AndroidEntryPoint
class EarthFragment : Fragment() {

    private companion object {
        const val INFO_TAG = "INFO_TAG"
        const val GALLERY_TAG = "GALLERY_TAG"
        const val COSMO_TAG = "COSMO_TAG"
        const val MOON_TAG = "MOON_TAG"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentEarthBinding.inflate(inflater, container, false)

        if (childFragmentManager.findFragmentById(R.id.container) == null) {
            loadFragment(INFO_TAG) { EarthInfoFragment() }
        }

        binding.bottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.info_menu -> {
                    loadFragment(INFO_TAG) { EarthInfoFragment() }
                    true
                }

                R.id.gallery_menu -> {
                    loadFragment(GALLERY_TAG) { EarthGalleryFragment() }
                    true
                }

                R.id.astronautics_menu -> {
                    loadFragment(COSMO_TAG) { EarthCosmoFragment() }
                    true
                }

                R.id.moon_menu -> {
                    loadFragment(MOON_TAG) { EarthMoonFragment() }
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