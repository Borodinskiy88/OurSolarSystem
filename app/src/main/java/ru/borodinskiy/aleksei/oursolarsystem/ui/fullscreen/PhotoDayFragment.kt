package ru.borodinskiy.aleksei.oursolarsystem.ui.fullscreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.android.AndroidEntryPoint
import ru.borodinskiy.aleksei.oursolarsystem.adapter.PhotoDayAdapter
import ru.borodinskiy.aleksei.oursolarsystem.databinding.FragmentPhotoDayBinding
import ru.borodinskiy.aleksei.oursolarsystem.viewmodel.PhotoDayViewModel

@AndroidEntryPoint
class PhotoDayFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private val viewModel: PhotoDayViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentPhotoDayBinding.inflate(inflater, container, false)

        recyclerView = binding.verticalRecyclerView
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        val adapter = PhotoDayAdapter()

        recyclerView.adapter = adapter

        viewModel.getPhotoDay().observe(viewLifecycleOwner) {}


        viewModel.allPhotoDay.observe(viewLifecycleOwner) {

            adapter.submitList(it)
        }




        return binding.root
    }

}