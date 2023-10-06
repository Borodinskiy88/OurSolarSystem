package ru.borodinskiy.aleksei.oursolarsystem.ui.fullscreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
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
class SingleSatelliteFragment : Fragment() {

    companion object {
        const val SATELLITE_ID = "satelliteId"
        const val PLANET = "planet"
    }

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
                return
            }

            override fun onFullImage(satellite: Satellite) {
                val bundle = bundleOf(
                    Pair("name", satellite.engName),
                    Pair("nameRus", satellite.rusName)
                )

                findNavController().navigate(R.id.action_singleSatelliteFragment_to_fullImageFragment, bundle)
            }

        })

        recyclerView.adapter = adapter

        val satelliteId = arguments?.getInt(SATELLITE_ID)
        val planet = arguments?.getString(PLANET)

        (activity as AppCompatActivity).supportActionBar?.title = planet

        viewLifecycleOwner.lifecycleScope.launch {
            satelliteId?.let {
                viewModel.getSatelliteById(it).observe(viewLifecycleOwner) { planets ->
                    planets.let { satellite ->
                        adapter.submitList(satellite)
                    }
                }
            }
        }

        return binding.root
    }
}