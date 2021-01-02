//package com.example.politicsagora.util.network
//
//import com.google.gson.Gson
//import kotlinx.coroutines.CoroutineScope
//import kotlinx.coroutines.withContext
//import retrofit2.HttpException
//import kotlin.coroutines.coroutineContext
//
//data class ErrorResponse(
//    val message: String
//) : NetworkResponse {
//    open fun getErrorMessage(exception: HttpException): String {
//        val errorString = exception.response()?.errorBody()?.string()
//        val errorDto: ErrorResponse? = Gson().fromJson<ErrorResponse>(
//            errorString, ErrorResponse::class.java
//        )
//        return errorDto?.message ?: "알 수 없는 오류가 발생했습니다"
//    }
//
//    suspend fun <T> handle(call: suspend () -> T): T? {
//        return withContext(CoroutineScope(coroutineContext).coroutineContext) {
//            // suspend function
//            call.runCatching { this.invoke() } // 메소드 실행
//                .getOrElse {                   // 성공하면 리턴값을 가져오고 실패하면 onError에 Throwable을 던지고 null을 반환한다.
//                    onError(it)
//                    null
//                }
//        }
//    }
//
//    open fun onError(t: Throwable) {
//        viewModelScope.launch {
//            when (t) {
//                is HttpException -> // toast getErrorMessage(t)
//                else -> // 그 외 다른 에러 처리
//            }
//        }
//    }
//}