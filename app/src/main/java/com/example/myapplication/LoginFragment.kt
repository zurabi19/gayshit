package com.example.myapplication

import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Email
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.firebase.auth.FirebaseAuth

class LoginFragment: Fragment(R.layout.login_fragment) {

    private lateinit var Email : EditText
    private lateinit var  pass : EditText
    private lateinit var  button: Button
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.login_fragment,container,false)
        pass=view.findViewById(R.id.pass)
        Email=view.findViewById(R.id.Email)
        button=view.findViewById(R.id.button)

        button.setOnClickListener {
            var password =pass.text.toString()
            var email= Email.text.toString()
            if (password.isNotEmpty()&&email.isNotEmpty()){



                FirebaseAuth.getInstance().signInWithEmailAndPassword(email,password)
                    .addOnSuccessListener {
                        Toast.makeText(this.requireContext(), "ყოჩაღ", Toast.LENGTH_SHORT).show()
                    }



                }
        }

        return view
    }
}