package ru.borodinskiy.aleksei.oursolarsystem.utils

import android.widget.ImageView
import ru.borodinskiy.aleksei.oursolarsystem.enumeration.PlanetImage
import ru.borodinskiy.aleksei.oursolarsystem.enumeration.SatelliteImage

object ImageObject {

    fun imagePlanet(name: String, planetImage: ImageView) {
        when (name) {
            "Mercurius" -> planetImage.setImageResource(PlanetImage.MERCURY.image)
            "Venus" -> planetImage.setImageResource(PlanetImage.VENUS.image)
            "Terra" -> planetImage.setImageResource(PlanetImage.EARTH.image)
            "Mars" -> planetImage.setImageResource(PlanetImage.MARS.image)
            "Jupiter" -> planetImage.setImageResource(PlanetImage.JUPITER.image)
            "Saturnus" -> planetImage.setImageResource(PlanetImage.SATURN.image)
            "Uranus" -> planetImage.setImageResource(PlanetImage.URANUS.image)
            "Neptunus" -> planetImage.setImageResource(PlanetImage.NEPTUNE.image)
            "Sol" -> planetImage.setImageResource(PlanetImage.SUN.image)
        }
    }
    fun imageSatellite(name: String, satelliteImage: ImageView) {
        when(name) {
            "Moon" -> satelliteImage.setImageResource(SatelliteImage.MOON.image)
            "Phobos & Deimos" -> satelliteImage.setImageResource(SatelliteImage.PHOBOS.image)
            "Io" -> satelliteImage.setImageResource(SatelliteImage.IO.image)
            "Europa" -> satelliteImage.setImageResource(SatelliteImage.EUROPA.image)
            "Ganymede" -> satelliteImage.setImageResource(SatelliteImage.GANYMEDE.image)
            "Callisto" -> satelliteImage.setImageResource(SatelliteImage.CALLISTO.image)
            "Titan" -> satelliteImage.setImageResource(SatelliteImage.TITAN.image)
            "Rhea" -> satelliteImage.setImageResource(SatelliteImage.RHEA.image)
            "Iapetus" -> satelliteImage.setImageResource(SatelliteImage.IAPETUS.image)
            "Dione" -> satelliteImage.setImageResource(SatelliteImage.DIONE.image)
            "Tethys" -> satelliteImage.setImageResource(SatelliteImage.TETHYS.image)
            "Enceladus" -> satelliteImage.setImageResource(SatelliteImage.ENCELADUS.image)
            "Titania" -> satelliteImage.setImageResource(SatelliteImage.TITANIA.image)
            "Oberon" -> satelliteImage.setImageResource(SatelliteImage.OBERON.image)
            "Ariel" -> satelliteImage.setImageResource(SatelliteImage.ARIEL.image)
            "Umbriel" -> satelliteImage.setImageResource(SatelliteImage.UMBRIEL.image)
            "Miranda" -> satelliteImage.setImageResource(SatelliteImage.MIRANDA.image)
            "Triton" -> satelliteImage.setImageResource(SatelliteImage.TRITON.image)
        }
    }
}