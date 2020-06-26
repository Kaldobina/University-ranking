package com.example.universityranking

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import com.google.android.material.button.MaterialButton
import com.google.android.material.button.MaterialButtonToggleGroup

class RegistrationView : Fragment() {

    var firstName: EditText? = null
    var lastName: EditText? = null
    var group: MaterialButtonToggleGroup? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_registration_view, container, false)

        firstName = view.findViewById(R.id.fname_reg)
        lastName = view.findViewById(R.id.lname_reg)
        group = view.findViewById(R.id.materialButtonToggleGroup)


        group!!.addOnButtonCheckedListener { group, checkedId, isChecked ->
            val listenerButton:MaterialButton = group.findViewById(checkedId)
            val checkedButton:MaterialButton? = group
                    .findViewById(group.checkedButtonId)
        }


        return view
    }
}
