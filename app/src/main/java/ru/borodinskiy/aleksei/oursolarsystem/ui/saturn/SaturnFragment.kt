package ru.borodinskiy.aleksei.oursolarsystem.ui.saturn

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import ru.borodinskiy.aleksei.oursolarsystem.databinding.FragmentSaturnBinding

class SaturnFragment : Fragment() {

    private var _binding: FragmentSaturnBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val saturnViewModel =
            ViewModelProvider(this).get(SaturnViewModel::class.java)

        _binding = FragmentSaturnBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textSaturn
        saturnViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}