package com.kanaegel.logos_app2.core

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

        // IMPORTANT: Replace with 10.0.2.2 for emulator or your PC's network IP for device
        private const val BASE_URL = "http://192.168.0.77:8080/"

        // Optional: Add logging interceptor for debugging network calls
        private val loggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY // Log request/response body
        }

        private val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor) // Add logging (optional)
            // Add other configurations like timeouts if needed
            .build()

        val instance: ApiService by lazy {
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient) // Use custom OkHttpClient (optional)
                .addConverterFactory(GsonConverterFactory.create()) // Use Gson converter
                .build()

            retrofit.create(ApiService::class.java)
        }
}