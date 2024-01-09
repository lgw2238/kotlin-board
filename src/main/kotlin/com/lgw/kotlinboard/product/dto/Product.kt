package com.lgw.kotlinboard.product.dto

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import org.springframework.data.annotation.Id

@Entity
data class Product (

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "prod_id")
        val prodId: String,
        val prodNm: String,
        val prodSubNm: String,
        val prodTypeCd: String,
        val prodPaymentWait : Int = 0

) {
        fun toRequestProductDTO(): ProductRequest {
            return ProductRequest(

                    prodId = prodId,
                    prodNm = prodNm,
                    prodSubNm = prodSubNm,
                    prodTypeCd = prodTypeCd,
            )
        }

        fun toCreateProductDTO(): ProductResponse {
            return ProductResponse(
                    prodId = prodId,
                    prodNm = prodNm,
                    prodSubNm = prodSubNm,
                    prodTypeCd = prodTypeCd,
            )
        }
        }