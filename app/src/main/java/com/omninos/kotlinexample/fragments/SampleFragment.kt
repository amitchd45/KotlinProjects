package com.omninos.kotlinexample.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.FragmentManager

import com.omninos.kotlinexample.R

/**
 * A simple [Fragment] subclass.
 */
class SampleFragment : Fragment() {

    lateinit var firstFrame:EditText
    lateinit var buttonClick:Button
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view=inflater.inflate(R.layout.fragment_sample, container, false)

        firstFrame=view.findViewById(R.id.firstFrame)
        buttonClick=view.findViewById(R.id.buttonClick)

        buttonClick.setOnClickListener {
            val data=firstFrame.text.toString()
            val fragment = SecondFragment()
            var bundle: Bundle? =null
            bundle?.putString("Data",data)
            fragment.arguments=bundle
            val fragmentManager = getFragmentManager()
            val tm=fragmentManager?.beginTransaction()
            tm?.replace(R.id.topFrame,fragment)
            tm?.commitAllowingStateLoss()
        }
        return view
    }


}
