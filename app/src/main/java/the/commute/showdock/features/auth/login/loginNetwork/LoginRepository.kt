package the.commute.showdock.features.auth.login.loginNetwork

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.http.GET
import the.commute.showdock.features.auth.login.loginModels.LoginModel
import the.commute.showdock.features.auth.login.loginUtility.LoginAPIConstants
import the.commute.showdock.utility.DispatcherHelper
import the.commute.showdock.utility.NetworkLogger
import javax.inject.Inject

class LoginRepository @Inject constructor(
    private val retrofit: Retrofit,
    @DispatcherHelper.IODISPATCHER private val ioDispatcher: CoroutineDispatcher
):LoginAPICalls {
    private val networkService = retrofit.create(LoginInterface::class.java)

    override suspend fun login(): Result<LoginModel> {
        TODO("Not yet implemented")
    }

    override suspend fun requestToken(): Result<LoginModel> {
        return withContext(ioDispatcher){
            try {
                val response = networkService.requestToken()
                NetworkLogger.logger(value = response.requestToken.toString(), fileName = "LoginRepo")
                Result.success(response)
            }catch (e:Exception){
                NetworkLogger.logger(value = e.message?:"EXCEPTION OCCURRED", fileName = "LoginRepo")
                Result.failure(e)
            }
        }
    }
}

private interface LoginInterface{
    @GET(LoginAPIConstants.temporaryRequestTokenURL)
    suspend fun requestToken():LoginModel
}