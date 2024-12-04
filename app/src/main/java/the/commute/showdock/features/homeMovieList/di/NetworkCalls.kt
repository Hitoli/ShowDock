package the.commute.showdock.features.homeMovieList.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import the.commute.showdock.features.homeMovieList.homeNetwork.HomeAPICalls
import the.commute.showdock.features.homeMovieList.homeNetwork.HomeRepository
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class NetworkCalls {

    @Binds
    @Singleton
    abstract fun bindingHomeRepoInterface(homeRepository: HomeRepository):HomeAPICalls
}