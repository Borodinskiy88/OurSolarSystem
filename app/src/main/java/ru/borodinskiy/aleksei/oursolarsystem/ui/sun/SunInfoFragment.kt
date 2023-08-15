package ru.borodinskiy.aleksei.oursolarsystem.ui.sun

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import dagger.hilt.android.AndroidEntryPoint
import ru.borodinskiy.aleksei.oursolarsystem.databinding.FragmentInfoBinding
import ru.borodinskiy.aleksei.oursolarsystem.enumeration.PlanetImage

@AndroidEntryPoint
class SunInfoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentInfoBinding.inflate(inflater, container, false)

        binding.apply {
            val image: PlanetImage = PlanetImage.SUN
            planetImage.setImageResource(image.image)
//            planetImage.setImageResource(R.drawable.sun)
            planetRusName.text = "Солнце"
            planetLatinName.text = "Sol"
        }

        //TODO объединить в группу
        binding.apply {
            durationDayHeadline.isVisible = false
            durationDay.isVisible = false
            durationYearHeadline.isVisible = false
            durationYear.isVisible = false
            appearanceHeadline.isVisible = false
            appearance.isVisible = false
        }


        return binding.root
    }
}