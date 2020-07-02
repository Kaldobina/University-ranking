package com.example.universityranking

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.button.MaterialButton
import com.google.android.material.button.MaterialButtonToggleGroup
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.fragment_registration_view.*
import kotlinx.android.synthetic.main.fragment_registration_view.view.*
import kotlinx.android.synthetic.main.fragment_registration_view.view.btnAbitur
import kotlinx.android.synthetic.main.fragment_registration_view.view.student_view

class RegistrationView : Fragment() {

    var firstName: EditText? = null
    var lastName: EditText? = null
    var group: MaterialButtonToggleGroup? = null
    var registrBtn: Button? = null
    var about: EditText? = null
    var university: EditText? = null
    var course: EditText? = null
    var isAbit: Boolean = false
    var isStudent: Boolean = false

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_registration_view, container, false)

        firstName = view.findViewById(R.id.fname_reg)
        lastName = view.findViewById(R.id.lname_reg)
        group = view.findViewById(R.id.materialButtonToggleGroup)
        registrBtn = view.findViewById(R.id.registrBtn)
        university = view.findViewById(R.id.university)
        about = view.findViewById(R.id.about)
        course = view.findViewById(R.id.course)

        group!!.addOnButtonCheckedListener { group, checkedId, isChecked ->
            chooseBtn(group)
        }

        registrBtn?.setOnClickListener {
            if (isStudent || isAbit) {
                saveUser(firstName?.text.toString().trim(), lastName?.text.toString().trim(),
                        about?.text.toString().trim(), university?.text.toString().trim(),
                        course?.text.toString().trim())
                Toast.makeText(context, "Registration done", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, "Выберите, кто Вы!'", Toast.LENGTH_SHORT).show()
            }
        }
        return view
    }

    private fun chooseBtn(group: MaterialButtonToggleGroup) {
        if (group.btnStudent.isChecked) {
            group.btnStudent.setBackgroundColor(resources.getColor(R.color.colorAccent))
            group.btnAbitur.setBackgroundColor(resources.getColor(R.color.colorPrimary))
            group.btnAbitur.isChecked = false
            student_view.visibility = View.VISIBLE
            abit_view.visibility = View.GONE
            isStudent = true
            isAbit = false
        } else if (group.btnAbitur.isChecked) {
            group.btnAbitur.setBackgroundColor(resources.getColor(R.color.colorAccent))
            group.btnStudent.setBackgroundColor(resources.getColor(R.color.colorPrimary))
            group.btnStudent.isChecked = false
            student_view.visibility = View.GONE
            abit_view.visibility = View.VISIBLE
            isAbit = true
            isStudent = false
        }
    }

    fun saveUser(firstName: String, lastName: String, about: String, univesity: String,
                 course: String) {

        val user: FirebaseUser? = FirebaseAuth.getInstance().currentUser
        val database: FirebaseDatabase = FirebaseDatabase.getInstance();
        val myRef = database.getReference("users").child(user!!.uid)

        if (isAbit){
            myRef.setValue(Abitur(firstName, lastName, about))
        } else if (isStudent) {
            myRef.setValue(Student(firstName, lastName, univesity, course))
        }
    }
}
