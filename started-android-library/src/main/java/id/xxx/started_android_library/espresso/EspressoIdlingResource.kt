@file:JvmName("EspressoIdlingResource")

package id.xxx.started_android_library.espresso

import androidx.test.espresso.idling.CountingIdlingResource
import id.xxx.started_android_library.BuildConfig

object EspressoIdlingResource {

    private const val RESOURCE = "GLOBAL"

    private const val IS_DEBUG = BuildConfig.BUILD_TYPE == "debug"

    val idlingResource by lazy { CountingIdlingResource(RESOURCE) }

    @JvmStatic
    fun increment() {
        if (IS_DEBUG) idlingResource.increment()
    }

    @JvmStatic
    fun decrement() {
        if (IS_DEBUG) idlingResource.decrement()
    }
}