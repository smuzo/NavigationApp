package com.example.navigationapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.navigationapp.databinding.FragmentCashReceiverBinding

class CashReceiverFragment : Fragment(R.layout.fragment_cash_receiver) {
    private var _binding: FragmentCashReceiverBinding? = null
    private val binding get() = _binding!!
    private val args: CashReceiverFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCashReceiverBinding.inflate(layoutInflater)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.tvReceiver.text=getString(R.string.send_cash_to, args.userName)
        binding.etAmount.setText(SampleData.defaultAmount.value.toString())
        SampleData.defaultAmount.observe(viewLifecycleOwner){
        binding.etAmount.setText(it.toString())

        }


        binding.btnSend.setOnClickListener {


            if (binding.etAmount.text.toString().isEmpty()) {
                Toast.makeText(requireContext(), "Please enter amount", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val amount = binding.etAmount.text.toString().toInt()
            val action =
                CashReceiverFragmentDirections.actionCashReceiverFragmentToConfrimDialogFragment(
                    args.userName,
                    amount
                )
            findNavController().navigate(action)
        }
        binding.btnDone.setOnClickListener {
            val action=CashReceiverFragmentDirections.actionCashReceiverFragmentToHomeFragment()
            findNavController().navigate(action)
        }
        binding.btnCancel.setOnClickListener {
         findNavController().popBackStack(R.id.homeFragment,true)

     }

    }

}
