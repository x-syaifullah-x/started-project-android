package id.xxx.example.espresso

import androidx.test.espresso.idling.CountingIdlingResource
import id.xxx.example.constant.AppBuild

object EspressoIdlingResource {

    private const val RESOURCE = "GLOBAL"

    val idlingResource by lazy { CountingIdlingResource(RESOURCE) }

    fun increment() {
        if (AppBuild.IS_DEBUG)
            idlingResource.increment()
    }

    fun decrement() {
        if (AppBuild.IS_DEBUG)
            idlingResource.decrement()
    }
}