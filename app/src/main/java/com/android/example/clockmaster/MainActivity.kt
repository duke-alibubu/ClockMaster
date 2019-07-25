package com.android.example.clockmaster

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button


class MainActivity : AppCompatActivity() {

    private lateinit var buttonAlarm: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonAlarm = findViewById(R.id.button_alarm)
        buttonAlarm.setOnClickListener {  startAlarmActivity() }
    }

    private fun startAlarmActivity(){
        val alarmIntent : Intent = Intent(this, AlarmActivity::class.java)
        startActivity(alarmIntent)
    }
}
