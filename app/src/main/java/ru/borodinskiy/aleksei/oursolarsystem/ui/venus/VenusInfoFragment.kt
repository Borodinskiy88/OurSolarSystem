package ru.borodinskiy.aleksei.oursolarsystem.ui.venus

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.borodinskiy.aleksei.oursolarsystem.R
import ru.borodinskiy.aleksei.oursolarsystem.databinding.CardPlanetsBinding

class VenusInfoFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = CardPlanetsBinding.inflate(inflater, container, false)

        //TODO заглушка
        binding.apply {
            planetImage.setImageResource(R.drawable.venus)
            planetRusName.text = "Венера"
            planetLatinName.text = "Venus"
        }


        return binding.root
    }
}