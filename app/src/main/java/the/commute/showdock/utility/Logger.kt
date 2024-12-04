package the.commute.showdock.utility

import timber.log.Timber

class Logger {
    companion object{
        fun logIT(value:String, fileName:String){
            Timber.tag("VAlUE OCCURED AT " + fileName).d(value)
        }
    }
}