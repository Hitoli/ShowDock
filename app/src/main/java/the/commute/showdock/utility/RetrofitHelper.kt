package the.commute.showdock.utility

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitHelper {

    private const val BASE_URL = "https://api.themoviedb.org/"

    @Provides
    @Singleton
    fun provideRetrofit(converterFactory: GsonConverterFactory, okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(converterFactory)
            .client(okHttpClient)
            .build()
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
       return OkHttpClient.Builder().addInterceptor(AuthInterceptor(token = MyConstants.bearerToken))
            .build()
    }

    @Provides
    @Singleton
    fun provideConverter(): GsonConverterFactory {
        return GsonConverterFactory.create()
    }
}