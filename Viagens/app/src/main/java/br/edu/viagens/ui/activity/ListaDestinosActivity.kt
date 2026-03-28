package br.edu.viagens.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import br.edu.viagens.R
import br.edu.viagens.dao.MockDestinoDao
import br.edu.viagens.model.Destino
import br.edu.viagens.ui.adapter.DestinoAdapter
import br.edu.viagens.ui.adapter.OnDestinoClickListener

class ListaDestinosActivity : AppCompatActivity(), OnDestinoClickListener {

    private val dao = MockDestinoDao()
    private lateinit var rvDestinos: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_destinos)

        rvDestinos = findViewById(R.id.rvDestinos)

        carregarLista()
    }

    override fun onResume() {
        super.onResume()
        carregarLista()
    }

    private fun carregarLista() {
        val destinos = dao.listarTodos()
        rvDestinos.adapter = DestinoAdapter(destinos, this)
    }

    override fun onExplorarClick(destino: Destino) {
        val intent = Intent(this, WebViewActivity::class.java)
        intent.putExtra("URL_DESTINO", destino.url)
        startActivity(intent)
    }

    override fun onExcluirClick(destino: Destino, posicao: Int) {
        dao.excluir(destino.id)
        carregarLista()
    }
}
