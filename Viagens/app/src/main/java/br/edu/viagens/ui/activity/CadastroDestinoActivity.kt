package br.edu.viagens.ui.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.edu.viagens.R
import br.edu.viagens.dao.MockDestinoDao
import br.edu.viagens.model.Destino

class CadastroDestinoActivity : AppCompatActivity() {

    private val dao = MockDestinoDao()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_destino)

        val etNome = findViewById<EditText>(R.id.etNome)
        val etRegiao = findViewById<EditText>(R.id.etRegiao)
        val etUrl = findViewById<EditText>(R.id.etUrl)
        val btSalvar = findViewById<Button>(R.id.btSalvar)
        val tvVerLista = findViewById<TextView>(R.id.tvVerLista)

        btSalvar.setOnClickListener {
            val nome = etNome.text.toString()
            val regiao = etRegiao.text.toString()
            val url = etUrl.text.toString()

            if (nome.isNotBlank() && regiao.isNotBlank() && url.isNotBlank()) {
                val novoDestino = Destino(nome = nome, regiao = regiao, url = url)
                dao.inserir(novoDestino)
                Toast.makeText(this, "Destino salvo com sucesso!", Toast.LENGTH_SHORT).show()
                
                etNome.text.clear()
                etRegiao.text.clear()
                etUrl.text.clear()
            } else {
                Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show()
            }
        }

        tvVerLista.setOnClickListener {
            startActivity(Intent(this, ListaDestinosActivity::class.java))
        }
    }
}
