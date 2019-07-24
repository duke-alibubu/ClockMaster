package com.android.example.clockmaster

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.databinding.DataBindingUtil
import com.android.example.clockmaster.databinding.ActivityAlarmBinding

class AlarmActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAlarmBinding
    private var isAlarmSet: Boolean = false

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

        binding.setButton.setOnClickListener { setAlarm() }

    }

    private fun setAlarm(){
        if (!isAlarmSet){
            // handle the setup of clock
            binding.setButton.setText(R.string.unset)
            isAlarmSet = true
        }
        else {
            // handle the setup of clock
            binding.setButton.setText(R.string.set)
            isAlarmSet = false
        }
    }
}
