package the.commute.showdock.features.auth.login.loginModels


import com.google.gson.annotations.SerializedName

data class LoginModel(
    @SerializedName("expires_at")
    val expiresAt: String? ="",
    @SerializedName("request_token")
    val requestToken: String? = "",
    @SerializedName("success")
    val success: Boolean? = false
)