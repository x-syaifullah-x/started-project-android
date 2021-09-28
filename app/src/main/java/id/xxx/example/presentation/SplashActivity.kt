package id.xxx.example.presentation

import android.app.Activity
import android.graphics.drawable.LayerDrawable
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowInsets
import android.view.WindowInsetsController
import android.view.WindowManager
import androidx.annotation.RequiresApi
import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Handler
import android.os.Looper
import id.xxx.example.R
import id.xxx.example.presentation.home.MainActivity

class SplashActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val drawable = (window.decorView.background as LayerDrawable)
            .findDrawableByLayerId(R.id.splash_logo)

        val anim = ObjectAnimator.ofInt(
            drawable, "level", 0, 3000
        )
        drawable.alpha = 100
        anim.repeatCount = ObjectAnimator.INFINITE
        anim.start()

        Handler(Looper.getMainLooper()).postDelayed({
            drawable.alpha = 0
            finish()
            startActivity(Intent(this, MainActivity::class.java))
        }, 4000)
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