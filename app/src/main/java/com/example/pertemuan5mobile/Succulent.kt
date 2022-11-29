package com.example.pertemuan5mobile

import android.os.Parcel
import android.os.Parcelable

class Succulent() : Parcelable {
    var name: String =""
    var common_name: String =""
    var detail: String =""
    var picture: Int = 0
    var sun: String =""
    var water: String =""
    var grow: String =""
    var temp: String =""
    var propagation: String =""
    var toxic: String =""
    var dormant: String =""

    constructor(parcel: Parcel) : this() {
        name = parcel.readString()?:""
        common_name = parcel.readString()?:""
        detail = parcel.readString()?:""
        picture = parcel.readInt()
        sun = parcel.readString()?:""
        water = parcel.readString()?:""
        grow = parcel.readString()?:""
        temp = parcel.readString()?:""
        propagation = parcel.readString()?:""
        toxic = parcel.readString()?:""
        dormant = parcel.readString()?:""
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(common_name)
        parcel.writeString(detail)
        parcel.writeInt(picture)
        parcel.writeString(sun)
        parcel.writeString(water)
        parcel.writeString(grow)
        parcel.writeString(temp)
        parcel.writeString(propagation)
        parcel.writeString(toxic)
        parcel.writeString(dormant)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Succulent> {
        override fun createFromParcel(parcel: Parcel): Succulent {
            return Succulent(parcel)
        }

        override fun newArray(size: Int): Array<Succulent?> {
            return arrayOfNulls(size)
        }
    }
}
