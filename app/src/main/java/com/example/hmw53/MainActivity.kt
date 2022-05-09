package com.example.hmw53

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.app.Instrumentation
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import com.example.hmw53.databinding.ActivityMainBinding

class MainActivity() : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private val startForResult =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult())
        { result: ActivityResult ->
            if (result.resultCode == RESULT_OK) {
                val text: String = result.data?.getStringExtra("KEY").toString()
                binding.edittext.setText(text)
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        btnListener()
        val textValue = intent.getStringExtra("KEY")
        binding.edittext.setText(textValue)
    }




    private fun btnListener() {
        binding.button.setOnClickListener() {
            if (binding.edittext.length() <= 0) {
                Toast.makeText(
                    applicationContext,
                    "EditText не может существовать без текста!",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                val intent = Intent(this, SecondActivity::class.java)
                intent.putExtra("KEY", binding.edittext.text.toString())
                startForResult.launch(intent)

            }

        }
    }

