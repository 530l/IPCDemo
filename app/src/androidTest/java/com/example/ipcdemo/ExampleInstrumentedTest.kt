package com.example.ipcdemo

import android.util.Log
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

/**
 * Instrumented com.test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        val deviceNameLowercase = "gamesir-g4pro_g09"
        val deviceFullnameLowercase1 = "gamesir-g4pro"
        val deviceFullnameLowercase2 = "gamesir-g4"
        Log.i("tttt",deviceNameLowercase.contains(deviceFullnameLowercase1).toString())
        Log.i("tttt",deviceNameLowercase.contains(deviceFullnameLowercase2).toString())
    }
}