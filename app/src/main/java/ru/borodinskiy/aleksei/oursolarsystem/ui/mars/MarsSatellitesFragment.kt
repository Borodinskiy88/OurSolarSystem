package ru.borodinskiy.aleksei.oursolarsystem.ui.mars

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
import ru.borodinskiy.aleksei.oursolarsystem.adapter.Listener
import ru.borodinskiy.aleksei.oursolarsystem.adapter.SatelliteAdapter
import ru.borodinskiy.aleksei.oursolarsystem.databinding.FragmentSatellitesBinding
import ru.borodinskiy.aleksei.oursolarsystem.entity.Satellite
import ru.borodinskiy.aleksei.oursolarsystem.viewmodel.SatelliteViewModel

@AndroidEntryPoint
class MarsSatellitesFragment : Fragment() {

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
        val adapter = SatelliteAdapter(object : Listener {

            override fun onShowDetail(satellite: Satellite) {
                val bundle = bundleOf(
                    Pair("satelliteId", satellite.id),
                    Pair("planet", satellite.planet)
                )

                findNavController().navigate(R.id.action_nav_mars_to_singleSatelliteFragment, bundle)
            }

        })

        recyclerView.adapter = adapter

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.getSatelliteFromPlanet("Mars").observe(viewLifecycleOwner) { planets ->
                planets.let {
                    adapter.submitList(it)
                }
            }
        }

        return binding.root
    }
}