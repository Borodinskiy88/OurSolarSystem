package ru.borodinskiy.aleksei.oursolarsystem.ui.fullscreen


import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.MediaController
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import ru.borodinskiy.aleksei.oursolarsystem.R
import ru.borodinskiy.aleksei.oursolarsystem.databinding.FragmentGalleryBinding
import ru.borodinskiy.aleksei.oursolarsystem.databinding.FragmentVideoBinding
import ru.borodinskiy.aleksei.oursolarsystem.utils.ImageObject

@AndroidEntryPoint
class VideoFragment : Fragment() {

    companion object {
        const val URL = "url"
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentVideoBinding.inflate(inflater, container, false)

        val urlAttachment = arguments?.getString(URL)

        binding.apply {
            video.setVideoURI(Uri.parse(urlAttachment))
            val mediaController = MediaController(requireContext())
            mediaController.setAnchorView(video)
            mediaController.setMediaPlayer(video)
            video.setMediaController(mediaController)
            video.start()
        }

        return binding.root
    }
}