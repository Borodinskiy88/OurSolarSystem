package ru.borodinskiy.aleksei.oursolarsystem.enumeration

import ru.borodinskiy.aleksei.oursolarsystem.R

enum class SatelliteImage(val image: Int) {
    MOON(R.drawable.satell_moon),
    PHOBOS(R.drawable.satell_mars),
    IO(R.drawable.satell_jup_io),
    EUROPA(R.drawable.satell_jup_europa),
    GANYMEDE(R.drawable.satell_jup_ganymed),
    CALLISTO(R.drawable.satell_jup_callysto),
    TITAN(R.drawable.satell_sat_titan),
    RHEA(R.drawable.satell_sat_rhea),
    IAPETUS(R.drawable.satell_sat_iapetus),
    DIONE(R.drawable.satell_sat_dione),
    TETHYS(R.drawable.satell_sat_tethys),
    ENCELADUS(R.drawable.satell_sat_encelad),
    TITANIA(R.drawable.satell_uran_titania),
    OBERON(R.drawable.satell_uran_oberon),
    ARIEL(R.drawable.satell_uran_ariel),
    UMBRIEL(R.drawable.satell_uran_umbriel),
    MIRANDA(R.drawable.satell_uran_miranda),
    TRITON(R.drawable.satell_nep_triton)
}