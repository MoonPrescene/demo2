package com.example.demo2.models

class Products(
    var productName: String = "",
    var productImage: String = "",
    var productPrice: Double = 0.0,
    var productNumber: Int = 0
){
    fun getPrice(): String{
        return "${productPrice} + đ/ONG"
    }
}