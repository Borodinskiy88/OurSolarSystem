package ru.borodinskiy.aleksei.oursolarsystem.ui.saturn

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import ru.borodinskiy.aleksei.oursolarsystem.R
import ru.borodinskiy.aleksei.oursolarsystem.adapter.SatelliteListener
import ru.borodinskiy.aleksei.oursolarsystem.adapter.SatelliteAdapter
import ru.borodinskiy.aleksei.oursolarsystem.databinding.FragmentSatellitesBinding
import ru.borodinskiy.aleksei.oursolarsystem.entity.Satellite
import ru.borodinskiy.aleksei.oursolarsystem.viewmodel.SatelliteViewModel

@AndroidEntryPoint
class SaturnSatellitesFragment : Fragment() {

    private val viewModel: SatelliteViewModel by activityViewModels()
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentSatellitesBinding.inflate(inflater, container, false)

        recyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        val adapter = SatelliteAdapter(object : SatelliteListener {

            override fun onShowDetail(satellite: Satellite) {
                val bundle = bundleOf(
                    Pair("satelliteId", satellite.id),
                    Pair("planet", satellite.planet)
                )

                findNavController().navigate(R.id.action_nav_saturn_to_singleSatelliteFragment, bundle)
            }

            override fun onFullImage(satellite: Satellite) {
                val bundle = bundleOf(
                    Pair("name", satellite.engName),
                    Pair("nameRus", satellite.rusName)
                )

                findNavController().navigate(R.id.action_nav_saturn_to_fullImageFragment, bundle)
            }

        })

        recyclerView.adapter = adapter


        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.getSatelliteFromPlanet("Saturn").observe(viewLifecycleOwner) { planets ->
                planets.let {
                    adapter.submitList(it)
                }
            }
        }

        return binding.root
    }
}