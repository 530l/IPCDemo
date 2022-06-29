package com.ipc.service

import android.content.ComponentName
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.ipc.ClientIPC
import com.ipc.ServiceIPC
import com.ipc.model.UserInfo
import com.ipc_service.R

class ServiceFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return LayoutInflater.from(requireContext())
            .inflate(R.layout.service_fragment, container, false)
    }

    private var aidl: ClientIPC? = null

    private val connect = object : ServiceConnection {
        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            //绑定服务成功回调
            aidl = ClientIPC.Stub.asInterface(service);
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
            "com.ipc.client.CCService"
        )
        requireActivity().bindService(intent, connect, AppCompatActivity.BIND_AUTO_CREATE)


        view.findViewById<TextView>(R.id.service_tv).apply {
            setOnClickListener {
                var uuid = UserInfo().apply {
                    name = "allens"
                    index = 1111
                }
                val u = aidl!!.sayClient(uuid)
                Log.i("53053050", u.toString())

            }
        }
    }

}