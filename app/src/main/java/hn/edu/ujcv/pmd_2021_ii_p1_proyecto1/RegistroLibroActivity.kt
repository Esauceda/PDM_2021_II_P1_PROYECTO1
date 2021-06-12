package hn.edu.ujcv.pmd_2021_ii_p1_proyecto1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.Toast
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

        if(txtNumeroDeLibro.text.isEmpty()){
            val toast = Toast.makeText(applicationContext, "El Numero de libro no puede estar vacio", Toast.LENGTH_LONG).show()
        }else if(txtNombreDeLibro.text.isEmpty()){
            val toast = Toast.makeText(applicationContext, "Este Nombre de libro no puede estar vacio", Toast.LENGTH_LONG).show()
        }else if (txtAutor.text.isEmpty()){
            val toast = Toast.makeText(applicationContext, "Este Autor de libro está vacio", Toast.LENGTH_LONG).show()
        }else if(txtEditorial.text.isEmpty()){
            val toast = Toast.makeText(applicationContext, "Este Editorial de libro está vacio", Toast.LENGTH_LONG).show()
        }else if(txtFechaDePublicacion.text.isEmpty()){
            val toast = Toast.makeText(applicationContext, "La fecha de publicacion de libro está vacio", Toast.LENGTH_LONG).show()
        }else{
            dato.numeroDeLibro       = txtNumeroDeLibro.text.toString().toInt()
            dato.nombreDeLibro       = txtNombreDeLibro.text.toString()
            dato.autor               = txtAutor.text.toString()
            dato.editorial           = txtEditorial.text.toString()
            dato.fechaDePublicacion  = txtFechaDePublicacion.text.toString()

            valores.put(dato.numeroDeLibro, dato)
            btnEnviar.isEnabled = true

            val toast = Toast.makeText(applicationContext, "Libro Regisrado Correctamente", Toast.LENGTH_SHORT).show()
        }


    }
    //-----
    private fun inicializar() {
        btnEnviar.isEnabled = false
    }
}

