package com.lgw.kotlinboard.product.repository

import org.springframework.data.jpa.repository.JpaRepository


interface ProductRepository : JpaRepository<Product, Long> {

//    fun createProductInfo (product: Product) : Product

}