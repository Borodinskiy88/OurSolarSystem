package ru.borodinskiy.aleksei.oursolarsystem.ui.jupiter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import dagger.hilt.android.AndroidEntryPoint
import ru.borodinskiy.aleksei.oursolarsystem.R
import ru.borodinskiy.aleksei.oursolarsystem.databinding.FragmentFullImageBinding

@AndroidEntryPoint
class JupiterGalleryFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentFullImageBinding.inflate(inflater, container, false)

        //TODO заглушка
        binding.fullscreenImage.setImageResource(R.drawable.jupiter)

        return binding.root
    }
}