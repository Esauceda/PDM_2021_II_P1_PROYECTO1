package hn.edu.ujcv.pmd_2021_ii_p1_proyecto1

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CalendarView
import android.widget.Toast
import hn.edu.ujcv.pmd_2021_ii_p1_proyecto1.Clases.Prestamo
import kotlinx.android.synthetic.main.activity_guardar.*
import kotlinx.android.synthetic.main.activity_registro_prestamo.*
import kotlinx.android.synthetic.main.activity_registro_prestamo.btnEnviar
import kotlinx.android.synthetic.main.activity_registro_prestamo.btnGuardar
import kotlinx.android.synthetic.main.activity_registro_prestamo.btnRegresar
import java.util.*
import kotlin.collections.HashMap

class RegistroPrestamoActivity : AppCompatActivity() {
    var valores: HashMap<Int, Prestamo> = hashMapOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro_prestamo)
        inicializar()
        btnGuardar.setOnClickListener { guardar() }
        btnRegresar.setOnClickListener { regresar() }
        btnEnviar.setOnClickListener { enviar() }
        btnCalendario.setOnClickListener { calendario() }
    }

    private fun calendario() {
        val c = Calendar.getInstance()
        val date = Date()

        var año = c.get(Calendar.YEAR)
        var mes = c.get(Calendar.MONTH)
        var dia = c.get(Calendar.DAY_OF_MONTH)

        val dpd = DatePickerDialog(this, { view, Año, Mes, Dia ->
            txtFechaPrestamo.setText(""+Dia+"/"+Mes+"/"+Año)
            c.set(Año,Mes,(Dia+3))
            dia = c.get(Calendar.DAY_OF_MONTH)
            var año = c.get(Calendar.YEAR)
            var mes = c.get(Calendar.MONTH) + 1
            txtFechaDevolucion.setText(""+dia+"/"+(mes-1)+"/"+año)
        },año,mes,dia)
        dpd.show()
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
        if (txtNumeroCuenta.text.isEmpty()) {
            val toast = Toast.makeText(
                applicationContext,
                "El Numero de Cuenta no puede estar vacio",
                Toast.LENGTH_LONG
            ).show()
        } else if (txtNumeroLibro.text.isEmpty()) {
            val toast = android.widget.Toast.makeText(
                applicationContext,
                "El Numero de libro no puede estar vacio",
                android.widget.Toast.LENGTH_LONG
            ).show()
        } else if (txtNumeroPrestamo.text.isEmpty()) {
            val toast = Toast.makeText(
                applicationContext,
                "El Numero de Prestamo no puede estar vacio",
                Toast.LENGTH_LONG
            ).show()
        } else if (txtFechaPrestamo.text.isEmpty()) {
            val toast = Toast.makeText(
                applicationContext,
                "La Fecha de Prestamo no puede estar vacio",
                Toast.LENGTH_LONG
            ).show()
        } else if (txtFechaDevolucion.text.isEmpty()) {
            val toast = Toast.makeText(
                applicationContext,
                "La Fecha de Devolucion no puede estar vacio",
                Toast.LENGTH_LONG
            ).show()
        } else {
            val dato: Prestamo = Prestamo()
            dato.numeroCuenta = txtNumeroCuenta.text.toString().toInt()
            dato.numeroPrestamo = txtNumeroPrestamo.text.toString()
            dato.numeroLibro = txtNumeroLibro.text.toString()
            dato.fechaEntrega = txtFechaPrestamo.text.toString()
            dato.fechaDevolucion = txtFechaDevolucion.text.toString()
            valores.put(dato.numeroCuenta, dato)
            btnEnviar.isEnabled = true
        }
    }
        private fun inicializar() {
            btnEnviar.isEnabled = false
        }
    }