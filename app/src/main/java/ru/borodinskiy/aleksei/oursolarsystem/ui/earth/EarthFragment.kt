package ru.borodinskiy.aleksei.oursolarsystem.ui.earth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import ru.borodinskiy.aleksei.oursolarsystem.databinding.FragmentEarthBinding

class EarthFragment : Fragment() {

    private var _binding: FragmentEarthBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val earthViewModel =
            ViewModelProvider(this).get(EarthViewModel::class.java)

        _binding = FragmentEarthBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textEarth
        earthViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}