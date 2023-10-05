package ru.borodinskiy.aleksei.oursolarsystem.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ru.borodinskiy.aleksei.oursolarsystem.databinding.CardSatelliteBinding
import ru.borodinskiy.aleksei.oursolarsystem.entity.Satellite
import ru.borodinskiy.aleksei.oursolarsystem.enumeration.SatelliteImage
import ru.borodinskiy.aleksei.oursolarsystem.utils.ImageObject.imageSatellite

interface Listener {
    fun onShowDetail(satellite: Satellite)
}
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

                showMore.setOnClickListener {
                    listener.onShowDetail(satellite)
                }

                imageSatellite(satellite.engName, satelliteImage)

//                when(satellite.engName) {
//                    "Moon" -> satelliteImage.setImageResource(SatelliteImage.MOON.image)
//                    "Phobos & Deimos" -> satelliteImage.setImageResource(SatelliteImage.PHOBOS.image)
//                    "Io" -> satelliteImage.setImageResource(SatelliteImage.IO.image)
//                    "Europa" -> satelliteImage.setImageResource(SatelliteImage.EUROPA.image)
//                    "Ganymede" -> satelliteImage.setImageResource(SatelliteImage.GANYMEDE.image)
//                    "Callisto" -> satelliteImage.setImageResource(SatelliteImage.CALLISTO.image)
//                    "Titan" -> satelliteImage.setImageResource(SatelliteImage.TITAN.image)
//                    "Rhea" -> satelliteImage.setImageResource(SatelliteImage.RHEA.image)
//                    "Iapetus" -> satelliteImage.setImageResource(SatelliteImage.IAPETUS.image)
//                    "Dione" -> satelliteImage.setImageResource(SatelliteImage.DIONE.image)
//                    "Tethys" -> satelliteImage.setImageResource(SatelliteImage.TETHYS.image)
//                    "Enceladus" -> satelliteImage.setImageResource(SatelliteImage.ENCELADUS.image)
//                    "Titania" -> satelliteImage.setImageResource(SatelliteImage.TITANIA.image)
//                    "Oberon" -> satelliteImage.setImageResource(SatelliteImage.OBERON.image)
//                    "Ariel" -> satelliteImage.setImageResource(SatelliteImage.ARIEL.image)
//                    "Umbriel" -> satelliteImage.setImageResource(SatelliteImage.UMBRIEL.image)
//                    "Miranda" -> satelliteImage.setImageResource(SatelliteImage.MIRANDA.image)
//                    "Triton" -> satelliteImage.setImageResource(SatelliteImage.TRITON.image)
//                }
            }
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