package ru.borodinskiy.aleksei.oursolarsystem.utils

import android.widget.ImageView
import ru.borodinskiy.aleksei.oursolarsystem.enumeration.PlanetImage
import ru.borodinskiy.aleksei.oursolarsystem.enumeration.SatelliteImage

object ImageObject {

    fun imagePlanetSatellite(name: String, image: ImageView) {
        when(name) {
            "Mercurius" -> image.setImageResource(PlanetImage.MERCURY.image)
            "Venus" -> image.setImageResource(PlanetImage.VENUS.image)
            "Terra" -> image.setImageResource(PlanetImage.EARTH.image)
            "Mars" -> image.setImageResource(PlanetImage.MARS.image)
            "Jupiter" -> image.setImageResource(PlanetImage.JUPITER.image)
            "Saturnus" -> image.setImageResource(PlanetImage.SATURN.image)
            "Uranus" -> image.setImageResource(PlanetImage.URANUS.image)
            "Neptunus" -> image.setImageResource(PlanetImage.NEPTUNE.image)
            "Sol" -> image.setImageResource(PlanetImage.SUN.image)
            "Moon" -> image.setImageResource(SatelliteImage.MOON.image)
            "Phobos & Deimos" -> image.setImageResource(SatelliteImage.PHOBOS.image)
            "Io" -> image.setImageResource(SatelliteImage.IO.image)
            "Europa" -> image.setImageResource(SatelliteImage.EUROPA.image)
            "Ganymede" -> image.setImageResource(SatelliteImage.GANYMEDE.image)
            "Callisto" -> image.setImageResource(SatelliteImage.CALLISTO.image)
            "Titan" -> image.setImageResource(SatelliteImage.TITAN.image)
            "Rhea" -> image.setImageResource(SatelliteImage.RHEA.image)
            "Iapetus" -> image.setImageResource(SatelliteImage.IAPETUS.image)
            "Dione" -> image.setImageResource(SatelliteImage.DIONE.image)
            "Tethys" -> image.setImageResource(SatelliteImage.TETHYS.image)
            "Enceladus" -> image.setImageResource(SatelliteImage.ENCELADUS.image)
            "Titania" -> image.setImageResource(SatelliteImage.TITANIA.image)
            "Oberon" -> image.setImageResource(SatelliteImage.OBERON.image)
            "Ariel" -> image.setImageResource(SatelliteImage.ARIEL.image)
            "Umbriel" -> image.setImageResource(SatelliteImage.UMBRIEL.image)
            "Miranda" -> image.setImageResource(SatelliteImage.MIRANDA.image)
            "Triton" -> image.setImageResource(SatelliteImage.TRITON.image)
        }
    }
}