package com.example.universityranking

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import kotlin.math.sign

class StartView : Fragment() {

    var signIn: Button? = null
    var signUp: Button? = null
    var testBtn: Button? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_start_view, container, false)
        activity!!.window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        val decor = activity!!.window.decorView

        signIn = view.findViewById(R.id.signIn_start)
        signUp = view.findViewById(R.id.signUp_start)
        testBtn = view.findViewById(R.id.test_btn)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val decor: View = activity!!.window.decorView
            decor.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        }

        signIn!!.setOnClickListener {
            activity!!.supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.fragment_container, AuthenticationView())
                    .addToBackStack(null)
                    .commit()
        }

        signUp!!.setOnClickListener {
            activity!!.supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.fragment_container, RegistrationFirst())
                    .addToBackStack(null)
                    .commit()
        }

        testBtn?.setOnClickListener {
            activity!!.supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.fragment_container, RegistrationView())
                    .addToBackStack(null)
                    .commit()
        }

        return view
    }


}
