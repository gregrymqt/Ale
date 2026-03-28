package br.edu.viagens.dao

import br.edu.viagens.model.Destino

interface DestinoDao {
    fun listarTodos(): List<Destino>
    fun inserir(destino: Destino)
    fun excluir(destinoId: Int)
}
