package br.com.meusite.mydigitalbank

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var btnTransaction : Button
    private lateinit var btnMoneyBox : Button
    private lateinit var btnShop : Button

    private lateinit var usuarioAtual: Usuario

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        encontrarElementos()

        val nomeConta = intent.getStringExtra("contaNome") ?: "Usuário"

        Log.i("MainActivity", "Nome da conta: $nomeConta")

        val usuarios = listOf(
            Usuario("João Pedro F", R.drawable.me_jflowers, obterTransacoes("João Pedro F")),
            Usuario("José Ribeiro J", R.drawable.jose, obterTransacoes("José Ribeiro J")),
            Usuario("Ana Luiza S", R.drawable.ana, obterTransacoes("Ana Luiza S"))
        )

        // Encontrar o usuário atual baseado no nome
        usuarioAtual = usuarios.find { it.nome == nomeConta } ?: usuarios[0]   // Pega o primeiro se não encontrar

        btnTransaction.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.ContainerViewMain, SobreContaFragment())
                .commit()
        }

        btnMoneyBox.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.ContainerViewMain, CaixinhasFragment())
                .commit()
        }
//
//        btnShop.setOnClickListener {
//            supportFragmentManager.beginTransaction()
//                .replace(R.id.ContainerViewMain, ShopFragment.newInstance(usuarioAtual))
//                .commit()
//        }
    }

    private fun encontrarElementos() {
        btnTransaction = findViewById(R.id.btnTransaction)
        btnMoneyBox = findViewById(R.id.btnMoneyBox)
        btnShop = findViewById(R.id.btnShop)
    }

    private fun obterTransacoes(usuarioNome: String): List<Transacao> {
        return List(20) { index ->
            Transacao(
                "Transação ${index + 1} do $usuarioNome",
                (index + 1) * 10.0, // Exemplo de valores incrementais
                "20/09/2024", // Data fixa para simplicidade
                "14:0${index % 60}" // Horas variando a cada transação
            )
        }
    }
}