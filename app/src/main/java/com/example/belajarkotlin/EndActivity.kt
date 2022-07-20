package com.example.belajarkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

var sizeText : Float = 14F

class EndActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_end)

        val actionBar = supportActionBar
        actionBar?.title = "Kamu Jadi Pacar Saya"

        var textView = findViewById<TextView>(R.id.tv_test)
        var tombol = findViewById<TextView>(R.id.klik)

        textView.setTextSize(sizeText)

        tombol.setOnClickListener() {
            sizeText = sizeText + 5
            textView.setTextSize(sizeText)
        }
    }
}