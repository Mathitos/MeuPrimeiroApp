package com.example.meuprimeiroapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    private val listaDeItens = mutableListOf<String>()
    private lateinit var dialog: MaterialAlertDialogBuilder

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val botaoDeCriarItem = findViewById<FloatingActionButton>(R.id.botao_criar)
        botaoDeCriarItem.setOnClickListener{
           abrirDialogParaCriarItem()
        }

        dialog = MaterialAlertDialogBuilder(this)
    }

    private fun abrirDialogParaCriarItem() {
        val adicionarDialogView = LayoutInflater.from(this).inflate(R.layout.create_item_dialog, null, false)
        dialog.setView(adicionarDialogView).setPositiveButton("confirmar") { _ , _ ->
            val input = adicionarDialogView.findViewById<EditText>(R.id.criar_item_input)
            val novoItem = input.text.toString()
            listaDeItens.add(novoItem)

//            Toast.makeText(this@MainActivity, listaDeItens.toString(), Toast.LENGTH_SHORT).show()
        }.show()
    }
}