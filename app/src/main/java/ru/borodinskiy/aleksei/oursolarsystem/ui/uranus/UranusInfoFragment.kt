package ru.borodinskiy.aleksei.oursolarsystem.ui.uranus

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.borodinskiy.aleksei.oursolarsystem.R
import ru.borodinskiy.aleksei.oursolarsystem.databinding.FragmentInfoBinding

class UranusInfoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentInfoBinding.inflate(inflater, container, false)

        binding.apply {
            planetImage.setImageResource(R.drawable.uranus)
            planetLatinName.text = "Uranus"
            planetRusName.text = "Уран"
        }

        return binding.root
    }
}