
import com.lgw.kotlinboard.common.BusinessCode
import com.lgw.kotlinboard.product.dto.ProductRequest
import com.lgw.kotlinboard.product.service.ProductService
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/api/product")
class ProductController (private val productService : ProductService){

    @GetMapping("/list")
    fun getProductList () : List<Product> {
        return  productService.getProdList();

    }
    @PostMapping( "/add")
    suspend fun createProduct (@RequestBody productRequest: ProductRequest) : BusinessCode {
        // prodRequest 를 내부 data class 로 변환 후 결과값을 BusinessCode 로 반환
        val BusinessCode = productService.createProductInfo(productRequest.toModel());
        return BusinessCode;
    }


    // 응답값 객체 변환
    private fun ProductRequest.toModel(): Product =
            Product(
                    prodId = this.prodId,
                    prodNm = this.prodNm,
                    prodSubNm = this.prodSubNm,
                    prodTypeCd = this.prodTypeCd,
                    prodPaymentWait = this.prodPaymentWait

            )

}