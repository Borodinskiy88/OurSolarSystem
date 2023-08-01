package ru.borodinskiy.aleksei.oursolarsystem.ui.jupiter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.borodinskiy.aleksei.oursolarsystem.R
import ru.borodinskiy.aleksei.oursolarsystem.databinding.FragmentInfoBinding

class JupiterInfoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentInfoBinding.inflate(inflater, container, false)

        binding.apply {
            planetImage.setImageResource(R.drawable.jupiter)
            planetRusName.text = "Юпитер"
            planetLatinName.text = "Jupiter"
        }

        return binding.root
    }
}