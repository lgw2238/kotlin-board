package com.lgw.kotlinboard

import com.fasterxml.jackson.databind.ObjectMapper
import org.hibernate.query.sqm.tree.SqmNode.log
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.http.ResponseEntity
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.HttpClientErrorException
import org.springframework.web.client.HttpServerErrorException
import org.springframework.web.client.RestTemplate
import org.springframework.web.util.UriComponents
import org.springframework.web.util.UriComponentsBuilder

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

    @GetMapping("/callRestTemplate")
    fun callRestTemplate() {
        val headers = HttpHeaders()
        val factory = HttpComponentsClientHttpRequestFactory();

        factory.setConnectTimeout(5000)
        val restTemplate = RestTemplate(factory)
//        headers.set("Authorization", "Bearer <access_token>")
        val response = restTemplate.exchange("https://www.google.com", HttpMethod.GET, null, String::class.java, headers)
        println(response.body)
    }

    @GetMapping("/getKobisData")
    fun callAPI() : String {

        val result  = HashMap<String, Any>()
        var jsonInString = ""

        try {
            val factory = HttpComponentsClientHttpRequestFactory();

            factory.setConnectTimeout(5000)

            val restTemplate = RestTemplate(factory)
            //restTemplate은 Rest방식 api를 호출할 수 있는 spring 내장 클래스이다.
            //json, xml 응답을 모두 받을 수 있다.

            //header 클래스를 정의해 주고, url을 정의해 주고 exchange method로 api를 호출한다.
            val header = HttpHeaders()
            //header.contentType= MediaType.parseMediaType("application/json")

            val entity = HttpEntity<Map<String, Any>>(header)
            val url = "http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json"
            val uri : UriComponents
                    = UriComponentsBuilder.fromHttpUrl(url + "?" + "key=827c3342e912bdb8cdbeb7cf0625b764&targetDt=20210430").build()
            System.out.println("uri: " +uri);
            //api를 호출하여 데이터를 MAP타입으로 전달 받는다.
            val resultMap : ResponseEntity<Map<*, *>>
                    = restTemplate.exchange(uri.toString(), HttpMethod.GET, entity, Map::class.java)

            result.put("statusCode", resultMap.getStatusCodeValue()); //http status code를 확인
            result.put("header", resultMap.getHeaders()); //헤더 정보 확인
            resultMap.body?.let { result.put("body", it) };
            //result.put("body", resultMap.getBody())로 넣을 수 없었다. null 가능성 때문인 것 같다.

            //데이터를 string형태로 파싱해줌
            val mapper = ObjectMapper()
            jsonInString = mapper.writeValueAsString(resultMap.getBody());
            System.out.println("jsonInString: " +jsonInString);
        } catch (e: Exception){
            when(e) {
                is HttpClientErrorException, is HttpServerErrorException -> {
                    result.put("statusCode", "e.getStatusCode()"); //여기랑
                    result.put("body", "e.getStatusText()"); //여기는 kotlin에서 오류가 났다. 그래서 함수를 그냥 따옴표로 감싸버림.. 확인 필요
                    System.out.println("error!");
                    System.out.println(e.toString());
                }else -> {
                result.put("statusCode", "999");
                result.put("body", "excpetion오류");
                System.out.println(e.toString());
            }
            }
        }

        return jsonInString;
    }
}