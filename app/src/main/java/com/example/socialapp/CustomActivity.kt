package com.example.socialapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.socialapp.databinding.ActivityCustomBinding

class CustomActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCustomBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCustomBinding.inflate(layoutInflater)
        setContentView(binding.root)

        showText(intent)
    }

    private fun showText(intent: Intent){

        val data = intent.getStringExtra("CUSTOM_EXTRA")
        binding.customActionTextView.text = data
    }
}