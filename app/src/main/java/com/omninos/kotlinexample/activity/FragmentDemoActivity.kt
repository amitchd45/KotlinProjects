package com.omninos.kotlinexample.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import com.omninos.kotlinexample.R
import com.omninos.kotlinexample.fragments.NewsFragment
import com.omninos.kotlinexample.fragments.SampleFragment

class FragmentDemoActivity : AppCompatActivity() {

    lateinit var fragmentManager: FragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment_demo)

        fragmentManager = supportFragmentManager
        val fm = fragmentManager.beginTransaction()
        fm.add(R.id.topFrame, NewsFragment())
        fm.commitAllowingStateLoss()
    }
}
