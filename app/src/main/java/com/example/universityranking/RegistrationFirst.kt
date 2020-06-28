package com.example.universityranking

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth


class RegistrationFirst : Fragment() {

    private var mAuth: FirebaseAuth? = null

    private var TAG: String = "RegistrationFirst"

    var email: EditText? = null
    var password: EditText? = null
    var passwordAgain: EditText? = null
    var image: ImageView? = null
    var btnNext: Button? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_registration_first, container, false)

        email = view.findViewById(R.id.email_reg)
        password = view.findViewById(R.id.password_reg)
        passwordAgain = view.findViewById(R.id.password_again_reg)
        image = view.findViewById(R.id.imageView_reg)
        btnNext = view.findViewById(R.id.button_next_reg)

        val animation = AnimationUtils.loadAnimation(context, R.anim.translate)
        image!!.startAnimation(animation)

        mAuth = FirebaseAuth.getInstance()

        btnNext!!.setOnClickListener {
            signUp(email?.text.toString().trim(), password?.text.toString().trim())

            activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.fragment_container, RegistrationView())?.addToBackStack(null)?.commit()
        }


        return view
    }

    public fun signUp(email: String, password: String) {
        mAuth!!.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(activity!!) { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        Log.d(TAG, "createUserWithEmail:success")
                        Toast.makeText(context, "Registration done!",
                                Toast.LENGTH_SHORT).show()
                        val user = mAuth!!.currentUser
                    } else {
                        // If sign in fails, display a message to the user.
                        Log.w(TAG, "createUserWithEmail:failure", task.exception)
                        Toast.makeText(context, "Authentication failed.",
                                Toast.LENGTH_SHORT).show()
                    }

                    // ...
                }
    }
}
