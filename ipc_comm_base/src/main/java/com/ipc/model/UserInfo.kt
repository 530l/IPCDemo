package com.ipc.model

import android.os.Parcel
import android.os.Parcelable

class UserInfo() : Parcelable {
    var name: String? = null
    var index: Int = 0

    companion object CREATOR : Parcelable.Creator<UserInfo> {
        override fun createFromParcel(parcel: Parcel): UserInfo {
            return UserInfo(parcel)
        }

        override fun newArray(size: Int): Array<UserInfo> {
            return Array(size) { UserInfo() }
        }
    }

    public constructor(inParcel: Parcel) : this() {
        readFromParcel(inParcel)
    }

    override fun writeToParcel(outParcel: Parcel, flags: Int) {
        outParcel.writeString(name)
        outParcel.writeInt(index)
    }

    public fun readFromParcel(inParcel: Parcel) {
        name = inParcel.readString()
        index = inParcel.readInt()
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun toString(): String {
        return "UserInfo(name=$name, index=$index)"
    }

}