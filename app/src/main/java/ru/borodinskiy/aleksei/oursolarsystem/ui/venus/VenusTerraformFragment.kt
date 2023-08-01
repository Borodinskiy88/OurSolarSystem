package ru.borodinskiy.aleksei.oursolarsystem.ui.venus

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.borodinskiy.aleksei.oursolarsystem.R
import ru.borodinskiy.aleksei.oursolarsystem.databinding.FragmentTerraformBinding

class VenusTerraformFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentTerraformBinding.inflate(inflater, container, false)

        //TODO заглушка
        binding.terraformImage.setImageResource(R.drawable.terraform_venus)

        return binding.root
    }
}