package com.arturbogea.imccalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
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
        var imagem = binding.icon

        //abaixo, é para recuperar os valores vindo da outra tela
        val verificar = intent.extras

        if (verificar != null){
            val peso = verificar.getDouble("peso")
            val altura = verificar.getDouble("altura")


            pesoFinal.text = "Peso informado: $peso kg"
            alturaFinal.text = "Altura informada $altura m"



            val imc = peso / (altura * altura)

            imc.toString()

            when {
                imc <= 18.5 -> {
                    mensagem.setText("O seu imc é de ${"%.2f".format(imc)}. Você está abaixo do peso")
                    mensagem.setTextColor(getColor(R.color.orange))
                    imagem.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_warnings))

                }
                imc <= 24.9 -> {
                    mensagem.setText("O seu imc é de ${"%.2f".format(imc)}. Você está com o peso normal")
                    mensagem.setTextColor(getColor(R.color.primaria_variacao))
                    imagem.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_happys))
                }
                imc <= 29.9 -> {
                    mensagem.setText("O seu imc é de ${"%.2f".format(imc)}. Você está acima do peso")
                    mensagem.setTextColor(getColor(R.color.yellow))
                    imagem.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_warnings))
                }
                imc <= 34.9 -> {
                    mensagem.setText("O seu imc é de ${"%.2f".format(imc)}. Obsidade grau 1")
                    mensagem.setTextColor(getColor(R.color.yellow))
                    imagem.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_warnings))
                }
                imc <= 39.9 ->
                    {
                    mensagem.setText("O seu imc é de ${"%.2f".format(imc)}. Obsidade grau 2")
                    mensagem.setTextColor(getColor(R.color.orange))
                        imagem.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_sensors))
                }
                else -> {
                    mensagem.setText("O seu imc é de ${"%.2f".format(imc)}. Obsidade grau 3")
                    mensagem.setTextColor(getColor(R.color.red))
                    imagem.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_medical))
                }
            }


            //mensagem.setText("O seu IMC  está em ${"%.2f".format(imc)}. \n $resultado")
        }
    }
}