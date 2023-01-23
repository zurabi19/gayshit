package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.google.android.material.bottomnavigation.BottomNavigationView



class xd : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_xd, container, false)

        val bottomNavigationView = view.findViewById<BottomNavigationView>(R.id.qvedaNavigacia)


        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.wignebisFragment -> {
                    // Replace the current fragment with Fragment1
                    val fragment1 =WignebisFragment()
                    val transaction = fragmentManager?.beginTransaction()
                    transaction?.replace(R.id.mainContainer1, fragment1)
                    transaction?.commit()
                    true
                }
                R.id.profilisFragment-> {
                    // Replace the current fragment with Fragment1
                    val fragment1 = ProfilisFragment()
                    val transaction = fragmentManager?.beginTransaction()
                    transaction?.replace(R.id.mainContainer1, fragment1)
                    transaction?.commit()
                    true
                }

                else -> false
            }
        }

        return view
    }



}