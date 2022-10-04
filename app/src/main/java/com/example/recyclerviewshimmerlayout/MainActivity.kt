package com.example.recyclerviewshimmerlayout

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    var arrayList: ArrayList<ModelClass> = ArrayList()
    var data = arrayOf("a", "b", "c", "d", "e", "f", "g", "h", "i")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        shimmerLayout?.startShimmer()

        val handler = Handler(Looper.getMainLooper())
        handler.postDelayed({ setupRecyclerView() }, 5000)
    }

    private fun setupRecyclerView() {
        val myAdapter = MyAdapter(this, getData())
        recyclerView?.layoutManager = LinearLayoutManager(this)
        recyclerView?.itemAnimator = DefaultItemAnimator()
        recyclerView?.addItemDecoration(
            DividerItemDecoration(
                this,
                LinearLayoutManager.VERTICAL
            )
        )
        recyclerView?.adapter = myAdapter
        shimmerLayout?.stopShimmer()
        shimmerLayout?.visibility = View.GONE
        recyclerView?.visibility = View.VISIBLE
    }

    private fun getData(): ArrayList<ModelClass> {
        for (element in data) {
            arrayList.add(ModelClass(element))
        }
        return arrayList
    }
}