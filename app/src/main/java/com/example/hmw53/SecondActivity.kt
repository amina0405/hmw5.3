package com.example.hmw53

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.hmw53.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val textValue = intent.getStringExtra("KEY")
        binding.editText.setText(textValue)
        buttonListener()

    }

    private fun buttonListener() {
        binding.btn.setOnClickListener() {
            if (binding.editText.length() <= 0) {
                Toast.makeText(
                    applicationContext,
                    "EditText не может существовать без текста!",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                val intent = Intent(this, MainActivity::class.java)
                setResult(RESULT_OK, intent)
                intent.putExtra("KEY", binding.editText.text.toString())
                setResult(RESULT_OK, intent)
                finish()
            }
        }
    }
}
