package ru.borodinskiy.aleksei.oursolarsystem.ui.mars

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import ru.borodinskiy.aleksei.oursolarsystem.R
import ru.borodinskiy.aleksei.oursolarsystem.databinding.FragmentInfoBinding
import ru.borodinskiy.aleksei.oursolarsystem.enumeration.PlanetImage

@AndroidEntryPoint
class MarsInfoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentInfoBinding.inflate(inflater, container, false)


        binding.apply {
            val image: PlanetImage = PlanetImage.MARS
            planetImage.setImageResource(image.image)
            //           planetImage.setImageResource(R.drawable.mars)
            planetLatinName.text = "Mars"
            planetRusName.text = "Марс"
        }

        binding.planetImage.setOnClickListener {
            val bundle = bundleOf(
                "image" to R.drawable.mars
            )
            findNavController().navigate(R.id.marsGalleryFragment, bundle)
        }

        return binding.root
    }
}