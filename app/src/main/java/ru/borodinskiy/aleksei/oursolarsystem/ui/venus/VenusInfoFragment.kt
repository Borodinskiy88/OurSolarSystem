package ru.borodinskiy.aleksei.oursolarsystem.ui.venus

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import dagger.hilt.android.AndroidEntryPoint
import ru.borodinskiy.aleksei.oursolarsystem.databinding.FragmentInfoBinding
import ru.borodinskiy.aleksei.oursolarsystem.enumeration.PlanetImage

@AndroidEntryPoint
class VenusInfoFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentInfoBinding.inflate(inflater, container, false)

        //TODO заглушка
        binding.apply {
            val image: PlanetImage = PlanetImage.VENUS
            planetImage.setImageResource(image.image)
//            planetImage.setImageResource(R.drawable.venus)
            planetRusName.text = "Венера"
            planetLatinName.text = "Venus"
        }


        return binding.root
    }
}