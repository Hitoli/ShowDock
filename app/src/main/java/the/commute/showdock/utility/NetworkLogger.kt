package the.commute.showdock.utility

import timber.log.Timber

class NetworkLogger {
    companion object{
        fun logger(value:String, fileName:String){
            Timber.d("EXCEPTION OCCURED AT ${fileName}",value)
        }
    }
}