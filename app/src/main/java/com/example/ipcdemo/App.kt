package com.example.ipcdemo

import android.app.Application
import androidx.core.content.PermissionChecker
import com.hjq.toast.ToastUtils

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        ToastUtils.init(this)

    }
}