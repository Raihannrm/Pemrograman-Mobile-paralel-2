package com.example.raihanuts

import android.os.Parcel
import android.os.Parcelable

data class Club(val imgeclub:Int, val nameclub: String?, val jlkclub: String?, val yearclub: String?, val homeclub: String?, val supclub: String?, val deskripclub: String?
)
    : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(imgeclub)
        parcel.writeString(nameclub)
        parcel.writeString(deskripclub)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Club> {
        override fun createFromParcel(parcel: Parcel): Club {
            return Club(parcel)
        }

        override fun newArray(size: Int): Array<Club?> {
            return arrayOfNulls(size)
        }
    }
}