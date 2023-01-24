package com.example.myapplication

import android.app.AlertDialog
import android.content.Context
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
import androidx.navigation.fragment.findNavController
import com.google.firebase.auth.FirebaseAuth

class LoginFragment: Fragment(R.layout.login_fragment) {

    private lateinit var Email : EditText
    private lateinit var  pass : EditText
    private lateinit var  button: Button
    private lateinit var button5: Button
    private lateinit var builder: AlertDialog.Builder
    private lateinit var register : TextView
    private lateinit var RESET : TextView
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.login_fragment, container, false)
        pass = view.findViewById(R.id.pass)
        Email = view.findViewById(R.id.Email)
        button = view.findViewById(R.id.button)
        button5 = view.findViewById(R.id.button5)
        register = view.findViewById(R.id.register)
        RESET = view.findViewById(R.id.RESET)
        val preferences = activity?.getSharedPreferences("informacia", Context.MODE_PRIVATE)
        val editor = preferences?.edit()
        builder = AlertDialog.Builder(requireContext())


        builder.setTitle("UPSIDUPSI")
            .setMessage("გსურთ გათიშოთ აპლიკაცია?")
            .setCancelable(true)
            .setPositiveButton("yes") { dialogInterface, it ->
                dialogInterface.cancel()
            }
            .setNegativeButton("no") { dialogInterface, it ->
                dialogInterface.cancel()
            }
            .setNeutralButton("help") { dialogInterface, it ->
                Toast.makeText(this.requireContext(), "ver gishveli", Toast.LENGTH_SHORT).show()
            }
        val dialog = builder.create()
        button5.setOnClickListener {
            dialog.show()
        }
        RESET.setOnClickListener {
            val fragment1 = ResetPassword()
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.mainContainer, fragment1)
            transaction?.commit()

        }

        register.setOnClickListener {
            val fragment1 = Registracia()
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.mainContainer, fragment1)
            transaction?.commit()

        }

        if (FirebaseAuth.getInstance().currentUser != null) {
            val mail = preferences?.getString("email", "")
            val pass1 = preferences?.getString("password", "")
            println("saaaaaaaaaaaaaaa$mail$pass1")
            if (mail != "" && pass1 != "") {
                FirebaseAuth.getInstance().signInWithEmailAndPassword(mail!!, pass1!!)
                    .addOnSuccessListener {
                        val fragment1 = xd()
                        val transaction = fragmentManager?.beginTransaction()
                        transaction?.replace(R.id.mainContainer, fragment1)
                        transaction?.commit()
                    }
            }
        }else {
            button.setOnClickListener {


                var password = pass.text.toString()
                var email = Email.text.toString()
                if (password.isNotEmpty() && email.isNotEmpty()) {


                    FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
                        .addOnSuccessListener {
                            val fragment1 = xd()
                            val transaction = fragmentManager?.beginTransaction()
                            transaction?.replace(R.id.mainContainer, fragment1)
                            transaction?.commit()
                            editor?.putString("email", email)
                            editor?.putString("password", password)
                            editor?.apply()
                        }.addOnFailureListener{
                            Toast.makeText(this.requireContext(), "uuu", Toast.LENGTH_SHORT).show()
                        }


                }
            }
        }
            return view
        }
    }