package ru.borodinskiy.aleksei.oursolarsystem.ui.sun

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
import ru.borodinskiy.aleksei.oursolarsystem.adapter.GalleryAdapter
import ru.borodinskiy.aleksei.oursolarsystem.adapter.GalleryListener
import ru.borodinskiy.aleksei.oursolarsystem.databinding.FragmentPlanetGalleryBinding
import ru.borodinskiy.aleksei.oursolarsystem.entity.Image
import ru.borodinskiy.aleksei.oursolarsystem.viewmodel.GalleryViewModel

@AndroidEntryPoint
class SunGalleryFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private val viewModel: GalleryViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentPlanetGalleryBinding.inflate(inflater, container, false)

        recyclerView = binding.verticalRecyclerView
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        val adapter = GalleryAdapter(object : GalleryListener {

            override fun onFullImage(image: Image) {
                val bundle = bundleOf(
                    Pair("url", "https://" + image.url),
                    Pair("nameRus", getString(R.string.sun))
                )
                findNavController().navigate(R.id.action_nav_sun_to_fullImageFragment, bundle)
            }

        })

        recyclerView.adapter = adapter

        viewLifecycleOwner.lifecycleScope.launch {

            viewModel.getImagesFromKeyWord("Sol").observe(viewLifecycleOwner) { images ->
                images.let {
                    adapter.submitList(it)
                }
            }
        }


        return binding.root
    }
}