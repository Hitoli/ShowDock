package the.commute.showdock.utility

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Qualifier

@Module
@InstallIn(SingletonComponent::class)
object DispatcherHelper {

    @Qualifier
    annotation class IODISPATCHER

    @Qualifier
    annotation class MAINDISPATCHER

    @Qualifier
    annotation class DEFAULTDISPATCHER


    @Provides
    @IODISPATCHER
    fun provideDispatcherIO():CoroutineDispatcher = Dispatchers.IO

    @Provides
    @MAINDISPATCHER
    fun provideDispatcherMain():CoroutineDispatcher = Dispatchers.Main

    @Provides
    @DEFAULTDISPATCHER
    fun provideDispatcherDefault():CoroutineDispatcher = Dispatchers.Default

}