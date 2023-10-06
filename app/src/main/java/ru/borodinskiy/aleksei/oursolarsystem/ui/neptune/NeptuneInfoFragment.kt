package ru.borodinskiy.aleksei.oursolarsystem.ui.neptune

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
import ru.borodinskiy.aleksei.oursolarsystem.adapter.PlanetAdapter
import ru.borodinskiy.aleksei.oursolarsystem.adapter.PlanetListener
import ru.borodinskiy.aleksei.oursolarsystem.databinding.FragmentInfoBinding
import ru.borodinskiy.aleksei.oursolarsystem.entity.Planet
import ru.borodinskiy.aleksei.oursolarsystem.viewmodel.PlanetViewModel

@AndroidEntryPoint
class NeptuneInfoFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView

    private val viewModel: PlanetViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentInfoBinding.inflate(inflater, container, false)

        recyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        val adapter = PlanetAdapter(object : PlanetListener {
            override fun onFullImage(planet: Planet) {
                val bundle = bundleOf(
                    Pair("name", planet.latinName),
                    Pair("nameRus", planet.rusName)
                )

                findNavController().navigate(R.id.action_nav_neptune_to_fullImageFragment, bundle)
            }

        })

        recyclerView.adapter = adapter

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.getPlanetFromLatinName("Neptunus").observe(viewLifecycleOwner) { planets ->
                planets.let {
                    adapter.submitList(it)
                }
            }
        }

//        viewModel.getPlanetFromLatinName("Neptunus").observe(this.viewLifecycleOwner) { planets ->
//            planets.let {
//                adapter.submitList(it)
//            }
//        }

        return binding.root
    }
}