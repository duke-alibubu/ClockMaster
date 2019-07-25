package com.android.example.clockmaster

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*


class AlarmActivity : AppCompatActivity() , AdapterView.OnItemSelectedListener{

   // private lateinit var hoursSpinner: Spinner
   // private lateinit var minutesSpinner: Spinner
   // private lateinit var setButton: Button
    private var isAlarmSet: Boolean = false
    private var hourValue: Int = -1
    private var minuteValue: Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alarm)

        val hoursSpinner: Spinner = findViewById(R.id.hours_spinner)
        val minutesSpinner: Spinner = findViewById(R.id.minutes_spinner)
        val setButton: Button = findViewById(R.id.set_button)

        // Create an ArrayAdapter using the string array and a default spinner layout
        
        ArrayAdapter.createFromResource(
                this,
        R.array.hours_array,
        android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            hoursSpinner.setAdapter(adapter)
        }


        ArrayAdapter.createFromResource(
            this,
            R.array.minutes_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            minutesSpinner.setAdapter = adapter
        }

        hoursSpinner.onItemSelectedListener = this
        minutesSpinner.onItemSelectedListener = this

        setButton.setOnClickListener { setAlarm() }

    }

    override fun onNothingSelected(parent: AdapterView<*>?) {

    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

        Toast.makeText(this,parent!!.id,Toast.LENGTH_SHORT).show()

    }
    private fun setAlarm(){
        if (!isAlarmSet){
            // handle the setup of clock
            setButton.setText(R.string.unset)
            Toast.makeText(this,"The time set is:" + hourValue + ":" + minuteValue,Toast.LENGTH_SHORT).show()
            isAlarmSet = true
        }
        else {
            // handle the setup of clock
            setButton.setText(R.string.set)
            isAlarmSet = false
        }
    }
}
