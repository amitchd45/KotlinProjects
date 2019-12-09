package com.omninos.kotlinexample.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.omninos.kotlinexample.R
import com.omninos.kotlinexample.adapter.NewsAdapter
import com.omninos.kotlinexample.modelClass.ResonseClass
import com.omninos.kotlinexample.myViewModel.GetNewsViewModel
import com.omninos.kotlinexample.util.App
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RetroActivity : AppCompatActivity() {


    lateinit var recyclerView: RecyclerView
    lateinit var getNewsViewModel: GetNewsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retro)

        recyclerView = findViewById(R.id.recyclerView)

        getNewsViewModel = ViewModelProviders.of(this).get(GetNewsViewModel::class.java)


        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        recyclerView.layoutManager = layoutManager

        App.sinltonPojo!!.data = "Mohan"


        App.appPreference!!.SaveString("Data", "Manjinder")

        print("Data Is: " + App.appPreference!!.GetString("Data"))

        CoroutineScope(Dispatchers.Main).launch {
            getNewsViewModel.checkphonenumber(this@RetroActivity)
                .observe(this@RetroActivity, object : Observer<ResonseClass> {
                    override fun onChanged(t: ResonseClass?) {
                        recyclerView.adapter = NewsAdapter(
                            t!!.articles!!,
                            this@RetroActivity,
                            ({
                                startActivity(
                                    Intent(this@RetroActivity, WebActivity::class.java).putExtra(
                                        "Url",
                                        t.articles!!.get(it).url
                                    )
                                )
                            })
                        )
                    }
                })
        }

    }
}
