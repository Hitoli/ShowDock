package the.commute.showdock

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class ShowDockApplication:Application() {
    override fun onCreate() {
        super.onCreate()
        Timber.e("Application Class Started")
    }
}