package com.codeonwheels.loginapp.presentation.state

import com.codeonwheels.loginapp.domain.model.SaltUserModel

data class LoginState(
    var isLoading : Boolean = false,
    var success : Int = -1,
    var loginList : List<SaltUserModel.Data> = emptyList(),
    var error : String = "",
    var internet : Boolean = false
)