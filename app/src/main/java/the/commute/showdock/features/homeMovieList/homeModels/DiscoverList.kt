package the.commute.showdock.features.homeMovieList.homeModels


import com.google.gson.annotations.SerializedName

data class DiscoverList(
    @SerializedName("page")
    val page: Int? = 0,
    @SerializedName("results")
    val results: List<Result>,
    @SerializedName("total_pages")
    val totalPages: Int? = 0,
    @SerializedName("total_results")
    val totalResults: Int? = 0
)