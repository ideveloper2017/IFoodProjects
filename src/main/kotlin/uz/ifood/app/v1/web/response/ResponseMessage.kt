package uz.ifood.app.api.v1.web.response

import org.springframework.http.HttpStatus

data class ResponseMessage<T>(var status: HttpStatus?, var message: String?,val data:T)
