package br.com.meusite.mydigitalbank

import androidx.recyclerview.widget.RecyclerView.*
import android.util.Log
import android.view.LayoutInflater
import android.widget.TextView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView

class ContaAdapter (
    private val contas: List<Conta>,
    private val listener: (Conta) -> Unit
) : Adapter<ContaAdapter.ContaViewHolder>() {

    inner class ContaViewHolder (private val itemView: View) : ViewHolder(itemView) {
        val textUserName: TextView = itemView.findViewById(R.id.textUserName)
        val imageCtt: ImageView = itemView.findViewById(R.id.imageCtt)

        fun bind(conta: Conta, listener: (Conta) -> Unit) {
            textUserName.text = conta.nome
            imageCtt.setImageResource(conta.imagem)
            itemView.setOnClickListener { listener(conta) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContaViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemView = layoutInflater.inflate(R. layout.rv_item_conta, parent, false)
        return ContaViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ContaViewHolder, position: Int) {
        val conta = contas[position]
        holder.textUserName.text = conta.nome
        holder.imageCtt.setImageResource(conta.imagem)
        holder.bind(conta, listener)
    }

    override fun getItemCount(): Int {
        return contas.size
    }
}