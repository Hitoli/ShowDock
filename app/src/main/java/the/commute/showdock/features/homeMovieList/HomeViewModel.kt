package the.commute.showdock.features.homeMovieList

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import the.commute.showdock.features.homeMovieList.homeModels.DiscoverList
import the.commute.showdock.features.homeMovieList.homeNetwork.HomeAPICalls
import the.commute.showdock.features.homeMovieList.homeNetwork.HomeRepository
import the.commute.showdock.utility.Logger
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val homeRepo:HomeAPICalls
) : ViewModel() {

    private val _movieDiscoverList: MutableStateFlow<DiscoverList> =
        MutableStateFlow(DiscoverList(results = emptyList()))
    val movieDiscoverList: StateFlow<DiscoverList> get() = _movieDiscoverList

    init {
        Log.e("VIEWMODEL HOME ", "HOME")
        Timber.e("VIEWMODEL HOME","homeViewmodel")
//        getMovieList()
    }

    fun getMovieList() {
        viewModelScope.launch {
            val response = homeRepo.getMoviesList()
            Logger.logIT(response.toString(), "VIEWMODEL HOME")
            Log.e("VIEWMODEL HOME ", response.toString())

            if (response.isSuccess) {
                _movieDiscoverList.emit(response.getOrDefault(DiscoverList(results = emptyList())))
            } else {
                Timber.e("EXCEPTION OCCURRED ${response.exceptionOrNull()}")
            }
        }
    }
}