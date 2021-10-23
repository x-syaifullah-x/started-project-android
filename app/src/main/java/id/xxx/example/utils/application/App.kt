package id.xxx.example.utils.application

import id.xxx.example.BuildConfig

object App {
    const val DEBUG = BuildConfig.BUILD_TYPE == "debug"
    const val ID = BuildConfig.APPLICATION_ID
}