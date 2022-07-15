package com.example.ipcdemo

import android.os.Build
import android.os.Bundle
import android.util.ArrayMap
import android.util.Log
import android.util.SparseArray
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import java.util.concurrent.CountDownLatch

class IPCActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.R)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ipc)

    }


}