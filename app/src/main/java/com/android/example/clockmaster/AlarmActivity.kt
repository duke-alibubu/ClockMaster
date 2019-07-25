package com.android.example.clockmaster

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*


class AlarmActivity : AppCompatActivity() , AdapterView.OnItemSelectedListener{

    private lateinit var hoursSpinner: Spinner
    private lateinit var minutesSpinner: Spinner
    private lateinit var setButton: Button
    private var isAlarmSet: Boolean = false
    private lateinit var hourValue: String
    private lateinit var minuteValue: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alarm)

        hoursSpinner = findViewById(R.id.hours_spinner)
        minutesSpinner = findViewById(R.id.minutes_spinner)
        setButton = findViewById(R.id.set_button)


        // Create an ArrayAdapter using the string array and a default spinner layout
        val hoursAdapter = ArrayAdapter.createFromResource(
            this, R.array.hours_array, android.R.layout.simple_spinner_item)
        hoursAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        hoursSpinner.adapter = hoursAdapter
        hoursSpinner.onItemSelectedListener = this


        val minutesAdapter = ArrayAdapter.createFromResource(
            this, R.array.minutes_array, android.R.layout.simple_spinner_item)
        minutesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        minutesSpinner.adapter = minutesAdapter
        minutesSpinner.onItemSelectedListener = this

        setButton.setOnClickListener { setAlarm() }

    }

    override fun onNothingSelected(parent: AdapterView<*>?) {

    }

    override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {

        when(parent.getCount()){
            24 -> hourValue = parent.getItemAtPosition(position) as String
            60 -> minuteValue = parent.getItemAtPosition(position) as String
        }
    }
    private fun setAlarm(){
        if (!isAlarmSet){
            // handle the setup of clock

            setButton.setText(R.string.unset)
            Toast.makeText(this,"The time set is: " + hourValue + ":" + minuteValue,Toast.LENGTH_SHORT).show()
            isAlarmSet = true
        }
        else {
            // handle the setup of clock
            setButton.setText(R.string.set)
            isAlarmSet = false
        }
    }
}
