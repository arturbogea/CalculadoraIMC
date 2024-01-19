package com.arturbogea.imccalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.widget.EditText
import android.widget.Toast
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

            val peso = binding.editPeso.text.toString()
            val altura = binding.editAltura.text.toString()

            val intent = Intent(this, ResultadoActivity:: class.java)

            if (peso.isNotEmpty() && altura.isNotEmpty()){
                //abaixo, estou jogando os dados do tipo que eu quero para ir os dados para a outra tela
                intent.putExtra("peso", peso.toDouble())
                intent.putExtra("altura", altura.toDouble())
                startActivity(intent)
            }else{
                Toast.makeText(this, "Digite os seus dados", Toast.LENGTH_SHORT).show()
            }


        }

    }
}