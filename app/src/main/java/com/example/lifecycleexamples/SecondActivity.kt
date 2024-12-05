package com.example.lifecycleexamples

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.lifecycleexamples.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    val viewModel: MyViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.main)

        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        viewModel.content.observe(this, {
            Log.v("TAG", "Content updated")
        })

        binding.buttonCount.setOnClickListener {
            viewModel.doCount()
        }
    }
}