package com.android.example.clockmaster

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.android.example.clockmaster.databinding.ActivityAlarmBinding

class AlarmActivity : AppCompatActivity() , AdapterView.OnItemSelectedListener{

    private lateinit var binding: ActivityAlarmBinding
    private var isAlarmSet: Boolean = false
    private var hourValue: Int = -1
    private var minuteValue: Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alarm)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_alarm)
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter.createFromResource(
                this,
        R.array.hours_array,
        android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            binding.hoursSpinner.setAdapter(adapter)
        }


        ArrayAdapter.createFromResource(
            this,
            R.array.minutes_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            binding.minutesSpinner.setAdapter(adapter)
        }

        binding.hoursSpinner.onItemSelectedListener = this
        binding.minutesSpinner.onItemSelectedListener = this

        binding.setButton.setOnClickListener { setAlarm() }

    }

    override fun onNothingSelected(parent: AdapterView<*>?) {

    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        when (parent!!.id) {
            24 -> hourValue = parent.getItemAtPosition(position) as Int
            60 -> minuteValue = parent.getItemAtPosition(position) as Int
        }
        Toast.makeText(this,parent.count,Toast.LENGTH_SHORT).show()

    }
    private fun setAlarm(){
        if (!isAlarmSet){
            // handle the setup of clock
            binding.setButton.setText(R.string.unset)
            Toast.makeText(this,"The time set is:" + hourValue + ":" + minuteValue,Toast.LENGTH_SHORT).show()
            isAlarmSet = true
        }
        else {
            // handle the setup of clock
            binding.setButton.setText(R.string.set)
            isAlarmSet = false
        }
    }
}
