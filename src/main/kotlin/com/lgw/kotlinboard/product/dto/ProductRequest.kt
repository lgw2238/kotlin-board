package com.lgw.kotlinboard.product.dto

data class ProductRequest(
        val prodId: String,
        val prodNm: String,
        val prodTypeCd: String,
        val prodSubNm: String?,
        val prodPaymentWait: Int? = 0
)
