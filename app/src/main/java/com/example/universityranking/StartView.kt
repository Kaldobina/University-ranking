package com.example.universityranking

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class StartView : Fragment() {

    var signIn: Button? = null
    var signUp: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_start_view, container, false)

        activity!!.window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        val decor = activity!!.window.decorView

        signIn = view.findViewById(R.id.signIn_start)
        signUp = view.findViewById(R.id.signUp_start)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val decor: View = activity!!.window.decorView
            decor.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        }

        signIn!!.setOnClickListener {
            var fragment:AuthenticationView? = AuthenticationView()
            activity!!.supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.fragment_container, AuthenticationView())
                    .addToBackStack(null)
                    .commit()
        }

        return view
    }
/*
    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
                StartView().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM1, param1)
                        putString(ARG_PARAM2, param2)
                    }
                }
    }*/
}
