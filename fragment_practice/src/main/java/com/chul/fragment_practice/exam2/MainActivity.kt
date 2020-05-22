package com.chul.fragment_practice.exam2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.chul.fragment_practice.R
import kotlinx.android.synthetic.main.exam2_activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.exam2_activity_main)

        btn_send.setOnClickListener{
            val fragment = supportFragmentManager.findFragmentById(R.id.layout_fragment)

            if(fragment is ContentFragment)
                fragment.setActivityText(et_inputText.text.toString())
        }

        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.layout_fragment, ContentFragment())
        transaction.commit()

    }

    override fun onAttachFragment(fragment: Fragment) {
        super.onAttachFragment(fragment)

        if(fragment is ContentFragment){
            fragment.setOnInputTextListener {
                tv_fragmentText.text = it
            }
        }
    }


}
