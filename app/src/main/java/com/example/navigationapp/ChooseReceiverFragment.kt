package com.example.navigationapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.navigationapp.databinding.FragmentChooseReceiverBinding

class ChooseReceiverFragment : Fragment()

{
    private  var _binding: FragmentChooseReceiverBinding?=null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding= FragmentChooseReceiverBinding.inflate(layoutInflater)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    binding.btnNext.setOnClickListener{
        if (binding.etReceiverName.text.toString().isEmpty()){
            Toast.makeText(requireContext(),"please enter user name",Toast.LENGTH_SHORT).show()
        }

        val username=binding.etReceiverName.text.toString()
        val action=ChooseReceiverFragmentDirections.actionChooseReceiverFragmentToCashReceiverFragment(username)
        findNavController().navigate(action)
    }

        binding.btnCancel.setOnClickListener {
         val action =ChooseReceiverFragmentDirections.actionChooseReceiverFragmentToHomeFragment2()
            findNavController().navigate(action)
        }

    }

    override fun onDestroyView() {
        _binding=null
        super.onDestroyView()
    }
}


