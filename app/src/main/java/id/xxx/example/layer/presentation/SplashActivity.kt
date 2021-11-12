package id.xxx.example.layer.presentation

import android.animation.ObjectAnimator
import android.app.Activity
import android.content.Intent
import android.graphics.drawable.LayerDrawable
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.WindowInsets
import android.view.WindowInsetsController
import android.view.WindowManager
import id.xxx.example.R
import id.xxx.example.layer.presentation.home.MainActivity
import id.xxx.example.espresso.EspressoIdlingResource

class SplashActivity : Activity() {

    private val handler = Handler(Looper.getMainLooper())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val drawable = (window.decorView.background as LayerDrawable)
            .findDrawableByLayerId(R.id.splash_logo)

        val anim = ObjectAnimator.ofInt(
            drawable, "level", 0, 3000
        )

        if (drawable.alpha == 0) drawable.alpha = 255
        anim.repeatCount = ObjectAnimator.INFINITE
        anim.start()

        EspressoIdlingResource.increment()
        handler.postDelayed({
            drawable.alpha = 0
            finish()
            startActivity(Intent(this, MainActivity::class.java))
            EspressoIdlingResource.decrement()
        }, 500)
    }

    override fun onBackPressed() {
        handler.removeCallbacksAndMessages(null)
        finishAfterTransition()
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        if (hasFocus)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                window.insetsController?.let {
                    it.systemBarsBehavior =
                        WindowInsetsController.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
                    it.hide(WindowInsets.Type.systemBars())
                }
            } else {
                @Suppress("DEPRECATION")
                window.decorView.systemUiVisibility = (
                        View.SYSTEM_UI_FLAG_IMMERSIVE
                                or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                                or View.SYSTEM_UI_FLAG_FULLSCREEN
                                or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                                or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN)
                @Suppress("DEPRECATION")
                window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION)
            }
    }
}