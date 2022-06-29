package com.ipc.service

import android.app.Service
import android.content.Intent
import android.os.IBinder
import com.ipc.ServiceIPC
import com.ipc.model.UserInfo

class SService : Service() {

    //实现binder，aidl自动生成 ，定义
    class SSBinder : ServiceIPC.Stub() {

        override fun sayService(userinfo: UserInfo): UserInfo {
            //这些方法就是提供给客户端使用的
            userinfo.name = "我是服务端"
            return userinfo
        }
    }

    private var mSSBinder: SSBinder? = null


    override fun onBind(intent: Intent?): IBinder? {
        //返回给系统
        return mSSBinder!!
    }

    override fun onCreate() {
        super.onCreate()
        //创建。
        mSSBinder = SSBinder()

    }
}