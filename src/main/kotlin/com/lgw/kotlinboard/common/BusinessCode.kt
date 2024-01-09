package com.lgw.kotlinboard.common

import org.springframework.http.HttpStatus


class BusinessCode (
    var service: Code.ServiceError,
    var id: HttpStatus,
    var code: String? = null,
    var message: String? = null,
    var resultData: Any? = null
){

    constructor(service: Code.ServiceError, codeName: Code.CodeName) : this(
        service = service,
        id = codeName.id,
        code = codeName.code,
        message = codeName.message
    )

    constructor(service: Code.ServiceError, codeName: Code.CodeName, message: String) : this(
        service = service,
        id = codeName.id,
        code = codeName.code,
        message = message
    )

    constructor(service: Code.ServiceError, codeName: Code.CodeName, resultData: Any) : this(
        service = service,
        id = codeName.id,
        code = codeName.code,
        message = codeName.message,
        resultData = resultData
    )

    constructor(service: Code.ServiceError, codeName: Code.CodeName, resultData: Any, message: String) : this(
        service = service,
        id = codeName.id,
        code = codeName.code,
        message = message,
        resultData = resultData
    )


}