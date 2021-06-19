package id.xxx.started_project

import android.app.Activity
import android.app.Application

open class App : Application() {

    private var isFirstLoadState: Boolean? = true

    fun checkIsFirstLoad(activity: Activity): Boolean {
//        val intent = packageManager.getLaunchIntentForPackage(packageName)
//        val isActivityMain = intent?.component?.className == activity::class.java.name
        if (isFirstLoadState == true) {
            isFirstLoadState = null
            return true
        }
        return false
    }
}