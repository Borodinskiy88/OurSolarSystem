package ru.borodinskiy.aleksei.oursolarsystem.ui.venus

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import ru.borodinskiy.aleksei.oursolarsystem.R
import ru.borodinskiy.aleksei.oursolarsystem.databinding.FragmentVenusBinding

class VenusFragment : Fragment() {

    private companion object {
        const val INFO_TAG = "INFO_TAG"
        const val GALLERY_TAG = "GALLERY_TAG"
        const val TERRAFORM_TAG = "TERRAFORM_TAG"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentVenusBinding.inflate(inflater, container, false)

        if (childFragmentManager.findFragmentById(R.id.container) == null) {
            loadFragment(INFO_TAG) { VenusInfoFragment() }
        }

        binding.bottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.info_menu -> {
                    loadFragment(INFO_TAG) { VenusInfoFragment() }
                    true
                }

                R.id.gallery_menu -> {
                    loadFragment(GALLERY_TAG) { VenusGalleryFragment() }
                    true
                }

                R.id.terraform_menu -> {
                    loadFragment(TERRAFORM_TAG) { VenusTerraformFragment() }
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