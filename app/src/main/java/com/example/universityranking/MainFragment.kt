package com.example.universityranking

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class MainFragment : Fragment() {

    lateinit var universitys: RecyclerView
    lateinit var news: RecyclerView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_main, container, false)
        universitys = view.findViewById(R.id.universitys_rec)
        news = view.findViewById(R.id.news_rec)
        return view
    }


}
