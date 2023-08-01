package ru.borodinskiy.aleksei.oursolarsystem.ui.neptune

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.borodinskiy.aleksei.oursolarsystem.R
import ru.borodinskiy.aleksei.oursolarsystem.databinding.FragmentInfoBinding

class NeptuneInfoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentInfoBinding.inflate(inflater, container, false)

        binding.apply {
            planetImage.setImageResource(R.drawable.neptun)
            planetLatinName.text = "Neptune"
            planetRusName.text = "Нептун"
        }

        return binding.root
    }
}