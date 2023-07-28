package ru.borodinskiy.aleksei.oursolarsystem.ui.jupiter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import ru.borodinskiy.aleksei.oursolarsystem.R
import ru.borodinskiy.aleksei.oursolarsystem.databinding.CardPlanetsBinding

class JupiterFragment : Fragment() {

    private var _binding: CardPlanetsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val jupiterViewModel =
            ViewModelProvider(this).get(JupiterViewModel::class.java)

        //       binding.planetImage.setImageResource(R.drawable.jupiter)
        //       binding.planetRusName.text = "Юпитер"

        _binding = CardPlanetsBinding.inflate(inflater, container, false)

        binding.planetRusName.text = "Юпитер"
        binding.planetImage.setImageResource(R.drawable.jupiter)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}