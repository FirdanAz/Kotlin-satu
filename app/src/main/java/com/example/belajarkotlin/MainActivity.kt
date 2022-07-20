package com.example.belajarkotlin

import android.app.ActionBar
import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.transition.Slide
import android.transition.TransitionManager
import android.view.Gravity
import android.view.View
import android.widget.*
import androidx.core.view.isGone
import androidx.core.view.isVisible
import java.util.*
import java.util.concurrent.Delayed
import kotlin.concurrent.schedule

class MainActivity : AppCompatActivity() {
    private lateinit var btn_oke : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn1 = findViewById<Button>(R.id.btn_tidak)
        val btn2 = findViewById<Button>(R.id.btn_tidak2)
        val btn3 = findViewById<Button>(R.id.btn_tidak3)
        val btn4 = findViewById<Button>(R.id.btn_tidak4)
        val rv = findViewById<RelativeLayout>(R.id.relative_layout)

        Handler().postDelayed({
            dialog()
        }, 15000)

        val actionBar = supportActionBar
        actionBar?.title = getString(R.string.title)

        btn_oke = findViewById(R.id.btn_mau)

        btn_oke.setOnClickListener() {

            val intent = Intent(this, EndActivity::class.java )
            startActivity(intent)

        }
        btn1.setOnClickListener() {
            btn1.visibility = View.GONE
            btn3.visibility = View.GONE
            btn4.visibility = View.GONE

            val mSlideLeft = Slide()
            mSlideLeft.slideEdge = Gravity.LEFT
            TransitionManager.beginDelayedTransition(rv, mSlideLeft)
            btn2.visibility = View.VISIBLE
        }
        btn2.setOnClickListener() {
            btn1.visibility = View.GONE
            btn2.visibility = View.GONE
            btn4.visibility = View.GONE

            val mSlideLeft = Slide()
            mSlideLeft.slideEdge = Gravity.RIGHT
            TransitionManager.beginDelayedTransition(rv, mSlideLeft)
            btn3.visibility = View.VISIBLE
        }
        btn3.setOnClickListener() {
            btn1.visibility = View.GONE
            btn2.visibility = View.GONE
            btn3.visibility = View.GONE

            val mSlideLeft = Slide()
            mSlideLeft.slideEdge = Gravity.LEFT
            TransitionManager.beginDelayedTransition(rv, mSlideLeft)
            btn4.visibility = View.VISIBLE
        }
        btn4.setOnClickListener() {
            btn2.visibility = View.GONE
            btn3.visibility = View.GONE
            btn4.visibility = View.GONE

            val mSlideLeft = Slide()
            mSlideLeft.slideEdge = Gravity.RIGHT
            TransitionManager.beginDelayedTransition(rv, mSlideLeft)
            btn1.visibility = View.VISIBLE
        }
    }
    private fun dialog() {

        val builder = AlertDialog.Builder(this)
        builder.setTitle("Masih mau lanjut????")
        builder.setMessage("Menyerah berarti mau jadi pacar saya!")

        builder.setPositiveButton("Menyerah") { dialog, which ->
            val intent = Intent(this, EndActivity::class.java )
            startActivity(intent)
        }

        builder.setNegativeButton("Lanjut") { dialog, which ->
            Toast.makeText(this, "ngeyell!", Toast.LENGTH_SHORT).show()
            Handler().postDelayed({
                dialog()
            }, 15000)
        }
        builder.show()
    }
}