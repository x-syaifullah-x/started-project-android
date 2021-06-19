package id.xxx.example

import android.app.Application
import android.content.Context
import android.util.Log
import id.xxx.example.jni.on.load.Example

class App : Application() {

    override fun attachBaseContext(context: Context) {
        super.attachBaseContext(context)

        Log.i("NATIVE_TEST", Example.test())
        Log.i("NATIVE_GET_API_KEY", Example.getApiKey())

//        System.loadLibrary(BuildConfig.LIB_NAME_NORMAL)
        Log.i("NATIVE_TEST", test())
    }

    private external fun test(): String
}