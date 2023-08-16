package ru.borodinskiy.aleksei.oursolarsystem.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ru.borodinskiy.aleksei.oursolarsystem.R
import ru.borodinskiy.aleksei.oursolarsystem.databinding.CardTerraformBinding
import ru.borodinskiy.aleksei.oursolarsystem.entity.Planet
import ru.borodinskiy.aleksei.oursolarsystem.enumeration.RingsTerraformImage

class TerraformAdapter :
    ListAdapter<Planet, TerraformAdapter.TerraformViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TerraformViewHolder {

        return TerraformViewHolder(
            CardTerraformBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: TerraformViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    class TerraformViewHolder(
        private val binding: CardTerraformBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(planet: Planet) {

            binding.apply {
                when (planet.latinName) {
                    "Venus" -> terraformImage.setImageResource(RingsTerraformImage.VENUS_TERRAFORM.image)
                    "Mars" -> terraformImage.setImageResource(RingsTerraformImage.MARS_TERRAFORM.image)
                }

                terraformName.setText(R.string.terraform)
                terraformText.text = planet.terraform
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