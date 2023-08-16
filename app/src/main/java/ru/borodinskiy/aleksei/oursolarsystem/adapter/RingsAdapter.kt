package ru.borodinskiy.aleksei.oursolarsystem.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ru.borodinskiy.aleksei.oursolarsystem.R
import ru.borodinskiy.aleksei.oursolarsystem.databinding.CardRingsBinding
import ru.borodinskiy.aleksei.oursolarsystem.entity.Planet
import ru.borodinskiy.aleksei.oursolarsystem.enumeration.RingsTerraformImage

class RingsAdapter :
    ListAdapter<Planet, RingsAdapter.RingsViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RingsViewHolder {

        return RingsViewHolder(
            CardRingsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: RingsViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    class RingsViewHolder(
        private val binding: CardRingsBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(planet: Planet) {

            binding.apply {

                ringsName.setText(R.string.rings_of_saturn)
                ringsText.text = planet.rings
                ringsImage.setImageResource(RingsTerraformImage.SATURN_RINGS.image)
            }
        }
    }

    companion object {
        private val DiffCallback = object : DiffUtil.ItemCallback<Planet>() {
            override fun areItemsTheSame(oldItem: Planet, newItem: Planet): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Planet, newItem: Planet): Boolean {
                return oldItem == newItem
            }
        }
    }
}