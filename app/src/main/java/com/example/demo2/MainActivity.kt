package com.example.demo2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.demo2.adapter.ProductAdapter
import com.example.demo2.databinding.ActivityMainBinding
import com.example.demo2.models.Products


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var productsAdapter: ProductAdapter

    private var products: ArrayList<Products> = arrayListOf(
        Products("Dark Soul",
            "",
            800000.0, 0),
        Products("BloodBorne",
            "",
            800000.0, 0),
        Products("Sekiro",
            "",
            800000.0,0)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        setUpAdapters()
    }

    private fun setUpAdapters(){
        productsAdapter = ProductAdapter(products)
        //nhớ set id cho recyclerview =.='
        binding.recyclerView.apply {
            adapter = productsAdapter
            layoutManager = LinearLayoutManager(context)
        }
    }
}