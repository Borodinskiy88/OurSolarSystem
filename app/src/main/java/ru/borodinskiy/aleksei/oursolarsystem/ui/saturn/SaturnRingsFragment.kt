package ru.borodinskiy.aleksei.oursolarsystem.ui.saturn

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import ru.borodinskiy.aleksei.oursolarsystem.adapter.RingsAdapter
import ru.borodinskiy.aleksei.oursolarsystem.databinding.FragmentSaturnRingsBinding
import ru.borodinskiy.aleksei.oursolarsystem.viewmodel.PlanetViewModel

@AndroidEntryPoint
class SaturnRingsFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView

    private val viewModel: PlanetViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentSaturnRingsBinding.inflate(inflater, container, false)

        recyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        val adapter = RingsAdapter()

        recyclerView.adapter = adapter

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.getPlanetFromLatinName("Saturnus").observe(viewLifecycleOwner) { planets ->
                planets.let {
                    adapter.submitList(it)
                }
            }
        }

//        viewModel.getPlanetFromLatinName("Saturnus").observe(this.viewLifecycleOwner) { planets ->
//            planets.let {
//                adapter.submitList(it)
//            }
//        }

        return binding.root
    }
}