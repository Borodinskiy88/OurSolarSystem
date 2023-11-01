package ru.borodinskiy.aleksei.oursolarsystem.ui.fullscreen


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import dagger.hilt.android.AndroidEntryPoint
import ru.borodinskiy.aleksei.oursolarsystem.databinding.FragmentVideoBinding
import ru.borodinskiy.aleksei.oursolarsystem.utils.ReformatValues.reformatWebLink

@AndroidEntryPoint
class VideoFragment : Fragment() {

    companion object {
        const val RUS_NAME = "nameRus"
        const val URL = "url"
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentVideoBinding.inflate(inflater, container, false)

        val url = arguments?.getString(URL)
        val rusName = arguments?.getString(FullImageFragment.RUS_NAME)

        (activity as AppCompatActivity).supportActionBar?.title = rusName

        val youTubePlayerView = binding.videoPlayer

        lifecycle.addObserver(youTubePlayerView)

//        "https://www.youtube.com/embed/J3_88eyN44w?rel=0"

        val videoId = reformatWebLink(url.toString())

        youTubePlayerView.addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
            override fun onReady(youTubePlayer: YouTubePlayer) {

                youTubePlayer.loadVideo(videoId, 0f)
            }
        })

        return binding.root
    }
}