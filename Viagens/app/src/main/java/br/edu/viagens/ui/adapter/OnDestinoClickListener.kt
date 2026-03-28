package br.edu.viagens.ui.adapter

import br.edu.viagens.model.Destino

interface OnDestinoClickListener {
    fun onExplorarClick(destino: Destino)
    fun onExcluirClick(destino: Destino, posicao: Int)
}
