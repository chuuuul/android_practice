package com.chul.fragment_practice.exam2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.chul.fragment_practice.R
import kotlinx.android.synthetic.main.exam2_activity_main.*
import kotlinx.android.synthetic.main.exam2_fragment_content.*


class ContentFragment : Fragment() {

    interface OnInputTextListener {
        fun onInputText(text: String)
    }

    var onInputTextListener: OnInputTextListener? = null

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        btn_confirm.setOnClickListener {
            onInputTextListener?.onInputText("확인되었습니다.")
        }
    }

    fun setActivityText(text: String?) {
        tv_fragmentContent.text = text
    }

    fun setOnInputTextListener( listener : (text : String)-> Unit ){
        this.onInputTextListener = object : OnInputTextListener{
            override fun onInputText(text: String) {
                listener(text)
            }
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.exam2_fragment_content, container, false)
    }

}
