package com.example.demo2.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.demo2.R
import com.example.demo2.databinding.ItemLayoutBinding
import com.example.demo2.models.Products
import com.squareup.picasso.Picasso



class ProductAdapter(var products: ArrayList<Products>, val onButtonClickListener: OnButtonClickListener): RecyclerView.Adapter<ProductAdapter.ViewHolder>() {
    class ViewHolder(private val binding: ItemLayoutBinding, val onButtonClickListener: OnButtonClickListener): RecyclerView.ViewHolder(binding.root) {
        fun bindView(product: Products){
            binding.product = product


            binding.apply {
                Picasso.get()
                    .load(product.productImage)
                    .into(productImageView)
                addProductButton.setOnClickListener {
                    onButtonClickListener.addProduct(product)
                    numberOfProduct.text = product.getProductNumberStr()
                }
                subProductButton.setOnClickListener {
                    onButtonClickListener.subProduct(product)
                    numberOfProduct.text = product.getProductNumberStr()
                }
                deleteButton.setOnClickListener {
                    onButtonClickListener.deleteProduct(product)
                }
            }
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
        return ViewHolder(binding, onButtonClickListener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       val product = products[position]
        holder.bindView(product)
    }

    override fun getItemCount(): Int {
        return products.size
    }

    interface OnButtonClickListener {
        fun deleteProduct(product: Products)
        fun addProduct(product: Products)
        fun subProduct(product: Products)

    }
}
