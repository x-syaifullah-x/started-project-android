package id.xxx.example.base

import androidx.test.espresso.IdlingRegistry
import androidx.test.platform.app.InstrumentationRegistry
import id.xxx.example.espresso.EspressoIdlingResource
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test

open class BaseInstrumentTest {

    @Suppress("MemberVisibilityCanBePrivate", "HasPlatformType")
    protected val appContext = InstrumentationRegistry.getInstrumentation().targetContext

    @Before
    open fun before() {
        IdlingRegistry.getInstance().register(EspressoIdlingResource.idlingResource)
    }

    @After
    open fun after() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.idlingResource)
    }

    @Test
    fun context_test() {
        Assert.assertNotNull(appContext)
    }
}