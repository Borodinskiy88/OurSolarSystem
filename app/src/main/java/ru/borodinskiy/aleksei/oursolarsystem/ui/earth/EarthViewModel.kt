package ru.borodinskiy.aleksei.oursolarsystem.ui.earth

//private val empty = Planet(
//    id = 0,
//    rusName = "",
//    latinName = "",
//    solidSurface = false,
//    minTemp = 0,
//    maxTemp = 0,
//    countSatellites = 0,
//    size = 0.0,
//    gravity = 0.0,
//    durationYear = "",
//    durationDay = 0.0,
//    fact = "",
//    info = "",
//    appearance = "",
//    rings = null,
//    terraform = null
//)

//class EarthViewModel(private val earthRepository: EarthRepository) : ViewModel() {
//
//    private val _editedEvent = MutableLiveData(empty)
//    val editedEvent: LiveData<PlanetEntity>
//        get() = _editedEvent
//
//    fun earthPlanet(latinName: String) {
//        editedEvent.also { earthRepository.earthPlanet(latinName) = it }
//    }
//
//    private val _text = MutableLiveData<String>().apply {
//        value = "This is slideshow Fragment"
//    }
//    val text: LiveData<String> = _text
//}