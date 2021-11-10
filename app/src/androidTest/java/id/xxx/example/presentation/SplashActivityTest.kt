package id.xxx.example.presentation

import androidx.test.espresso.Espresso
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import id.xxx.example.utils.espresso.EspressoIdlingResource
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class SplashActivityTest {

    @get:Rule
    var rule = ActivityScenarioRule(SplashActivity::class.java)

    @Before
    fun setUp() {
        IdlingRegistry.getInstance().register(EspressoIdlingResource.idlingResource)
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.idlingResource)
    }

    @Test
    fun launch_splash_activity_test() {
        Espresso.onView(ViewMatchers.withResourceName("content"))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }
}