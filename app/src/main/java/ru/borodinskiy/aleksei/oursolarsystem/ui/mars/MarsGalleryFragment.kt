package ru.borodinskiy.aleksei.oursolarsystem.ui.mars

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import dagger.hilt.android.AndroidEntryPoint
import ru.borodinskiy.aleksei.oursolarsystem.databinding.FragmentFullImageBinding
import ru.borodinskiy.aleksei.oursolarsystem.enumeration.PlanetImage

@AndroidEntryPoint
class MarsGalleryFragment : Fragment() {

    companion object {
        const val IMAGE = "image"
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentFullImageBinding.inflate(inflater, container, false)

        val image = arguments?.getString(IMAGE)?.toInt()
        //TODO заглушка
        binding.fullscreenImage.setImageResource(PlanetImage.MARS.image)

        return binding.root
    }
}

