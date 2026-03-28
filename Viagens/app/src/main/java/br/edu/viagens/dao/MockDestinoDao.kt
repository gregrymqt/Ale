package br.edu.viagens.dao

import br.edu.viagens.model.Destino

class MockDestinoDao : DestinoDao {

    companion object {
        private val destinos = mutableListOf<Destino>()
        private var currentId = 1
    }

    override fun listarTodos(): List<Destino> {
        return destinos.toList()
    }

    override fun inserir(destino: Destino) {
        val novoDestino = destino.copy(id = currentId++)
        destinos.add(novoDestino)
    }

    override fun excluir(destinoId: Int) {
        destinos.removeAll { it.id == destinoId }
    }
}
