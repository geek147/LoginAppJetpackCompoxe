package com.codeonwheels.loginapp.data.repository

import com.codeonwheels.loginapp.domain.model.SaltUserModel

interface SaltRepositoryInterface {
    suspend fun userLogin(email: String, password : String) : SaltUserModel
}