package com.example.doghistory.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.doghistory.R
import com.example.doghistory.database.DogModel

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel
    private lateinit var idtv: EditText
    private lateinit var desctv: EditText
    private lateinit var urltv: EditText
    private lateinit var ab: Button
    private lateinit var ub: Button
    private lateinit var dbtv: TextView
    private var count: Int = 0

    override fun onCreateView(                  // Create the view hierarchy
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        Log.i("Frank", "onCreateView() before inflating...")
        var myroot = inflater.inflate(R.layout.main_fragment, container, false)

        findviews(myroot)
        return myroot
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {       // Activity has completed its onCreate()
        super.onActivityCreated(savedInstanceState)
        Log.i("Frank", "*****Before creating the viewModel...")
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        Log.i("Frank", "*****onActivityCreated() is finished...")

        // When add-dog button clicked/touched ---------------------------------
        ab.setOnClickListener {
            Log.i("Frank", "Inside add-dog onClick()")
            addNewDog()
        }

        // When show-dogs button clicked/touched ---------------------------------
        ub.setOnClickListener {
            Log.i("Frank", "Inside update-dog onClick()")
            updateNewDog()
        }
    }

    private fun addNewDog() {
        viewModel.addDog(dogFromUser())
    }
    private fun updateNewDog() {
        viewModel.updateDog(dogFromUser())
    }

    private fun dogFromUser() : DogModel{
        return DogModel(idtv.text.toString().toInt(),
                desctv.text.toString(),
                urltv.text.toString()
            )
    }

    private fun findviews(mr: View) {
        ab = mr.findViewById(R.id.add_button)
        ub = mr.findViewById(R.id.update_button)
        dbtv = mr.findViewById(R.id.database_textview)
        idtv = mr.findViewById(R.id.id_edittext)
        desctv = mr.findViewById(R.id.desc_edittext)
        urltv = mr.findViewById(R.id.url_edittext)
    }

    private fun showAllDogs() {
        //TBD
        //viewModel.getAllDogs()
    }

}