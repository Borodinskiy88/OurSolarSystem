package ru.borodinskiy.aleksei.oursolarsystem.ui.sun

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import dagger.hilt.android.AndroidEntryPoint
import ru.borodinskiy.aleksei.oursolarsystem.R
import ru.borodinskiy.aleksei.oursolarsystem.databinding.FragmentGalleryBinding
import ru.borodinskiy.aleksei.oursolarsystem.viewmodel.PhotoDayViewModel
import ru.borodinskiy.aleksei.oursolarsystem.viewmodel.PlanetImageViewModel

@AndroidEntryPoint
class SunGalleryFragment : Fragment() {

    private val viewModel: PlanetImageViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentGalleryBinding.inflate(inflater, container, false)

        viewModel.getPhotoPlanet("Sun").observe(viewLifecycleOwner) {}

        //TODO заглушка
        binding.fullscreenImage.setImageResource(R.drawable.sun)

        return binding.root
    }
}