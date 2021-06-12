package hn.edu.ujcv.pmd_2021_ii_p1_proyecto1.Clases

import android.os.Parcel
import android.os.Parcelable


class Prestamo() : Parcelable {
    var numeroCuenta    : Int = 0
    var numeroPrestamo  : String = ""
    var numeroLibro     : String = ""
    var fechaEntrega    : String = ""
    var fechaDevolucion : String = ""

    constructor(parcel: Parcel) : this() {
        numeroCuenta    = parcel.readInt()
        numeroPrestamo  = parcel.readString().toString()
        numeroLibro     = parcel.readString().toString()
        fechaEntrega    = parcel.readString().toString()
        fechaDevolucion = parcel.readString().toString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(numeroCuenta)
        parcel.writeString(numeroPrestamo)
        parcel.writeString(numeroLibro)
        parcel.writeString(fechaEntrega)
        parcel.writeString(fechaDevolucion)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Prestamo> {
        override fun createFromParcel(parcel: Parcel): Prestamo {
            return Prestamo(parcel)
        }

        override fun newArray(size: Int): Array<Prestamo?> {
            return arrayOfNulls(size)
        }
    }
}