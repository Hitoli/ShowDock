package the.commute.showdock.features.auth.login

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import the.commute.showdock.features.auth.login.loginModels.LoginModel
import the.commute.showdock.features.auth.login.loginNetwork.LoginAPICalls
import the.commute.showdock.features.auth.login.loginNetwork.LoginRepository
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginRepo: LoginAPICalls
):ViewModel() {



    init {
        Timber.d("LOGIN VIEWMODEL", "VIEWMODEL")
    }

    fun getTemporaryRequestToken(){
        viewModelScope.launch {
          val response = loginRepo.requestToken()
            if (response.isSuccess){
                Log.e("RESPONSE TEMPORARY TOKEN LOGIN VIEWMOODEL",
                    response.getOrDefault(LoginModel()).toString()
                )
            }else{
                Log.e("RESPONSE TEMPORARY TOKEN LOGIN VIEWMOODEL",
                    response.exceptionOrNull().toString()
                )

            }
        }
    }
}