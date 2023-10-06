package ru.borodinskiy.aleksei.oursolarsystem.ui.fullscreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import dagger.hilt.android.AndroidEntryPoint
import ru.borodinskiy.aleksei.oursolarsystem.databinding.FragmentGalleryBinding
import ru.borodinskiy.aleksei.oursolarsystem.utils.ImageObject.imagePlanetSatellite

@AndroidEntryPoint
class FullImageFragment : Fragment() {

    companion object {
        const val NAME = "name"
        const val RUS_NAME = "nameRus"
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentGalleryBinding.inflate(inflater, container, false)

        val image = arguments?.getString(NAME)
        val rusName = arguments?.getString(RUS_NAME)

        (activity as AppCompatActivity).supportActionBar?.title = rusName

        image?.let { imagePlanetSatellite(it, binding.fullscreenImage) }

        return binding.root
    }
}