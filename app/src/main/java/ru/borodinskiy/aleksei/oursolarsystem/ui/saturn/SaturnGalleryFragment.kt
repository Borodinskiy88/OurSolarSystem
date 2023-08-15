package ru.borodinskiy.aleksei.oursolarsystem.ui.saturn

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import dagger.hilt.android.AndroidEntryPoint
import ru.borodinskiy.aleksei.oursolarsystem.R
import ru.borodinskiy.aleksei.oursolarsystem.databinding.FragmentGalleryBinding

@AndroidEntryPoint
class SaturnGalleryFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentGalleryBinding.inflate(inflater, container, false)

        //TODO заглушка
        binding.fullscreenImage.setImageResource(R.drawable.saturn)

        return binding.root
    }
}