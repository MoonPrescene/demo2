package com.example.demo2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.demo2.adapter.ProductAdapter
import com.example.demo2.commons.toCurrency
import com.example.demo2.databinding.ActivityMainBinding
import com.example.demo2.models.Products


class MainActivity : AppCompatActivity(), ProductAdapter.OnButtonClickListener {

    private lateinit var binding: ActivityMainBinding

    private lateinit var productsAdapter: ProductAdapter

    private var products: ArrayList<Products> = arrayListOf(
        Products("Dark Soul",
            "https://muagame.vn/cdn1/images/201903/thumb_img/dia-game-ps4-sekiro-shadows-die-twice-he-asia-thumb-G1162-1553203773973.jpg",
            800000.0, 0),
        Products("BloodBorne",
            "https://s3-ap-southeast-1.amazonaws.com/avatars.mservice.io/uploads/cinema-2.0/56685032294131102-Untitled-1.jpg",
            800000.0, 0),
        Products("Sekiro",
            "https://s3-ap-southeast-1.amazonaws.com/avatars.mservice.io/uploads/cinema-2.0/56685032294131102-Untitled-1.jpg",
            800000.0,0)
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.apply {
                allMoneyButton.setOnClickListener {
                    sumPrice.text = allProduct(products).toCurrency()
                }
        }
                setUpAdapters()
    }

    private fun setUpAdapters(){
        productsAdapter = ProductAdapter(products, this)
        //nhớ set id cho recyclerview =.='
        binding.recyclerView.apply {
            adapter = productsAdapter
            layoutManager = LinearLayoutManager(context)
        }
    }

    override fun deleteProduct(product: Products) {
        productsAdapter.products.remove(product)
        productsAdapter.notifyDataSetChanged()
    }

    override fun addProduct(product: Products){
        product.addProduct()
    }

    override fun subProduct(product: Products) {
        product.subProduct()
    }

    fun allProduct(product: ArrayList<Products>): Double{
        var sum: Double = 0.0
        for (i in product){
            sum += i.sumPrice()
        }
        return sum
    }
}
