package com.example.demo2.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.demo2.R
import com.example.demo2.databinding.ItemLayoutBinding
import com.example.demo2.models.Products

class ProductAdapter(var products: ArrayList<Products>): RecyclerView.Adapter<ProductAdapter.ViewHolder>() {
    class ViewHolder(val binding: ItemLayoutBinding): RecyclerView.ViewHolder(binding.root) {
        fun bindView(product: Products){
            binding.product = product

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: ItemLayoutBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.item_layout,
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       val product = products[position]
        holder.bindView(product)
    }

    override fun getItemCount(): Int {
        return products.size
    }
}