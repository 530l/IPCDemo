package com.ipc.client

import android.content.ComponentName
import android.content.Intent
import android.content.ServiceConnection
import android.os.*
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.ipc.ServiceIPC
import com.ipc.model.UserInfo
import com.ipc_client.R
import java.util.concurrent.CountDownLatch

class ClientFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return LayoutInflater.from(requireContext())
            .inflate(R.layout.client_fragment, container, false)
    }

    private var aidl: ServiceIPC? = null
    private val connect = object : ServiceConnection {
        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            //绑定服务成功回调
            aidl = ServiceIPC.Stub.asInterface(service);
        }

        override fun onServiceDisconnected(name: ComponentName?) {
            aidl = null
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val intent = Intent()
        intent.component = ComponentName(
            "com.example.ipcdemo",
            "com.ipc.service.SService"
        )

        requireActivity().bindService(intent, connect, AppCompatActivity.BIND_AUTO_CREATE)

        view.findViewById<TextView>(R.id.client_tv).apply {
            setOnClickListener {
                var uuid = UserInfo().apply {
                    name = "allens"
                    index = 1111
                }
                val u = aidl!!.sayService(uuid)
                Log.i("53053050", u.toString())
            }
        }

        view.findViewById<TextView>(R.id.client_tv).setOnClickListener {
            Thread {
                val i = testLoad()
                val msg = Message.obtain()
                msg.arg1 = i
                msg.what = 1
                handle.sendMessage(msg)
            }.start()
        }
    }

    private val handle = object : Handler(Looper.getMainLooper()) {
        override fun handleMessage(msg: Message) {
            super.handleMessage(msg)
            view?.findViewById<TextView>(R.id.client_tv)?.text = msg.arg1.toString()

        }
    }

    //todo 是会阻塞主线程，超过一定时间就会无响应。短时间还可以
    private fun testLoad(): Int {
        val countDownLatch = CountDownLatch(2)
        var age = 0
        var age2 = 0
        Thread {
            Thread.sleep(500)
            age2 = 1
            countDownLatch.countDown()
        }.start()
        Thread {
            Thread.sleep(300)
            age = 2
            countDownLatch.countDown()
        }.start()
        countDownLatch.await()
        return age + age2
    }

}