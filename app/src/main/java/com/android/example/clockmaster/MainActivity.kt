package com.android.example.clockmaster

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.android.example.clockmaster.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.buttonAlarm.setOnClickListener {  startAlarmActivity() }
    }

    private fun startAlarmActivity(){
        val alarmIntent : Intent = Intent(this, AlarmActivity::class.java)
        startActivity(alarmIntent)
    }
}
