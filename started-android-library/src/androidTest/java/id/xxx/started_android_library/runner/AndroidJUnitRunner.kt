package id.xxx.started_android_library.runner

import android.app.Application
import android.content.Context
import androidx.test.runner.AndroidJUnitRunner
import id.xxx.started_android_library.App

class AndroidJUnitRunner : AndroidJUnitRunner() {
    override fun newApplication(
        cl: ClassLoader?, className: String?, context: Context?
    ): Application {
        return super.newApplication(cl, App::class.java.name, context)
    }
}