package ru.borodinskiy.aleksei.oursolarsystem.ui.mars

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import dagger.hilt.android.AndroidEntryPoint
import ru.borodinskiy.aleksei.oursolarsystem.databinding.FragmentGalleryBinding

@AndroidEntryPoint
class MarsGalleryFragment : Fragment() {

    companion object {
        const val IMAGE = "image"
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentGalleryBinding.inflate(inflater, container, false)

        val image = arguments?.getString(IMAGE)?.toInt()
        //TODO заглушка
        image?.let { binding.fullscreenImage.setImageResource(it) }

        return binding.root
    }
}

