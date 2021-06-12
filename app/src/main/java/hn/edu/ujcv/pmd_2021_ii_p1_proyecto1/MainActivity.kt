package hn.edu.ujcv.pmd_2021_ii_p1_proyecto1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnAlumnos.setOnClickListener { alumnos() }
        btnLibros.setOnClickListener { libros() }
        btnPrestamos.setOnClickListener { prestamos() }
    }

    private fun alumnos() {
        val intent = Intent(this,RegistroAlumnoActivity::class.java)
        startActivity(intent)
    }
    private fun libros() {
        val intent = Intent(this,RegistroLibroActivity::class.java)
        startActivity(intent)
    }
    private fun prestamos() {
        val intent = Intent(this,RegistroPrestamoActivity::class.java)
        startActivity(intent)
    }
}