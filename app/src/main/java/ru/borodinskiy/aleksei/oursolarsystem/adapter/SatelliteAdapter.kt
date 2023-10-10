package ru.borodinskiy.aleksei.oursolarsystem.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ru.borodinskiy.aleksei.oursolarsystem.R
import ru.borodinskiy.aleksei.oursolarsystem.databinding.CardSatelliteBinding
import ru.borodinskiy.aleksei.oursolarsystem.entity.Satellite
import ru.borodinskiy.aleksei.oursolarsystem.utils.ImageObject.imagePlanetSatellite

interface SatelliteListener {
    fun onShowDetail(satellite: Satellite)

    fun onFullImage(satellite: Satellite)
}

var flag = false
class SatelliteAdapter(
    private val satelliteListener: SatelliteListener
) :
    ListAdapter<Satellite, SatelliteAdapter.SatelliteViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SatelliteViewHolder {

        return SatelliteViewHolder(
            CardSatelliteBinding.inflate(LayoutInflater.from(parent.context), parent, false),
            satelliteListener
        )
    }

    override fun onBindViewHolder(holder: SatelliteViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    class SatelliteViewHolder(
        private val binding: CardSatelliteBinding,
        private val satelliteListener: SatelliteListener
    ) : RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("ResourceAsColor")
        fun bind(satellite: Satellite) {

            binding.apply {

                satelliteRusName.text = satellite.rusName
                satelliteLatinName.text = satellite.engName

                namedAfter.text = satellite.namedAfter
                fact.text = satellite.fact
                minTemp.text = satellite.minTemp
                maxTemp.text = satellite.maxTemp
                size.text = satellite.size
                info.text = satellite.info

                if (satellite.engPlanet == "Mars") {
                    satelliteRusName.textSize = 19F
                    satelliteLatinName.textSize = 17F
                    showMore.textSize = 15F
                }

                showMore.setOnClickListener {
                    satelliteListener.onShowDetail(satellite)
                    flag = true
                }

                satelliteImage.setOnClickListener {
                    satelliteListener.onFullImage(satellite)
                }

                imagePlanetSatellite(satellite.engName, satelliteImage)

                if (flag) {

                    showMore.isVisible = false
                    moreInfo.isVisible = true
                    constraint.setBackgroundResource(R.drawable.background_black)
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