package com.moonpi.swiftnotes.kotlin.test

import android.os.Environment
import org.junit.BeforeClass
import java.io.File


//TODO (2.8 Unitily) some setUp
open class AbstractApplicationTest<T>(val app: T) {
    companion object {
        @BeforeClass
        @JvmStatic
        fun setUp() {
            val resDir = File(Environment.getExternalStorageDirectory().absolutePath + "/allure-results")
            if (resDir.exists()) {
                resDir.deleteRecursively()
            }
        }
    }
}