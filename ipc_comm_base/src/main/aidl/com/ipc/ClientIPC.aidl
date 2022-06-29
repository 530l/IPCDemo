// ClientIPC.aidl
//客户端包下面的ClientIPC文件是提供给服务端使用的。
//客户端包下面的ServiceIPC文件是服务端提供给客户端使用的

package com.ipc;
import com.ipc.model.UserInfo;

interface ClientIPC {

    UserInfo sayClient(inout UserInfo userinfo);
}