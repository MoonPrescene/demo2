package com.example.demo2.models

class Products(
    var productName: String = "",
    var productImage: String = "",
    var productPrice: Double = 0.0,
    var productNumber: Int = 0
){
    fun getPrice(): String{
        return "$productPrice + đ/ONG"
    }

    fun getProductNumberStr(): String{
        return "$productNumber"
    }

    fun addProduct(): Int{
        productNumber++
        return productNumber
    }

    fun subProduct(): Int{
         return if(productNumber > 0){
             productNumber--
             productNumber
         }else{
             0
         }
    }

    fun sumPrice(): Double{
        return productPrice*productNumber.toDouble()
    }
}