package ru.borodinskiy.aleksei.oursolarsystem.ui.uranus

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.borodinskiy.aleksei.oursolarsystem.R
import ru.borodinskiy.aleksei.oursolarsystem.databinding.FragmentSatellitesBinding

class UranusSatellitesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentSatellitesBinding.inflate(inflater, container, false)

        //TODO заглушка
        binding.satellitesImage.setImageResource(R.drawable.satellites_uranus)

        return binding.root
    }
}