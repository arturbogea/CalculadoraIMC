package com.arturbogea.imccalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.widget.EditText
import com.arturbogea.imccalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        val calcular = binding.btnCalcular



        calcularIMC()

    }

    fun calcularIMC(){

        binding.btnCalcular.setOnClickListener {

            val peso = binding.txtPeso.text.toString()
            val altura = binding.txtAltura.text.toString()

            val intent = Intent(this, ResultadoActivity:: class.java)

            if (peso.isNotEmpty() && altura.isNotEmpty()){
                //abaixo, estou jogando os dados do tipo que eu quero para ir os dados para a outra tela
                intent.putExtra("peso", peso.toDouble())
                intent.putExtra("altura", altura.toDouble())
            }

            startActivity(intent)
        }

    }
}