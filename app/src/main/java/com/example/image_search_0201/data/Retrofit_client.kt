package com.example.image_search_0201.data

import com.example.image_search_0201.Constants
import com.example.image_search_0201.data.api.Retrofit_interface
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Retrofit_client {

    // API 서비스 객체를 반환
    val apiService: Retrofit_interface
        get() = instance.create(Retrofit_interface::class.java)

    // Retrofit 인스턴스를 초기화하고 반환한다.
    private val instance: Retrofit
        private get() {
            // Gson 객체 생성. setLenient()는 JSON 파싱이 좀 더 유연하게 처리되도록 한다.
            val gson = GsonBuilder().setLenient().create()

            // Retrofit 빌더를 사용하여 Retrofit 인스턴스 생성
            return Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)  // 기본 URL 설정
                .addConverterFactory(GsonConverterFactory.create(gson))  // JSON 파싱을 위한 컨버터 추가
                .build()
        }
}
