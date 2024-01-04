package com.arturbogea.imccalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.arturbogea.imccalculator.databinding.ActivityResultadoBinding

class ResultadoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResultadoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultadoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()



        resultadoFinal()

    }

    fun resultadoFinal(){

        var pesoFinal = binding.textPeso
        var alturaFinal = binding.textAltura
        var mensagem = binding.textResultado

        //abaixo, é para recuperar os valores vindo da outra tela
        val verificar = intent.extras

        if (verificar != null){
            val peso = verificar.getDouble("peso")
            val altura = verificar.getDouble("altura")


            pesoFinal.text = "Peso informado: $peso kg"
            alturaFinal.text = "Altura informada $altura m"



            val imc = peso / (altura * altura)

            val resultado = when{
                imc <= 18.5 -> "Abaixo do peso"
                imc <= 24.9 -> "Peso normal"
                imc <= 29.9 -> "Acima do peso"
                imc <= 34.9 -> "Obsidade grau 1"
                imc <= 39.9 -> "Obesidade grau 2"
                else -> "Obesidade grau 3"
            }

            imc.toString()
            mensagem.setText("O seu IMC  está em ${"%.2f".format(imc)}. \n $resultado")
        }
    }
}