package br.com.meusite.mydigitalbank

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Entrada : AppCompatActivity() {

    private lateinit var rvContas : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_entrada)

        rvContas = findViewById(R.id.rvContas)

        val contas = listOf(
            Conta("João Pedro F", R.drawable.me_jflowers),
            Conta("José Ribeiro J", R.drawable.jose),
            Conta("Ana Luiza S", R.drawable.ana)
        )

        rvContas.layoutManager = LinearLayoutManager(this)

        rvContas.adapter = ContaAdapter(contas) { contaSelecionada ->

            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("contaNome", contaSelecionada.nome)

            startActivity(intent)
        }
    }
}