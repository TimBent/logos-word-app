package com.kanaegel.logos_app2.core

import com.kanaegel.logos_app2.data.StrongsApiResponseData
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("api/v1/strongs-data-retriever/")
    suspend fun getApiResponse(): StrongsApiResponseData

    @GET("api/v1/items/{id}")
    suspend fun getItemById(@Path("id") itemId: String): StrongsApiResponseData
}