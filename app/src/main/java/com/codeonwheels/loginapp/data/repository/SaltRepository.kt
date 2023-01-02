package com.codeonwheels.loginapp.data.repository

import com.codeonwheels.loginapp.data.remote.SaltApi
import com.codeonwheels.loginapp.domain.model.SaltUserModel
import javax.inject.Inject

class SaltRepository @Inject constructor(

    private val api : SaltApi

) : SaltRepositoryInterface {

    override suspend fun userLogin(email: String, password: String): SaltUserModel {
        val result = api.login(email, password)
        return result.body()!!
    }
}