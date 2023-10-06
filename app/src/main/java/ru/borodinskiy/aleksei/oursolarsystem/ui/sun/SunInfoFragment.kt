package ru.borodinskiy.aleksei.oursolarsystem.ui.sun

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
import ru.borodinskiy.aleksei.oursolarsystem.adapter.PlanetAdapter
import ru.borodinskiy.aleksei.oursolarsystem.databinding.FragmentInfoBinding
import ru.borodinskiy.aleksei.oursolarsystem.viewmodel.PlanetViewModel

@AndroidEntryPoint
class SunInfoFragment : Fragment() {

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

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.getPlanetFromLatinName("Sol").observe(viewLifecycleOwner) { planets ->
                planets.let {
                    adapter.submitList(it)
                }
            }
        }

//        viewModel.getPlanetFromLatinName("Sol").observe(this.viewLifecycleOwner) { planets ->
//            planets.let {
//                adapter.submitList(it)
//            }
//        }

        //TODO объединить в группу
        binding.apply {
//            durationDayHeadline.isVisible = false
//            durationDay.isVisible = false
//            durationYearHeadline.isVisible = false
//            durationYear.isVisible = false
//            appearanceHeadline.isVisible = false
//            appearance.isVisible = false
        }


        return binding.root
    }
}