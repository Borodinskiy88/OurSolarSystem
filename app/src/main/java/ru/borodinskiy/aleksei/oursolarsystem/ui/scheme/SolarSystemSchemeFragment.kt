package ru.borodinskiy.aleksei.oursolarsystem.ui.scheme

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import ru.borodinskiy.aleksei.oursolarsystem.R
import ru.borodinskiy.aleksei.oursolarsystem.databinding.FragmentSolarSystemSchemeBinding

@AndroidEntryPoint
class SolarSystemSchemeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentSolarSystemSchemeBinding.inflate(inflater, container, false)

        binding.apply {

            sun.setOnClickListener {
                findNavController().navigate(R.id.action_nav_system_scheme_to_nav_sun)
            }

            sunText.setOnClickListener {
                findNavController().navigate(R.id.action_nav_system_scheme_to_nav_sun)
            }

            mercury.setOnClickListener {
                findNavController().navigate(R.id.action_nav_system_scheme_to_nav_mercury)
            }

            mercuryText.setOnClickListener {
                findNavController().navigate(R.id.action_nav_system_scheme_to_nav_mercury)
            }

            venus.setOnClickListener {
                findNavController().navigate(R.id.action_nav_system_scheme_to_nav_venus)
            }

            venusText.setOnClickListener {
                findNavController().navigate(R.id.action_nav_system_scheme_to_nav_venus)
            }

            earth.setOnClickListener {
                findNavController().navigate(R.id.action_nav_system_scheme_to_nav_earth)
            }

            earthText.setOnClickListener {
                findNavController().navigate(R.id.action_nav_system_scheme_to_nav_earth)
            }

            mars.setOnClickListener {
                findNavController().navigate(R.id.action_nav_system_scheme_to_nav_mars)
            }

            marsText.setOnClickListener {
                findNavController().navigate(R.id.action_nav_system_scheme_to_nav_mars)
            }

            jupiter.setOnClickListener {
                findNavController().navigate(R.id.action_nav_system_scheme_to_nav_jupiter)
            }

            jupiterText.setOnClickListener {
                findNavController().navigate(R.id.action_nav_system_scheme_to_nav_jupiter)
            }

            saturn.setOnClickListener {
                findNavController().navigate(R.id.action_nav_system_scheme_to_nav_saturn)
            }

            saturnText.setOnClickListener {
                findNavController().navigate(R.id.action_nav_system_scheme_to_nav_saturn)
            }

            uranus.setOnClickListener {
                findNavController().navigate(R.id.action_nav_system_scheme_to_nav_uranus)
            }

            uranusText.setOnClickListener {
                findNavController().navigate(R.id.action_nav_system_scheme_to_nav_uranus)
            }

            neptune.setOnClickListener {
                findNavController().navigate(R.id.action_nav_system_scheme_to_nav_neptune)
            }

            neptuneText.setOnClickListener {
                findNavController().navigate(R.id.action_nav_system_scheme_to_nav_neptune)
            }

        }

        return binding.root
    }

}