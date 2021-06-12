package hn.edu.ujcv.pmd_2021_ii_p1_proyecto1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import hn.edu.ujcv.pmd_2021_ii_p1_proyecto1.Clases.Libro
import kotlinx.android.synthetic.main.activity_registro_libro.*


class RegistroLibroActivity: AppCompatActivity() {
    var valores: HashMap<Int, Libro> = hashMapOf()

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro_libro)

        inicializar()
        btnGuardar.setOnClickListener{guardar()}
        btnRegresar.setOnClickListener{regresar()}
        btnEnviar.setOnClickListener{enviar()}
    }

    private fun regresar() {
        val intentnRegistroLibro = Intent(this, MainActivity::class.java)
        startActivity(intentnRegistroLibro)
    }
    //-----
    private fun enviar(){
        val intent = Intent(this, BuscarLibroActivity::class.java)
        intent.putExtra("valores", valores)
        startActivity(intent)
    }
    //-----
    private fun guardar(){
        val dato: Libro = Libro()
        dato.numeroDeLibro       = txtNumeroDeLibro.text.toString().toInt()
        dato.nombreDeLibro       = txtNombreDeLibro.text.toString()
        dato.autor               = txtAutor.text.toString()
        dato.editorial           = txtEditorial.text.toString()
        dato.fechaDePublicacion  = txtFechaDePublicacion.text.toString()

        valores.put(dato.numeroDeLibro, dato)
        btnEnviar.isEnabled = true
    }
    //-----
    private fun inicializar() {
        btnEnviar.isEnabled = false
    }
}

