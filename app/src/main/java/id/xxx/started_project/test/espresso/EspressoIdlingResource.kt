@file:JvmName("EspressoIdlingResource")

package id.xxx.started_project.test.espresso

import androidx.test.espresso.idling.CountingIdlingResource
import id.xxx.started_project.layer.presentation.constant.AppBuild

object EspressoIdlingResource {

    private const val RESOURCE = "GLOBAL"

    val idlingResource by lazy { CountingIdlingResource(RESOURCE) }

    @JvmStatic
    fun increment() {
        if (AppBuild.IS_DEBUG)
            idlingResource.increment()
    }

    @JvmStatic
    fun decrement() {
        if (AppBuild.IS_DEBUG)
            idlingResource.decrement()
    }
}