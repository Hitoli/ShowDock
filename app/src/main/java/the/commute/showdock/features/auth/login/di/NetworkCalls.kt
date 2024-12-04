package the.commute.showdock.features.auth.login.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import the.commute.showdock.features.auth.login.loginNetwork.LoginAPICalls
import the.commute.showdock.features.auth.login.loginNetwork.LoginRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class NetworkCalls {

    @Binds
    @Singleton
    abstract fun bindLoginRepoInterface(loginRepository: LoginRepository):LoginAPICalls
}