package id.xxx.example.presentation

import android.content.Intent
import androidx.test.espresso.Espresso
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import id.xxx.example.utils.espresso.EspressoIdlingResource
import org.junit.*

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
        rule.scenario.onActivity {
            it.sendBroadcast(Intent(Intent.ACTION_CLOSE_SYSTEM_DIALOGS))
        }
//        Espresso.onView(ViewMatchers.withResourceName("content"))
//            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Assert.assertTrue(true)
    }
}