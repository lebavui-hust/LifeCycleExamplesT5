package com.example.lifecycleexamples

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.v("TAG", "onCreate")

        findViewById<Button>(R.id.button_open).setOnClickListener {
            val intent = Intent(this, TempActivity::class.java)
            startActivity(intent)
        }

        if (savedInstanceState == null)
            count = 0
        else
            count = savedInstanceState.getInt("COUNT", 0)

        val textCount = findViewById<TextView>(R.id.text_count)
        textCount.text = "$count"

        findViewById<Button>(R.id.button_count).setOnClickListener {
            count++
            textCount.text = "$count"
        }

        lifecycle.addObserver(MyObserver())
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt("COUNT", count)
        super.onSaveInstanceState(outState)
        Log.v("TAG", "onSaveInstanceState")
    }

//    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
//        super.onRestoreInstanceState(savedInstanceState)
//        Log.v("TAG", "onRestoreInstanceState")
//        count = savedInstanceState.getInt("COUNT", 0)
//    }

    override fun onStart() {
        super.onStart()
        Log.v("TAG", "onStart")
    }

    override fun onRestart() {
        super.onRestart()
        Log.v("TAG", "onRestart")
    }

    override fun onResume() {
        super.onResume()
        Log.v("TAG", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.v("TAG", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.v("TAG", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.v("TAG", "onDestroy")
    }
}