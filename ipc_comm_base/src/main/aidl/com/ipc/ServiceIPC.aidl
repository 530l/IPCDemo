// ServiceIPC.aidl
package com.ipc;
import com.ipc.model.UserInfo;


interface ServiceIPC {

    UserInfo sayService(inout UserInfo userinfo);
}