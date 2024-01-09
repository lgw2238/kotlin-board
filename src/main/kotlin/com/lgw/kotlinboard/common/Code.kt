package com.lgw.kotlinboard.common

import org.springframework.http.HttpStatus

class Code(
    val service: ServiceError,
    val id: HttpStatus? = null,
    val code: String? = null,
    val message: String? = null,
    val link: String? = null,
    val resultData: Any? = null
) {

    enum class CodeName(val id: HttpStatus, val code: String, val message: String) {
        SUCCESS(HttpStatus.OK, "200", "성공"),
        ERR_PARAM(HttpStatus.BAD_REQUEST, "9001", "파라미터가 에러가 발생하였습니다."),
        ERR_INVALID_USER(HttpStatus.UNAUTHORIZED, "9002", "유효하지 않은 사용자입니다."), //401
        ERR_LOGIN(HttpStatus.BAD_REQUEST, "9003", "클라이언트 인증에 실패했습니다.다시 시도 바랍니다."), //401
        ERR_NOT_FOUND(HttpStatus.NOT_FOUND, "9004", "찾을 수 없는 정보입니다."),
        ERR_CONFLICT(HttpStatus.CONFLICT, "9005", "사용하고 있는 내역이 존재합니다."),
        ERR_FORBIDDEN(HttpStatus.FORBIDDEN, "9006", "불가능한 요청 상태입니다."),
        ERR_FORBIDDEN_REPUR(HttpStatus.FORBIDDEN, "9012", "재구매가 불가능한 상태입니다."),
        ERR_AUTH_REQ(HttpStatus.UNAUTHORIZED, "9007", "인증이 필요합니다."),
        ERR_SIGNATURE(HttpStatus.BAD_REQUEST, "9008", "SIGNATURE 검증에 실패 했습니다."),
        ERR_DUPLICATION(HttpStatus.CONFLICT, "9009", "이미 신청한 내역이 존재합니다."),
        ERR_SALE_STATUS(HttpStatus.CONFLICT, "9010", "판매 수량이 초과되었습니다."),
        ERR_GAMEPASS_EXIST(HttpStatus.CONFLICT, "9013", "현재 이용중인 상품이 존재합니다."),
        ERR_SALE_END(HttpStatus.CONFLICT, "9011", "판매가 종료된 상품입니다."),
        ERR_USR_CORP_PARAM(HttpStatus.BAD_REQUEST, "9052", "법인 회선은 서비스 가입이 불가합니다."),
        ERR_USR_CI_PARAM(HttpStatus.BAD_REQUEST, "9050", "CI정보가 없습니다."),
        ERR_REQ_RETRY(HttpStatus.BAD_REQUEST, "9051", "재처리 필요합니다."),
        ERR_ORDER_UPDATE(HttpStatus.BAD_REQUEST, "9101", "주소정보 업데이트 실패했습니다."),
        ERR_ORDER_SELECT(HttpStatus.BAD_REQUEST, "9102", "주소정보가 존재하지 않습니다."),
        ERR_API_CSP(HttpStatus.GATEWAY_TIMEOUT, "9201", "CSP 연동에러"),
        ERR_API_SKN(HttpStatus.GATEWAY_TIMEOUT, "9301", "SKN 연동에러"),
        ERR_SERVER(HttpStatus.INTERNAL_SERVER_ERROR, "9999", "서버 에러(Server error)");
    }

    enum class ServiceError(val service: String) {
        COMMON("common"),
        AUTH("auth"),
        API("api"),
        API_SKN("api_skn"),
        API_CHECK("api_check"),
        BOARD("board"),
        EVENT("event"),
        ORDER("order"),
        ORDER_CHECK("order_check"),
        ORDER_PERIOD("order_period"),
        ORDER_ESCALATION("order_escalation"),
        ONESTORE("onestore"),
        SKPAY("skpay"),
        CSP("csp"),
        EPAY("epay"),
        SWING("swing"),
        SMS("sms"),
        CODE("code"),
        ETC("etc");
    }
}