package com.codeonwheels.loginapp.domain.usecase

import com.codeonwheels.loginapp.data.repository.SaltRepository
import com.codeonwheels.loginapp.domain.model.SaltUserModel
import com.codeonwheels.loginapp.util.Resource
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class LoginUseCase @Inject constructor(

    private val repository: SaltRepository

) {

    operator fun invoke(
        email: String,
        password: String
    ): Flow<Resource<SaltUserModel>> = flow {

        try {

            emit(Resource.Loading())

            val process = repository.userLogin(email, password)

            coroutineScope {

                emit(Resource.Success(process))

            }

        } catch (e: HttpException) {

            emit(Resource.Error(e.localizedMessage ?: "Beklenmedik bir hata oluştu!"))

        }
    }
}