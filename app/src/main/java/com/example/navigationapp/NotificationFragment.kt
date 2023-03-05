package com.example.navigationapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import com.example.navigationapp.databinding.FragmentNotificationBinding
import com.example.navigationapp.databinding.FragmentSettingBinding

class NotificationFragment : Fragment(R.layout.fragment_notification) {
    private var _binding: FragmentNotificationBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNotificationBinding.inflate(layoutInflater)


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


      binding.lvNotification.adapter=ArrayAdapter<String>(requireContext(),android.R.layout.simple_expandable_list_item_1,onNotification())


        }

    private fun onNotification(): List<String> {
val notification= mutableListOf<String>()
        for (i in 1..15){
            notification.add("Notification no $i")
    }

return notification
}


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}