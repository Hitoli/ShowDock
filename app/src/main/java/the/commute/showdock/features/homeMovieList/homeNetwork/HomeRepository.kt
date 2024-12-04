package the.commute.showdock.features.homeMovieList.homeNetwork

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.http.GET
import the.commute.showdock.features.homeMovieList.homeModels.DiscoverList
import the.commute.showdock.features.homeMovieList.homeUtility.HomeAPIConstants
import the.commute.showdock.utility.DispatcherHelper
import the.commute.showdock.utility.NetworkLogger
import javax.inject.Inject

class HomeRepository @Inject constructor(
    private val retrofit: Retrofit,
    @DispatcherHelper.IODISPATCHER private val ioDispatcher: CoroutineDispatcher
):HomeAPICalls {
    private val networkService = retrofit.create(HomeMovieListInterface::class.java)

    override suspend fun getMoviesList(): Result<DiscoverList> {
        return withContext(context = ioDispatcher){
            try {
                val response = networkService.getMoviesList()
                Result.success(response)
            }catch (e:Exception){
                NetworkLogger.logger(value = e.message?:"EXCEPTION OCCURRED", fileName = "HomeRepo")
                Result.failure(e)
            }
        }

    }
}

private interface HomeMovieListInterface {

    @GET(HomeAPIConstants.moviesListURL)
    suspend fun getMoviesList():DiscoverList

}