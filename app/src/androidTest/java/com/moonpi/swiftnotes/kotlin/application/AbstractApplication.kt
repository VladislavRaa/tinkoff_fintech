@file:JvmName("Devices")

package com.moonpi.swiftnotes.kotlin.application

import android.app.Activity
import android.support.test.InstrumentationRegistry
import android.support.test.rule.ActivityTestRule
import org.junit.Rule
import java.io.File

//TODO (2.7 Unitily) abstract page object
abstract class AbstractApplication<T : Activity>(val activity: Class<T>) {

    @get:Rule
    var activityRule: ActivityTestRule<T> = object : ActivityTestRule<T>(activity, false, false) {
        override fun beforeActivityLaunched() {
            super.beforeActivityLaunched()
            cleanUp()
        }
    }
    private fun cleanUp() {
        val dir = InstrumentationRegistry.getTargetContext().filesDir.parentFile
        if (dir.exists()) {
            val list = dir.list()
            for (el in list) {
                if (el != ("lib")) {
                    File(dir, el).deleteRecursively()
                }
            }
        }
    }
    open fun open() {
        activityRule.launchActivity(null)
    }
}

