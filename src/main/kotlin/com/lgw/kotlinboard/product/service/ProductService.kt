package com.lgw.kotlinboard.product.service

import com.lgw.kotlinboard.common.BusinessCode
import com.lgw.kotlinboard.common.Code
import com.lgw.kotlinboard.product.dto.ProductResponse
import com.lgw.kotlinboard.product.repository.ProductRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class ProductService
//(
//    private val productRepository: ProductRepository
//)
{
    @Autowired
    lateinit var productRepository: ProductRepository

    // 상품 정보 전체 조회
    fun getProdList(): List<ProductResponse> {
        val product = productRepository.findAll()
        return product.map { it.ProductResponse() }
    }

    // 상품 정보 생성
    suspend fun createProductInfo (product : Product) : BusinessCode{
        val result = productRepository.save(product);
       // val result = productRepository.createProductInfo(product);
        if (!result.prodId.isNullOrEmpty()){
            return BusinessCode(Code.ServiceError.API, Code.CodeName.SUCCESS);
        }else{
            return BusinessCode(Code.ServiceError.API, Code.CodeName.ERR_SERVER);
        }




    }









}