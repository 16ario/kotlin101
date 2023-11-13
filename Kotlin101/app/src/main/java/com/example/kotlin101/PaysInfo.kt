package com.example.kotlin101

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController


class PaysInfo : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_pays_info, container, false)
        val button = view.findViewById<Button>(R.id.retour_pays)
        button.setOnClickListener{
            findNavController().navigate(R.id.action_pays_info_to_liste_pays)
        }

        return view

    }



}