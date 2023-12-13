package ru.borodinskiy.aleksei.oursolarsystem.ui.saturn.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint
import ru.borodinskiy.aleksei.oursolarsystem.R
import ru.borodinskiy.aleksei.oursolarsystem.adapter.viewpager.SaturnGalleryViewPagerAdapter
import ru.borodinskiy.aleksei.oursolarsystem.databinding.FragmentGalleryBinding

@AndroidEntryPoint
class SaturnGalleryFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentGalleryBinding.inflate(inflater, container, false)

        binding.viewPager.adapter = SaturnGalleryViewPagerAdapter(childFragmentManager, lifecycle)
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            val feedList = listOf(
                getString(R.string.menu_saturn),
                getString(R.string.satellites),
            )
            tab.text = feedList[position]
        }.attach()

        return binding.root
    }
}