package ru.borodinskiy.aleksei.oursolarsystem.ui.photoday

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint
import ru.borodinskiy.aleksei.oursolarsystem.R
import ru.borodinskiy.aleksei.oursolarsystem.adapter.viewpager.PhotoDayViewPagerAdapter
import ru.borodinskiy.aleksei.oursolarsystem.databinding.FragmentPhotoDayBinding

@AndroidEntryPoint
class PhotoDayFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentPhotoDayBinding.inflate(inflater, container, false)

        binding.viewPager.adapter = PhotoDayViewPagerAdapter(childFragmentManager, lifecycle)
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            val feedList = listOf(
                getString(R.string.today),
                getString(R.string.archive),
            )
            tab.text = feedList[position]
        }.attach()

        return binding.root
    }

}