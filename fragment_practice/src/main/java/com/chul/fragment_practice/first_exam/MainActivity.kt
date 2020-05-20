package com.chul.fragment_practice.first_exam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.chul.fragment_practice.R
import kotlinx.android.synthetic.main.exam1_activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.exam1_activity_main)

        button1.setOnClickListener {
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(
                R.id.layout_frameLayout,
                FirstFragment()
            )
            transaction.addToBackStack(null)
            transaction.commit()
        }

        button2.setOnClickListener {
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(
                R.id.layout_frameLayout,
                SecondFragment()
            )
            transaction.addToBackStack(null)
            transaction.commit()
        }
    }
}
