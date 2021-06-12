package hn.edu.ujcv.pmd_2021_ii_p1_proyecto1.Clases

import android.os.Parcel
import android.os.Parcelable

class Alumnos() : Parcelable {
    var NumeroCuenta :Int = 0
    var Nombre       :String = ""
    var Carrera      :String = ""
    var FechaIngreso :String = ""
    var Correo       :String = ""


     constructor(parcel: Parcel): this(){
         NumeroCuenta = parcel.readInt()
         Nombre       = parcel.readString().toString()
         Carrera      = parcel.readString().toString()
         FechaIngreso = parcel.readString().toString()
         Correo       = parcel.readString().toString()
     }

    constructor(numeroCuenta : Int, nombre : String, carrera : String, fechaIngreso: String, correo: String) : this() {
    }


    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(NumeroCuenta)
        parcel.writeString(Nombre)
        parcel.writeString(Carrera)
        parcel.writeString(FechaIngreso)
        parcel.writeString(Correo)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Alumnos> {
        override fun createFromParcel(parcel: Parcel): Alumnos {
            return Alumnos(parcel)
        }

        override fun newArray(size: Int): Array<Alumnos?> {
            return arrayOfNulls(size)
        }
    }
}