package com.omninos.kotlinexample.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import com.omninos.kotlinexample.R

/**
 * A simple [Fragment] subclass.
 */
class SecondFragment : Fragment() {

    lateinit var data:TextView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val  view=inflater.inflate(R.layout.fragment_second, container, false)

        data=view.findViewById(R.id.data)

        data.text=arguments?.get("Data").toString()
        return view
    }


}
