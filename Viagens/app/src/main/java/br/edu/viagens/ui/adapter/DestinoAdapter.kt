package br.edu.viagens.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.edu.viagens.R
import br.edu.viagens.model.Destino

class DestinoAdapter(
    private val destinos: List<Destino>,
    private val listener: OnDestinoClickListener
) : RecyclerView.Adapter<DestinoAdapter.DestinoViewHolder>() {

    class DestinoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvNome: TextView = view.findViewById(R.id.tvNomeItem)
        val tvRegiao: TextView = view.findViewById(R.id.tvRegiaoItem)
        val btExplorar: Button = view.findViewById(R.id.btExplorarItem)
        val btExcluir: Button = view.findViewById(R.id.btExcluirItem)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DestinoViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_destino, parent, false)
        return DestinoViewHolder(view)
    }

    override fun onBindViewHolder(holder: DestinoViewHolder, position: Int) {
        val destino = destinos[position]
        holder.tvNome.text = destino.nome
        holder.tvRegiao.text = destino.regiao

        holder.btExplorar.setOnClickListener { 
            listener.onExplorarClick(destino) 
        }
        
        holder.btExcluir.setOnClickListener { 
            val posicaoAtual = holder.getAbsoluteAdapterPosition()
            if (posicaoAtual != RecyclerView.NO_POSITION) {
                listener.onExcluirClick(destino, posicaoAtual)
            }
        }
    }

    override fun getItemCount(): Int = destinos.size
}
