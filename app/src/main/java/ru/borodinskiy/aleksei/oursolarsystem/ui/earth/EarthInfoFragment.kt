package ru.borodinskiy.aleksei.oursolarsystem.ui.earth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.android.AndroidEntryPoint
import ru.borodinskiy.aleksei.oursolarsystem.adapter.PlanetAdapter
import ru.borodinskiy.aleksei.oursolarsystem.databinding.FragmentInfoBinding
import ru.borodinskiy.aleksei.oursolarsystem.viewmodel.PlanetViewModel

@AndroidEntryPoint
class EarthInfoFragment : Fragment() {

    private val viewModel: PlanetViewModel by activityViewModels()

    private lateinit var recyclerView: RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentInfoBinding.inflate(inflater, container, false)

        recyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        val adapter = PlanetAdapter()

        recyclerView.adapter = adapter

        viewModel.getPlanetFromLatinName("Terra").observe(this.viewLifecycleOwner) { planets ->
            planets.let {
                adapter.submitList(it)
            }
        }

        binding.apply {
//            val image: PlanetImage = PlanetImage.EARTH
//            planetImage.setImageResource(image.image)

//            planetRusName.text = planet.value?.rusName
//            planetLatinName.text = planet.value?.latinName
//            namedAfter.text = planet.value?.namedAfter
//            solidSurface.text = if (planet.value?.solidSurface == true) "Yes" else "No"
//            minTemp.text = planet.value?.minTemp.toString()
//            maxTemp.text = planet.value?.maxTemp.toString()
//            countSatellites.text = planet.value?.countSatellites.toString()
//            size.text = planet.value?.size.toString()
//            gravity.text = planet.value?.gravity.toString()
//            durationYear.text = planet.value?.durationYear
//            durationDay.text = planet.value?.durationDay.toString()
//            fact.text = planet.value?.fact
//            info.text = planet.value?.info
//            appearance.text = planet.value?.appearance
        }

//        binding.planetImage.setOnClickListener {
//            findNavController().navigate(R.id.earthGalleryFragment)
//        }

        return binding.root
    }
}