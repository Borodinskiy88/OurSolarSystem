package ru.borodinskiy.aleksei.oursolarsystem.adapter

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ru.borodinskiy.aleksei.oursolarsystem.R
import ru.borodinskiy.aleksei.oursolarsystem.databinding.CardPhotoDayBinding
import ru.borodinskiy.aleksei.oursolarsystem.entity.PhotoDay
import ru.borodinskiy.aleksei.oursolarsystem.utils.ReformatValues.reformatDate
import ru.borodinskiy.aleksei.oursolarsystem.utils.load

interface PhotoListener {
    fun onShowSmall(photoDay: PhotoDay)
    fun onDelete(photoDay: PhotoDay)
    fun photoForMonth()
    fun photoForTenDays()

}
class PhotoDayAdapter(
    private val photoListener: PhotoListener
) :
    ListAdapter<PhotoDay, PhotoDayAdapter.PhotoDayViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoDayViewHolder {

        return PhotoDayViewHolder(
            CardPhotoDayBinding.inflate(LayoutInflater.from(parent.context), parent, false),
            photoListener
        )
    }

    override fun onBindViewHolder(holder: PhotoDayViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    class PhotoDayViewHolder(
        private val binding: CardPhotoDayBinding,
        private val photoListener: PhotoListener
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
//
//                    video.setVideoURI(Uri.parse(photoDay.url))
//                    val mediaController = MediaController(requireContext())
//                    mediaController.setAnchorView(video)
//                    mediaController.setMediaPlayer(video)
//                    video.setMediaController(mediaController)
//                    video.start()
                }

                date.text = reformatDate(photoDay.date)
                title.text = photoDay.title

                image.setOnClickListener {

                    photoListener.onShowSmall(photoDay)
                }

                menu.setOnClickListener {
                    PopupMenu(it.context, it).apply {
                        inflate(R.menu.photo_day_menu)
                        setOnMenuItemClickListener { item ->
                            when (item.itemId) {
                                R.id.delete_photo -> {
                                    photoListener.onDelete(photoDay)
                                    true
                                }

                                R.id.add_photo_10 -> {
                                    photoListener.photoForTenDays()
                                    true
                                }

                                R.id.add_photo_30 -> {
                                    photoListener.photoForMonth()
                                    true
                                }

                                else -> false
                            }
                        }
                    }.show()
                }
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