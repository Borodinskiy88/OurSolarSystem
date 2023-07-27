package ru.borodinskiy.aleksei.oursolarsystem.ui.mercury

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import ru.borodinskiy.aleksei.oursolarsystem.R
import ru.borodinskiy.aleksei.oursolarsystem.databinding.FragmentMercuryBinding

class MercuryFragment : Fragment() {

    private var _binding: FragmentMercuryBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val mercuryViewModel =
            ViewModelProvider(this).get(MercuryViewModel::class.java)

        _binding = FragmentMercuryBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.imageSolarSystem.setImageResource(R.drawable.solar_system)

        val textView: TextView = binding.textMercury
        mercuryViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}