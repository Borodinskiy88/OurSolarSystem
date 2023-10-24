package ru.borodinskiy.aleksei.oursolarsystem.ui.fullscreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dagger.hilt.android.AndroidEntryPoint
import ru.borodinskiy.aleksei.oursolarsystem.R
import ru.borodinskiy.aleksei.oursolarsystem.databinding.FragmentPhotoDayBinding
import ru.borodinskiy.aleksei.oursolarsystem.databinding.FragmentSatellitesBinding

@AndroidEntryPoint
class PhotoDayFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentPhotoDayBinding.inflate(inflater, container, false)



        return binding.root
    }

}