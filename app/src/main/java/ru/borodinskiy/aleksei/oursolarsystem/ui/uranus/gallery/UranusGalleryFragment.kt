package ru.borodinskiy.aleksei.oursolarsystem.ui.uranus.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint
import ru.borodinskiy.aleksei.oursolarsystem.R
import ru.borodinskiy.aleksei.oursolarsystem.adapter.viewpager.UranusGalleryViewPagerAdapter
import ru.borodinskiy.aleksei.oursolarsystem.databinding.FragmentGalleryBinding

@AndroidEntryPoint
class UranusGalleryFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentGalleryBinding.inflate(inflater, container, false)

        binding.viewPager.adapter = UranusGalleryViewPagerAdapter(childFragmentManager, lifecycle)
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            val feedList = listOf(
                getString(R.string.menu_uranus),
                getString(R.string.satellites),
            )
            tab.text = feedList[position]
        }.attach()

        return binding.root
    }
}