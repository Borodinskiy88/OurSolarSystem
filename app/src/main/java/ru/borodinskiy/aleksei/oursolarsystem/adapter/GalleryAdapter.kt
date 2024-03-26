package ru.borodinskiy.aleksei.oursolarsystem.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ru.borodinskiy.aleksei.oursolarsystem.databinding.CardGalleryBinding
import ru.borodinskiy.aleksei.oursolarsystem.entity.Image
import ru.borodinskiy.aleksei.oursolarsystem.utils.ReformatValues.reformatDate
import ru.borodinskiy.aleksei.oursolarsystem.utils.loadHttps

class GalleryAdapter :
    ListAdapter<Image, GalleryAdapter.GalleryViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GalleryViewHolder {

        return GalleryViewHolder(
            CardGalleryBinding.inflate(LayoutInflater.from(parent.context), parent, false),
        )
    }

    override fun onBindViewHolder(holder: GalleryViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    class GalleryViewHolder(
        private val binding: CardGalleryBinding,
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(image: Image) {

            binding.apply {

                photo.loadHttps(image.url)
                date.text = reformatDate(image.date)
                title.text = image.title
                info.text = image.info

                infoImage.setOnClickListener {

                    info.visibility = View.VISIBLE
                    hideInfo.visibility = View.VISIBLE

                }


                hideInfo.setOnClickListener {

                    info.visibility = View.GONE
                    hideInfo.visibility = View.GONE
                }
            }
        }
    }

    companion object {
        private val DiffCallback = object : DiffUtil.ItemCallback<Image>() {
            override fun areItemsTheSame(oldItem: Image, newItem: Image): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Image, newItem: Image): Boolean {
                return oldItem == newItem
            }
        }
    }
}