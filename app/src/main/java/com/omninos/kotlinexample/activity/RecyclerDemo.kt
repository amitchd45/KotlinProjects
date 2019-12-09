package com.omninos.kotlinexample.activity

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.omninos.kotlinexample.R
import com.omninos.kotlinexample.adapter.AdapterClass

class RecyclerDemo : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var edit: EditText
    lateinit var addButton: Button

    val listitems : ArrayList<String> =ArrayList()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_demo)

        initView()
        SetUp()
    }

    private fun initView() {

        recyclerView = findViewById(R.id.recyclerView)
        addButton=findViewById(R.id.addButton)
        edit=findViewById(R.id.edit)

        val layoutManager=LinearLayoutManager(this)
        layoutManager.orientation=LinearLayoutManager.VERTICAL
        recyclerView.layoutManager=layoutManager

        recyclerView.adapter= AdapterClass(listitems, this, ({
            listitems.removeAt(it)
            (recyclerView.adapter as AdapterClass).notifyDataSetChanged()
        }))

        addButton.setOnClickListener {
            val data:String
            data=edit.text.toString()
            if (!data.isEmpty()){
                listitems.add(data)
                (recyclerView.adapter as AdapterClass).notifyDataSetChanged()
            }
        }
    }

    private fun SetUp() {
        listitems.add("A")
        listitems.add("B")
        listitems.add("C")
        listitems.add("D")
        listitems.add("E")
    }
}
