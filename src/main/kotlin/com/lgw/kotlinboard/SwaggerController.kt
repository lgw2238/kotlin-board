package com.lgw.kotlinboard

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class SwaggerController {

    @GetMapping("/getTest")
    fun getTest(): String {

            return "1234";
    }

    @PostMapping("/postTest")
    fun postTest(
            @RequestParam name : String
    ) : String {

        return "postTest : ${name}"
    }

}