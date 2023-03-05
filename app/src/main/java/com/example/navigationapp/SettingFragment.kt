package com.example.navigationapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.navigationapp.databinding.FragmentSettingBinding

class SettingFragment : Fragment() {
    private var _binding: FragmentSettingBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSettingBinding.inflate(layoutInflater)


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.etDefaultAmount.setText(SampleData.defaultAmount.value.toString())
        binding.btnSaveDefaultAmount.setOnClickListener {

            val amount = binding.etDefaultAmount.text.toString().toInt()
            SampleData.defaultAmount.value = amount
        }


    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}