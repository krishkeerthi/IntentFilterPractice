package com.example.socialapp

import android.content.ContentValues.TAG
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.socialapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //val data = intent.data
        val action = intent.action
        val type = intent.type

        if(Intent.ACTION_SEND == action && type != null){
            Log.d(TAG, "onCreate: inside action n non null type")
            if(type.startsWith("image/"))
            {
                Log.d(TAG, "onCreate: inside action and image type")
                Toast.makeText(this, "Image is being shared", Toast.LENGTH_SHORT).show()
                showImage(intent)
            }
        }


    }

    private fun showImage(intent: Intent){
        Log.d(TAG, "showImage: inside show image")
        val imageUri = intent.getParcelableExtra<Uri>(Intent.EXTRA_STREAM)

        binding.socialImageView.setImageURI(imageUri)
    }
}