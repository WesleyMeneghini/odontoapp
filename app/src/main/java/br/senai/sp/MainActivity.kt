package br.senai.sp

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import org.jetbrains.anko.doAsync

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonCadastrarDentista = findViewById<Button>(R.id.button_cadastrar_dentista)

        buttonCadastrarDentista.setOnClickListener {

            // Rodar em uma Treading paralela
            doAsync {
                // Criar um objeto dentista
                val dentista = Dentista()
                dentista.nome = "Leonardo"
                dentista.cro = "00-11-00-11"
                dentista.email = "leonardo@gmail.com"
                dentista.telefone = "(11) 98585-6464"

                val URL = "http://10.107.144.10:8080/odonto/dentistas"

                var json = HttpHelper.post(URL, dentista.toJson())

                val retorno = findViewById<TextView>(R.id.txt_ok)

                retorno.setText("ok")
            }
        }
    }
}
