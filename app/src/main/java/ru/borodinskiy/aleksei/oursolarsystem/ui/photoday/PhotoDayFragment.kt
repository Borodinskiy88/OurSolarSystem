package ru.borodinskiy.aleksei.oursolarsystem.ui.photoday

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.android.AndroidEntryPoint
import ru.borodinskiy.aleksei.oursolarsystem.R
import ru.borodinskiy.aleksei.oursolarsystem.adapter.PhotoDayAdapter
import ru.borodinskiy.aleksei.oursolarsystem.adapter.PhotoListener
import ru.borodinskiy.aleksei.oursolarsystem.databinding.FragmentPhotoDayBinding
import ru.borodinskiy.aleksei.oursolarsystem.entity.PhotoDay
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

        val adapter = PhotoDayAdapter(object : PhotoListener {

            override fun onShowSmall(photoDay: PhotoDay) {
                val bundle = bundleOf(
                    Pair("url", photoDay.url),
                    Pair("nameRus", "Фото дня")
                )
                findNavController().navigate(R.id.action_nav_photo_day_to_fullImageFragment, bundle)
            }

            override fun onDelete(photoDay: PhotoDay) {
                viewModel.delete(photoDay)
            }

            override fun photoForMonth() {
                viewModel.getListPhotoMonth().observe(viewLifecycleOwner) {}
            }

            override fun photoForTwoMonth() {
                viewModel.getListPhotoTwoMonth().observe(viewLifecycleOwner) {}
            }

            override fun photoForTenDays() {
                viewModel.getListPhotoTenDays().observe(viewLifecycleOwner) {}
            }

            override fun onVideo(photoDay: PhotoDay) {
                val bundle = bundleOf(
                    Pair("url", photoDay.url),
                )
                findNavController().navigate(R.id.action_nav_photo_day_to_videoFragment, bundle)
            }

        })

        recyclerView.adapter = adapter

        //TODO спрятать куда-нибудь, чтоб траффик не расходовать
        viewModel.getPhotoDay().observe(viewLifecycleOwner) {}


        viewModel.allPhotoDay.observe(viewLifecycleOwner) {

            adapter.submitList(it)
        }

//        viewModel.getPhotoDay().observe(viewLifecycleOwner) {
//
//            adapter.submitList(listOf(it))
//        }

//        viewModel.getListPhotoTenDays().observe(viewLifecycleOwner) {
//
//            adapter.submitList(it.reversed())
//        }

        return binding.root
    }

}