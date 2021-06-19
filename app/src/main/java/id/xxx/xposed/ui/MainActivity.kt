package id.xxx.xposed.ui

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import id.xxx.xposed.module.R
import id.xxx.xposed.module.databinding.ActivityMainBinding


class MainActivity : Activity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(LayoutInflater.from(this))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}