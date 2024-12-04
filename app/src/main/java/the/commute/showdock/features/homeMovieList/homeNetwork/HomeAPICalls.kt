package the.commute.showdock.features.homeMovieList.homeNetwork

import the.commute.showdock.features.homeMovieList.homeModels.DiscoverList

interface HomeAPICalls {
    suspend fun getMoviesList():Result<DiscoverList>
}