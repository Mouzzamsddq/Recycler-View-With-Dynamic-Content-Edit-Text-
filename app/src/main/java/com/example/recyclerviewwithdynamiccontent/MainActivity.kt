package com.example.recyclerviewwithdynamiccontent

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerviewwithdynamiccontent.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null
    private val dynamicContentList = mutableListOf<String>()
    private val dynamicContentAdapter: DynamicContentAdapter by lazy {
        DynamicContentAdapter(this@MainActivity)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this@MainActivity))
        setContentView(binding?.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        initDynamicRv()
        initDynamicContent()
    }

    private fun initDynamicRv() {
        binding?.let {
            it.dynamicContentRv.layoutManager = LinearLayoutManager(this@MainActivity)
            it.dynamicContentRv.adapter = dynamicContentAdapter
        }
    }


    private fun initDynamicContent() {
        dynamicContentList.add("Enter first name")
        dynamicContentList.add("Enter last name")
        dynamicContentList.add("Enter age")
        dynamicContentList.add("Enter address")
        dynamicContentList.add("Enter pincode")
        dynamicContentList.add("Enter Mother Name")
        dynamicContentList.add("Enter Father Name")
        dynamicContentList.add("Enter School Name")
        dynamicContentList.add("Enter City Name")
        dynamicContentList.add("Enter State Name")
        dynamicContentList.add("Enter Country Name")
        dynamicContentList.add("Enter Friend Name")
        dynamicContentList.add("Enter Company Name")
        dynamicContentList.add("Enter College Name")
        dynamicContentList.add("Enter College City Name")
        dynamicContentList.add("Enter Laptop Name")
        dynamicContentList.add("Enter Mobile Name")
        dynamicContentList.add("Enter Mouse Name")
        dynamicContentAdapter.setData(dynamicContentList)
    }
}