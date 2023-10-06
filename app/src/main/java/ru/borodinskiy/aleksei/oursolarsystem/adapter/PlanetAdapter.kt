package ru.borodinskiy.aleksei.oursolarsystem.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ru.borodinskiy.aleksei.oursolarsystem.R
import ru.borodinskiy.aleksei.oursolarsystem.databinding.CardPlanetBinding
import ru.borodinskiy.aleksei.oursolarsystem.entity.Planet
import ru.borodinskiy.aleksei.oursolarsystem.entity.Satellite
import ru.borodinskiy.aleksei.oursolarsystem.utils.ImageObject.imagePlanetSatellite
import ru.borodinskiy.aleksei.oursolarsystem.utils.ReformatValues.reformatCount

interface PlanetListener {

    fun onFullImage(planet: Planet)
}
class PlanetAdapter(
    private val planetListener: PlanetListener
) :
    ListAdapter<Planet, PlanetAdapter.PlanetViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlanetViewHolder {

        return PlanetViewHolder(
            CardPlanetBinding.inflate(LayoutInflater.from(parent.context), parent, false),
            planetListener
        )
    }

    override fun onBindViewHolder(holder: PlanetViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    class PlanetViewHolder(
        private val binding: CardPlanetBinding,
        private val planetListener: PlanetListener
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(planet: Planet) {

            binding.apply {

                imagePlanetSatellite(planet.latinName, planetImage)

                planetRusName.text = planet.rusName
                planetLatinName.text = planet.latinName
                namedAfter.text = planet.namedAfter
                if (planet.solidSurface) solidSurface.setText(R.string.yes) else solidSurface.setText(
                    R.string.no
                )
                minTemp.text = reformatCount(planet.minTemp)
                maxTemp.text = reformatCount(planet.maxTemp)
                countSatellites.text = planet.countSatellites.toString()
                size.text = planet.size
                gravity.text = planet.gravity
                durationYear.text = planet.durationYear
                durationDay.text = planet.durationDay
                fact.text = planet.fact
                info.text = planet.info
                appearance.text = planet.appearance

                if (planet.latinName == "Sol") {
                    durationDayHeadline.isVisible = false
                    durationDay.isVisible = false
                    durationYearHeadline.isVisible = false
                    durationYear.isVisible = false
                    appearanceHeadline.isVisible = false
                    appearance.isVisible = false
                }

                if (planet.latinName == "Mercurius") {
                    planetRusName.textSize = 32F
                    planetLatinName.textSize = 28F
                }

                planetImage.setOnClickListener {
                    planetListener.onFullImage(planet)
                }

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