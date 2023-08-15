package ru.borodinskiy.aleksei.oursolarsystem.ui.saturn

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import dagger.hilt.android.AndroidEntryPoint
import ru.borodinskiy.aleksei.oursolarsystem.databinding.FragmentInfoBinding
import ru.borodinskiy.aleksei.oursolarsystem.enumeration.PlanetImage

@AndroidEntryPoint
class SaturnInfoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentInfoBinding.inflate(inflater, container, false)

        binding.apply {
            val image: PlanetImage = PlanetImage.SATURN
            planetImage.setImageResource(image.image)
            //           planetImage.setImageResource(R.drawable.saturn)
            planetLatinName.text = "Saturn"
            planetRusName.text = "Сатурн"
        }

        return binding.root
    }
}