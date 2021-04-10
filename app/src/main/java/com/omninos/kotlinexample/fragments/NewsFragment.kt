package com.omninos.kotlinexample.fragments


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.omninos.kotlinexample.R
import com.omninos.kotlinexample.activity.WebActivity
import com.omninos.kotlinexample.adapter.NewsAdapter
import com.omninos.kotlinexample.modelClass.ResonseClass
import com.omninos.kotlinexample.myViewModel.GetNewsViewModel
import com.omninos.kotlinexample.util.App
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * A simple [Fragment] subclass.
 */
class NewsFragment : Fragment() {

    lateinit var recyclerView: RecyclerView
    lateinit var getNewsViewModel: GetNewsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_news, container, false)

        getNewsViewModel = ViewModelProviders.of(this).get(GetNewsViewModel::class.java)
        recyclerView = view.findViewById(R.id.recyclerView)

        val layoutManager = LinearLayoutManager(activity)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        recyclerView.layoutManager = layoutManager

        App.sinltonPojo!!.data = "Kiran"


        App.appPreference!!.SaveString("Data", "AMit")

        print("Data Is: " + App.appPreference!!.GetString("Data"))

        CoroutineScope(Dispatchers.Main).launch {
            getNewsViewModel.checkphonenumber(activity!!)
                .observe(activity!!, object : Observer<ResonseClass> {
                    override fun onChanged(t: ResonseClass?) {
                        recyclerView.adapter = NewsAdapter(
                            t!!.articles!!,
                            activity!!,
                            ({
                                startActivity(
                                    Intent(activity, WebActivity::class.java).putExtra(
                                        "Url",
                                        t.articles!!.get(it).url
                                    )
                                )
                            })
                        )
                    }
                })
        }

        return view
    }


}
