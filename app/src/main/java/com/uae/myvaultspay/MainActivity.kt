package com.uae.myvaultspay

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.myvaultspay.usermodule.MainActivityA
import com.myvaultspay.merchantmodule.MainActivityB

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        findViewById<TextView>(R.id.tv_moveToA).setOnClickListener {
            startActivity(Intent(this, MainActivityA::class.java))
        }

        findViewById<TextView>(R.id.tv_moveToB).setOnClickListener {
            startActivity(Intent(this, MainActivityB::class.java))
        }
    }
}