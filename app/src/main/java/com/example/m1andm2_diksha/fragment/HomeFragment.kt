package com.example.m1andm2_diksha.fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.m1andm2_diksha.ModelClass
import com.example.m1andm2_diksha.MyAdapter
import com.example.m1andm2_diksha.R

class HomeFragment : Fragment() {
    lateinit var My_RecyclerView: RecyclerView
    lateinit var Adapter: MyAdapter
    var array: ArrayList<ModelClass> = ArrayList()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)


        My_RecyclerView = view.findViewById(R.id.my_recycler)

        var data1 = ModelClass(
            "Msajankk",
            "https://cdn.zeplin.io/610ccdbb463f716192391cbc/assets/24627ca5-7c0a-442b-821d-e90f1849545f.png",
            "Cabinet approves Idia-Fiji","Weather","Okhla Phase 2"
        )

        var data2 = ModelClass(
            "Ashvh Ajs",
            "https://cdn.zeplin.io/610ccdbb463f716192391cbc/assets/97eea924-ab5f-4c0a-bb47-dff6ef8932cf.png",
            "Cabinet Fiji MoU for...","Event","Lajpat Nagar"
        )

        var data3 = ModelClass(
            "Msajankk",
            "https://cdn.zeplin.io/610ccdbb463f716192391cbc/assets/2fd442a3-b630-4958-9d7c-cb4326dfe509.png",
            "Cabinet approves Idia-Fiji","Crime","Okhla Phase 2"
        )
        var data4 = ModelClass(
            "Ashvh Ajs",
            "https://cdn.zeplin.io/610ccdbb463f716192391cbc/assets/5d8df8b7-5d7c-40df-836e-beefedf8af04.png",
            "Cabinet Fiji MoU for...","Traffic","Saket"
        )
        var data5 = ModelClass(
            "Msajankk",
            "https://cdn.zeplin.io/610ccdbb463f716192391cbc/assets/24627ca5-7c0a-442b-821d-e90f1849545f.png",
            "Cabinet approves Idia-Fiji","Weather","Okhla Phase 2"
        )

        var data6 = ModelClass(
            "Ashvh Ajs",
            "https://cdn.zeplin.io/610ccdbb463f716192391cbc/assets/97eea924-ab5f-4c0a-bb47-dff6ef8932cf.png",
            "Cabinet Fiji MoU for...","Event","Lajpat Nagar"
        )

        var data7 = ModelClass(
            "Msajankk",
            "https://cdn.zeplin.io/610ccdbb463f716192391cbc/assets/2fd442a3-b630-4958-9d7c-cb4326dfe509.png",
            "Cabinet approves Idia-Fiji","Crime","Okhla Phase 2"
        )
        var data8 = ModelClass(
            "Ashvh Ajs",
            "https://cdn.zeplin.io/610ccdbb463f716192391cbc/assets/5d8df8b7-5d7c-40df-836e-beefedf8af04.png",
            "Cabinet Fiji MoU for...","Traffic","Saket"
        )



        array.add(data1)
        array.add(data2)
        array.add(data3)
        array.add(data4)
        array.add(data5)
        array.add(data6)
        array.add(data7)
        array.add(data8)
        // this creates a vertical layout Manager
        My_RecyclerView.layoutManager = GridLayoutManager(activity,2)
        // This will pass the ArrayList to our Adapter
        Adapter = MyAdapter(activity as Context, array)

        // Setting the Adapter with the recyclerview
        My_RecyclerView.adapter = Adapter

        return view
    }



    /*private fun GridLayoutManager(mainActivity: MainActivity): RecyclerView.LayoutManager? {
        TODO("Not yet implemented")
    }*/




}