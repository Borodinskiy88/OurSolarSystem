package ru.borodinskiy.aleksei.oursolarsystem.ui.earth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import dagger.hilt.android.AndroidEntryPoint
import ru.borodinskiy.aleksei.oursolarsystem.databinding.FragmentSatellitesBinding

@AndroidEntryPoint
class EarthMoonFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentSatellitesBinding.inflate(inflater, container, false)

        //TODO заглушка
    //    binding.fullscreenImage.setImageResource(R.drawable.moon)

        return binding.root
    }
}