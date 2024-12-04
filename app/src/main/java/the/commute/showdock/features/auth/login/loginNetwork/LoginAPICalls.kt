package the.commute.showdock.features.auth.login.loginNetwork

import the.commute.showdock.features.auth.login.loginModels.LoginModel

interface LoginAPICalls {
    suspend fun login():Result<LoginModel>
    suspend fun requestToken():Result<LoginModel>
}