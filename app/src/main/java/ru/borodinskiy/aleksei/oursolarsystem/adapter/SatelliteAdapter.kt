package ru.borodinskiy.aleksei.oursolarsystem.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.core.view.marginEnd
import androidx.core.view.marginTop
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ru.borodinskiy.aleksei.oursolarsystem.databinding.CardSatelliteBinding
import ru.borodinskiy.aleksei.oursolarsystem.entity.Satellite
import ru.borodinskiy.aleksei.oursolarsystem.enumeration.SatelliteImage
import ru.borodinskiy.aleksei.oursolarsystem.utils.ImageObject.imageSatellite
import ru.borodinskiy.aleksei.oursolarsystem.utils.ReformatValues.reformatCount

interface Listener {
    fun onShowDetail(satellite: Satellite)
}

var flag = false
class SatelliteAdapter(
    private val listener: Listener
) :
    ListAdapter<Satellite, SatelliteAdapter.SatelliteViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SatelliteViewHolder {

        return SatelliteViewHolder(
            CardSatelliteBinding.inflate(LayoutInflater.from(parent.context), parent, false),
            listener
        )
    }

    override fun onBindViewHolder(holder: SatelliteViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    class SatelliteViewHolder(
        private val binding: CardSatelliteBinding,
        private val listener: Listener
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(satellite: Satellite) {

            binding.apply {

                satelliteRusName.text = satellite.rusName
                satelliteLatinName.text = satellite.engName

                namedAfter.text = satellite.namedAfter
                fact.text = satellite.fact
                minTemp.text = reformatCount(satellite.minTemp)
                maxTemp.text = reformatCount(satellite.maxTemp)
                size.text = satellite.size
                info.text = satellite.info

                if (satellite.engPlanet == "Mars") {
                    satelliteRusName.textSize = 20F
                    satelliteLatinName.textSize = 18F
                    showMore.textSize = 15F
                }

                showMore.setOnClickListener {
                    listener.onShowDetail(satellite)
                    flag = true
                }

                imageSatellite(satellite.engName, satelliteImage)

                if (flag) {

                    showMore.isVisible = false
                    moreInfo.isVisible = true
                }
            }

            flag = false
        }
    }

    companion object {
        private val DiffCallback = object : DiffUtil.ItemCallback<Satellite>() {
            override fun areItemsTheSame(oldItem: Satellite, newItem: Satellite): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Satellite, newItem: Satellite): Boolean {
                return oldItem == newItem
            }
        }
    }
}