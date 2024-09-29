package com.example.recyclerviewwithdynamiccontent

import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerviewwithdynamiccontent.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null
    private val dynamicContentList = mutableListOf<RandomInput>()
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
        dynamicContentList.add(RandomInput(1,"Enter first name", ""))
        dynamicContentList.add(RandomInput(2,"Enter last name", ""))
        dynamicContentList.add(RandomInput(3,"Enter age", ""))
        dynamicContentList.add(RandomInput(4,"Enter address", ""))
        dynamicContentList.add(RandomInput(5, "Enter pincode", ""))
        dynamicContentList.add(RandomInput(6, "Enter Father Name", ""))
        dynamicContentList.add(RandomInput(7, "Enter School Name", ""))
        dynamicContentList.add(RandomInput(8,"Enter City Name", ""))
        dynamicContentList.add(RandomInput(9,"Enter State Name", ""))
        dynamicContentList.add(RandomInput(10,"Enter Country Name", ""))
        dynamicContentList.add(RandomInput(11,"Enter Friend Name", ""))
        dynamicContentList.add(RandomInput(12,"Enter Company Name", ""))
        dynamicContentList.add(RandomInput(13,"Enter College Name", ""))
        dynamicContentList.add(RandomInput(14,"Enter College City Name", ""))
        dynamicContentList.add(RandomInput(15,"Enter Laptop Name", ""))
        dynamicContentList.add(RandomInput(16,"Enter Random Name", ""))
        dynamicContentList.add(RandomInput(17,"Enter Random 2 Name", ""))
        dynamicContentAdapter.setData(dynamicContentList)
    }
}