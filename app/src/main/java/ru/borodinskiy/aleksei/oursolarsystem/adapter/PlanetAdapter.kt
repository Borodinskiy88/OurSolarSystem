package ru.borodinskiy.aleksei.oursolarsystem.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ru.borodinskiy.aleksei.oursolarsystem.databinding.FragmentInfoBinding
import ru.borodinskiy.aleksei.oursolarsystem.entity.Planet

class PlanetAdapter() :
    ListAdapter<Planet, PlanetAdapter.PlanetViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlanetViewHolder {

        return PlanetViewHolder(
            FragmentInfoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: PlanetViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    class PlanetViewHolder(
        private val binding: FragmentInfoBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(planet: Planet) {

            binding.apply {

                planetRusName.text = planet.rusName
                planetLatinName.text = planet.latinName
                namedAfter.text = planet.namedAfter
                solidSurface.text = if (planet.solidSurface) "Yes" else "No"
                minTemp.text = planet.minTemp.toString()
                maxTemp.text = planet.maxTemp.toString()
                countSatellites.text = planet.countSatellites.toString()
                size.text = planet.size.toString()
                gravity.text = planet.gravity.toString()
                durationYear.text = planet.durationYear
                durationDay.text = planet.durationDay.toString()
                fact.text = planet.fact
                info.text = planet.info
                appearance.text = planet.appearance
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