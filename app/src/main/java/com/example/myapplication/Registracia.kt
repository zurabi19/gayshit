package com.example.myapplication

import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Email
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.firebase.auth.FirebaseAuth

class Registracia:Fragment(R.layout.registracia) {
    private lateinit var Email:EditText
    private lateinit var PASSWORD :EditText
    private lateinit var buttuon3 : Button
    private lateinit var signin : TextView


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view=inflater.inflate(R.layout.registracia,container,false)
        Email=view.findViewById(R.id.Email)
        PASSWORD=view.findViewById(R.id.PASSWORD)
        buttuon3=view.findViewById(R.id.button3)
        signin=view.findViewById(R.id.signin)

        signin.setOnClickListener {
            val fragment1 =LoginFragment()
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.mainContainer, fragment1)
            transaction?.commit()
        }
        buttuon3.setOnClickListener { 
            var password=PASSWORD.text.toString()
            var email=Email.text.toString()
            
            if (password.isNotEmpty()&&email.isNotEmpty()){
                FirebaseAuth.getInstance().createUserWithEmailAndPassword(email,password)
                    .addOnSuccessListener {
                        Toast.makeText(this.requireContext(), "წარმსტებით დარეგისტრილდით", Toast.LENGTH_SHORT).show()
                    }

                
                
            }
        }

        return view




    }
}