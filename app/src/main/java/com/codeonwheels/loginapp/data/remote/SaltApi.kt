package com.codeonwheels.loginapp.data.remote

import com.codeonwheels.loginapp.domain.model.SaltUserModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

interface SaltApi {
    @GET("/api/login")
    suspend fun login(
        @Query("email") email: String,
        @Query("password") password: String,
    ): Response<SaltUserModel>
}