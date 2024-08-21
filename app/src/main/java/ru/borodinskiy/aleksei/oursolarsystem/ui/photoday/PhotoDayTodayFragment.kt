package ru.borodinskiy.aleksei.oursolarsystem.ui.photoday

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.esmaeel.shareitlib.SharableItem
import com.esmaeel.shareitlib.Share
import dagger.hilt.android.AndroidEntryPoint
import ru.borodinskiy.aleksei.oursolarsystem.R
import ru.borodinskiy.aleksei.oursolarsystem.adapter.PhotoDayAdapter
import ru.borodinskiy.aleksei.oursolarsystem.adapter.PhotoListener
import ru.borodinskiy.aleksei.oursolarsystem.databinding.FragmentPhotoDayTodayBinding
import ru.borodinskiy.aleksei.oursolarsystem.entity.PhotoDay
import ru.borodinskiy.aleksei.oursolarsystem.utils.CheckForInternet.checkForInternet
import ru.borodinskiy.aleksei.oursolarsystem.viewmodel.PhotoDayViewModel

@AndroidEntryPoint
class PhotoDayTodayFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private val viewModel: PhotoDayViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentPhotoDayTodayBinding.inflate(inflater, container, false)

        recyclerView = binding.verticalRecyclerView
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        val adapter = PhotoDayAdapter(object : PhotoListener {

            override fun onShowSmall(photoDay: PhotoDay) {
                val bundle = bundleOf(
                    Pair("url", photoDay.url),
                    Pair("nameRus", getString(R.string.photo_day))
                )
                findNavController().navigate(R.id.action_nav_photo_day_to_fullImageFragment, bundle)
            }

            override fun onDelete(photoDay: PhotoDay) {
                viewModel.delete(photoDay)
            }

            override fun photoForMonth() {
                viewModel.getListPhotoMonth().observe(viewLifecycleOwner) {}
            }

            override fun photoForTreeMonth() {
                viewModel.getListPhotoThreeMonth().observe(viewLifecycleOwner) {}
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

            override fun deleteAll() {
                viewModel.deleteAll()
            }

            override fun onShare(photoDay: PhotoDay) {

//                val intent = Intent().apply {
//                    action = Intent.ACTION_SEND
//                    putExtra(Intent.EXTRA_TEXT, photoDay.url)
//                    type = "text/plain"
//                }
//
//                val shareIntent =
//                    Intent.createChooser(intent, getString(R.string.chooser_share_image))
//                startActivity(shareIntent)

                context?.let {
                    Share.with(context = it)
                        .item(
                            SharableItem(pictureUrl = photoDay.url),
                            onStart = {},
                            onFinish = { _, _ -> }
                        )
                }
            }

        })

        recyclerView.adapter = adapter

        if (checkForInternet(requireContext())) {

            viewModel.getPhotoDay().observe(viewLifecycleOwner) {

                adapter.submitList(listOf(it))
            }
        } else {

            Toast.makeText(
                requireContext(),
                getString(R.string.need_internet),
                Toast.LENGTH_LONG
            ).show()
        }

        return binding.root
    }

}