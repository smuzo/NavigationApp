package com.example.navigationapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import androidx.navigation.navOptions
import com.example.navigationapp.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(layoutInflater)


        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
        binding.btnViewBalance.setOnClickListener {
//          val action= NavOptions.Builder()
//               .setEnterAnim(R.anim.slide_in_right)
//               .setExitAnim(R.anim.slide_out_left)
//               .setPopEnterAnim(R.anim.slide_in_left)
//               .setPopExitAnim(R.anim.slide_out_right)
//               .build()
            findNavController().navigate(R.id.viewBalanceFragment)
        }
        binding.btnSendMoney.setOnClickListener {
            findNavController().navigate(R.id.chooseReceiverFragment)
        }

        binding.btnTransactions.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToViewTransactionFragment2()
             findNavController().navigate(action)

        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}