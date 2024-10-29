package com.example.hw9

import android.app.Dialog
import android.app.TimePickerDialog
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TimePicker
import android.widget.Toast
import androidx.fragment.app.DialogFragment



class TimePicker : DialogFragment(), TimePickerDialog.OnTimeSetListener {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view  = inflater.inflate(R.layout.fragment_time_picker, container, false)
        return view
    }



    override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
        val msg = String.format("%d:%d",hourOfDay,minute)
        //Toast.makeText(requireContext(),msg, Toast.LENGTH_SHORT).show()
        val intent = Intent(requireContext(), CartActivity::class.java)
        intent.putExtra("Time", msg)
        startActivity(intent)
    }
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val hourOfDay = 12
        val minute = 0

        return TimePickerDialog(requireActivity(), this, hourOfDay,minute,true)


    }



}