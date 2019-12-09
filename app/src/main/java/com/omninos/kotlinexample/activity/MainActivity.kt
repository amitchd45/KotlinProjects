package com.omninos.kotlinexample.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.omninos.kotlinexample.R

class MainActivity : AppCompatActivity() {

    lateinit var textView: TextView
    lateinit var edit_data: EditText
    lateinit var buttonClick: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.txt)
        edit_data = findViewById(R.id.edit_data)
        buttonClick = findViewById(R.id.buttonClick)

        Toast.makeText(this, textView.text, Toast.LENGTH_LONG).show()

        buttonClick.setOnClickListener {
            getData()
        }
    }

    private fun getData() {
        var editData:String
        editData= edit_data.text.toString()
        if (editData.isEmpty()){
            Toast.makeText(this,"enter value",Toast.LENGTH_LONG).show()
        }else{
            textView.setText(editData)
            startActivity(Intent(this, RecyclerDemo::class.java))
        }
    }
}
