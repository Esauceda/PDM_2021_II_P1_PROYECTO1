package hn.edu.ujcv.pmd_2021_ii_p1_proyecto1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import hn.edu.ujcv.pmd_2021_ii_p1_proyecto1.Clases.Prestamo
import kotlinx.android.synthetic.main.activity_registro_prestamo.*

class RegistroPrestamoActivity : AppCompatActivity() {
    var valores: HashMap<Int, Prestamo> = hashMapOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro_prestamo)
        inicializar()
        btnGuardar.setOnClickListener{guardar()}
        btnRegresar.setOnClickListener{regresar()}
        btnEnviar.setOnClickListener{enviar()}
    }

    private fun regresar() {
        val intentnRegistroPrestamo = Intent(this, MainActivity::class.java)
        startActivity(intentnRegistroPrestamo)
    }

    private fun enviar() {
        val intent = Intent(this, BuscarPrestamoActivity::class.java)
        intent.putExtra("valores", valores)

        startActivity(intent)
    }

    private fun guardar() {
        val dato: Prestamo = Prestamo()
        var dia = txtDia.text.toString().toInt()
        var mes = txtMes.text.toString().toInt()
        var anio = txtAño.text.toString().toInt()
        dato.numeroCuenta     = txtNumeroCuenta.text.toString().toInt()
        dato.numeroPrestamo   = txtNumeroPrestamo.text.toString()
        dato.numeroLibro      = txtNumeroLibro.text.toString()
        dato.fechaEntrega     = "$dia/$mes/$anio"

        dia = dia + 3
        if(dia > 30){
            dia = dia - 30
            mes++
        }
        if (mes > 12){
            mes = mes - 12
            anio++
        }

        dato.fechaDevolucion  = "${dia}/$mes/$anio"
        valores.put(dato.numeroCuenta, dato)
        btnEnviar.isEnabled = true
    }

    private fun inicializar() {
        btnEnviar.isEnabled = false
    }
}