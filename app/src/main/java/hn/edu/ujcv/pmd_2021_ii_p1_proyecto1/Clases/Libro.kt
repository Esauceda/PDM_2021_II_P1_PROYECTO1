package hn.edu.ujcv.pmd_2021_ii_p1_proyecto1.Clases

import android.os.Parcel
import android.os.Parcelable

class Libro() : Parcelable {
    var numeroDeLibro      = 0
    var nombreDeLibro      = ""
    var autor              = ""
    var editorial          = ""
    var fechaDePublicacion = ""

    constructor(parcel: Parcel) : this() {
        numeroDeLibro = parcel.readInt()
        nombreDeLibro = parcel.readString().toString()
        autor = parcel.readString().toString()
        editorial = parcel.readString().toString()
        fechaDePublicacion = parcel.readString().toString()
    }


    constructor(numeroDeLibro: String, autor: String, fechaDePublicacion: String, editorial: String) : this() {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(numeroDeLibro)
        parcel.writeString(nombreDeLibro)
        parcel.writeString(autor)
        parcel.writeString(editorial)
        parcel.writeString(fechaDePublicacion)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Libro> {
        override fun createFromParcel(parcel: Parcel): Libro {
            return Libro(parcel)
        }

        override fun newArray(size: Int): Array<Libro?> {
            return arrayOfNulls(size)
        }
    }

}