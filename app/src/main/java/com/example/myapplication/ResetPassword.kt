package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class ResetPassword :Fragment(R.layout.reset_pass) {


    private lateinit var Login : TextView


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view=inflater.inflate(R.layout.reset_pass,container,false)
        Login=view.findViewById(R.id.Login)

        Login.setOnClickListener {
            val fragment1 =LoginFragment()
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.mainContainer, fragment1)
            transaction?.commit()

        }






        return view

    }
}