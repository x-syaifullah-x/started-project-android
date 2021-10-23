package id.xxx.example.utils.espresso

import androidx.test.espresso.idling.CountingIdlingResource
import id.xxx.example.utils.application.App

object EspressoIdlingResource {

    private const val RESOURCE = "GLOBAL"

    val idlingResource = CountingIdlingResource(RESOURCE)

    fun increment() {
        if (App.DEBUG) {
            idlingResource.increment()
        }
    }

    fun decrement() {
        if (App.DEBUG) {
            idlingResource.decrement()
        }
    }
}