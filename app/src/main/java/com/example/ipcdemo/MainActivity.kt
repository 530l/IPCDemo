//package com.example.ipcdemo
//
//import android.content.ComponentName
//import android.content.Intent
//import android.content.ServiceConnection
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import android.os.IBinder
//import android.util.Log
//import android.view.View
//
//class MainActivity : AppCompatActivity() {
//
//    //https://juejin.cn/post/6906686898279088141
//
//    private var aidl: ITest? = null
//    private val connect = object : ServiceConnection {
//        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
//            //绑定服务成功回调
//            aidl = ITest.Stub.asInterface(service);
//        }
//
//        override fun onServiceDisconnected(name: ComponentName?) {
//            aidl = null
//        }
//    }
//
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//        //todo 客户端
//        //参数1 服务端的appid,
//        //参数2 服务端需要绑定服务的完整路劲
//        //在 bindService第二个参数中,我们需要传入连接的接口,
//        // 在连接成功以后，需要通过 生成的Stub对象的asInterface将返回的参数转换成 YourServiceInterface 类型，
//        // 这里的示例是转成 ITest 类型
//        val intent = Intent()
//        intent.component =
//            ComponentName(
//                "com.example.ipcdemo",
//                "com.example.ipcdemo.service.RemoteService"
//            )
//        bindService(intent, connect, BIND_AUTO_CREATE)
//    }
//
//    ///TODO 客户端
//    fun send(view: View) {
//        //传基本的参数
////        val data =  aidl?.add("加法计算", 10, 20)
////        Log.i("530530530","调用service的方法${data}")
//
//        //传对象、
//        var bookInOut = BookInfo().apply {
//            name = "allens"
//            index = 111
//        }
//        val updateBookInOut = aidl?.updateBookInOut(bookInOut)
//        Log.i("530530530", "调用service的方法${updateBookInOut.toString()}")
//        //
//
//
//    }
//}