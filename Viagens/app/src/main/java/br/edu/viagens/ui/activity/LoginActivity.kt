package br.edu.viagens.ui.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.edu.viagens.R

class LoginActivity : AppCompatActivity() {

    companion object {
        const val USUARIO_FIXO = "admin"
        const val SENHA_FIXA = "123"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val etUsuario = findViewById<EditText>(R.id.etUsuario)
        val etSenha = findViewById<EditText>(R.id.etSenha)
        val btEntrar = findViewById<Button>(R.id.btEntrar)
        val tvCadastro = findViewById<TextView>(R.id.tvCadastro)

        btEntrar.setOnClickListener {
            val usuario = etUsuario.text.toString()
            val senha = etSenha.text.toString()

            if (usuario == USUARIO_FIXO && senha == SENHA_FIXA) {
                val intent = Intent(this, ListaDestinosActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "Credenciais invalidas!", Toast.LENGTH_SHORT).show()
            }
        }

        tvCadastro.setOnClickListener {
            val intent = Intent(this, CadastroDestinoActivity::class.java)
            startActivity(intent)
        }
    }
}
