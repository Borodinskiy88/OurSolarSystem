package ru.borodinskiy.aleksei.oursolarsystem.ui.mars

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
import ru.borodinskiy.aleksei.oursolarsystem.adapter.TerraformAdapter
import ru.borodinskiy.aleksei.oursolarsystem.databinding.FragmentTerraformBinding
import ru.borodinskiy.aleksei.oursolarsystem.viewmodel.PlanetViewModel

@AndroidEntryPoint
class MarsTerraformFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView

    private val viewModel: PlanetViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentTerraformBinding.inflate(inflater, container, false)

        recyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        val adapter = TerraformAdapter()

        recyclerView.adapter = adapter

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.getPlanetFromLatinName("Mars").observe(viewLifecycleOwner) { planets ->
                planets.let {
                    adapter.submitList(it)
                }
            }
        }

//        viewModel.getPlanetFromLatinName("Mars").observe(this.viewLifecycleOwner) { planets ->
//            planets.let {
//                adapter.submitList(it)
//            }
//        }

        return binding.root
    }
}