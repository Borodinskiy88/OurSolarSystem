package ru.borodinskiy.aleksei.oursolarsystem.ui.jupiter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import ru.borodinskiy.aleksei.oursolarsystem.R
import ru.borodinskiy.aleksei.oursolarsystem.databinding.FragmentInfoBinding
import ru.borodinskiy.aleksei.oursolarsystem.enumeration.PlanetImage

@AndroidEntryPoint
class JupiterInfoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentInfoBinding.inflate(inflater, container, false)

        binding.apply {
            val image: PlanetImage = PlanetImage.JUPITER
            planetImage.setImageResource(image.image)
//            planetImage.setImageResource(R.drawable.jupiter)
            planetRusName.text = "Юпитер"
            planetLatinName.text = "Jupiter"
        }

        binding.planetImage.setOnClickListener {
            findNavController().navigate(R.id.jupiterGalleryFragment)
        }

        return binding.root
    }
}