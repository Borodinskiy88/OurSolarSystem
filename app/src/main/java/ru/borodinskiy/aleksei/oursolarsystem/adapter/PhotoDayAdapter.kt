package ru.borodinskiy.aleksei.oursolarsystem.adapter

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ru.borodinskiy.aleksei.oursolarsystem.databinding.CardPhotoDayBinding
import ru.borodinskiy.aleksei.oursolarsystem.entity.PhotoDay
import ru.borodinskiy.aleksei.oursolarsystem.utils.ReformatValues.reformatDate
import ru.borodinskiy.aleksei.oursolarsystem.utils.load

class PhotoDayAdapter :
    ListAdapter<PhotoDay, PhotoDayAdapter.PhotoDayViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoDayViewHolder {

        return PhotoDayViewHolder(
            CardPhotoDayBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: PhotoDayViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    class PhotoDayViewHolder(
        private val binding: CardPhotoDayBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(photoDay: PhotoDay) {

            binding.apply {

                if (photoDay.mediaType == "image") {
                    photoDay.url.let { url ->
                        image.load(url)
                    }
                }

                else if (photoDay.mediaType == "video") {
                    image.visibility = View.INVISIBLE
                    video.visibility = View.VISIBLE

                    photoDay.url.let { url ->
                        val uri = Uri.parse(url)
                        video.setVideoURI(uri)
                        video.setOnPreparedListener { mp ->
                            mp?.setVolume(0F, 0F)
                            mp?.isLooping = true
                            video.start()
                        }
                    }

                    //todo
//                    favor.isChecked = photoDay.favorite

//                    val uri = Uri.parse(photoDay.url)
//                    video.setVideoURI(uri)
//                    video.start()
//                    video.setOnPreparedListener { mp ->
//                        mp?.setVolume(0F, 0F)
//                        mp?.isLooping = true
//                        video.start()
//                    }

//                    video.setVideoURI(Uri.parse(photoDay.url))
//                    val mediaController = MediaController(requireContext())
//                    mediaController.setAnchorView(video)
//                    mediaController.setMediaPlayer(video)
//                    video.setMediaController(mediaController)
//                    video.start()
                }

                date.text = reformatDate(photoDay.date)
                title.text = photoDay.title
            }
        }
    }

    companion object {
        private val DiffCallback = object : DiffUtil.ItemCallback<PhotoDay>() {
            override fun areItemsTheSame(oldItem: PhotoDay, newItem: PhotoDay): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: PhotoDay, newItem: PhotoDay): Boolean {
                return oldItem == newItem
            }
        }
    }
}