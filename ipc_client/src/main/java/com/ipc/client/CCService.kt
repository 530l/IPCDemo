package com.ipc.client

import android.app.Service
import android.content.Intent
import android.os.IBinder
import com.ipc.ClientIPC
import com.ipc.model.UserInfo

class CCService : Service() {

    //实现binder，aidl自动生成 ，定义
    class CCBinder : ClientIPC.Stub() {
        override fun sayClient(userinfo: UserInfo): UserInfo {
            //这些方法就是提供给客户端使用的
            userinfo.name = "我是客户端"
            return userinfo
        }
    }

    private var mCCBinder: CCBinder? = null


    override fun onBind(intent: Intent?): IBinder? {
        //返回给系统
        return mCCBinder!!
    }

    override fun onCreate() {
        super.onCreate()
        //创建。
        mCCBinder = CCBinder()

    }
}