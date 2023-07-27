package ru.borodinskiy.aleksei.oursolarsystem.ui.venus

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import ru.borodinskiy.aleksei.oursolarsystem.databinding.FragmentVenusBinding

class VenusFragment : Fragment() {

    private var _binding: FragmentVenusBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val venusViewModel =
            ViewModelProvider(this).get(VenusViewModel::class.java)

        _binding = FragmentVenusBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textVenus
        venusViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}