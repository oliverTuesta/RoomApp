package com.example.roomapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.roomapp.data.User
import com.example.roomapp.data.UserRepository


class AddFragment : Fragment() {

    lateinit var userViewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        val btnAdd = view.findViewById<Button>(R.id.btnAdd)
        btnAdd.setOnClickListener {

            insertDataToDatabase(view)

        }

    }

    private fun insertDataToDatabase(view: View) {

        val etFirstName = view.findViewById<EditText>(R.id.etFirstName)
        val etLastName = view.findViewById<EditText>(R.id.etLastName)
        val etAge = view.findViewById<EditText>(R.id.etAge)

        val firstName = etFirstName.text.toString()
        val lastName = etLastName.text.toString()
        val age = etAge.text.toString()

        if (inputCheck(firstName, lastName, age)){
            Toast.makeText(requireContext(),"Complete all parameters", Toast.LENGTH_SHORT).show()
        }else{

            val user = User(0, firstName, lastName, age.toInt())
            userViewModel.addUser(user)
            Toast.makeText(requireContext(), "Successful add", Toast.LENGTH_SHORT).show()

            // navigate back
            findNavController().navigate(R.id.action_addFragment_to_listFragment)
        }

    }

    private fun inputCheck(firstName: String, lastName: String, age: String): Boolean{
        return firstName.isNullOrEmpty() || lastName.isEmpty() || age.isNullOrEmpty()
    }
}