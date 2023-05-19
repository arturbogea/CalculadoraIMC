package com.example.calculadoraimc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.example.calculadoraimc.databinding.ActivityHomeBinding

class Home : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bt_calcular = binding.btCalcular
        val mensagem = binding.txtInforme

        bt_calcular.setOnClickListener {
            val edit_peso = binding.editPeso.text.toString()
            val edit_altura = binding.editAltura.text.toString()

            if (edit_peso.isEmpty()){
                mensagem.setText("Informe o seu peso")
            }else if (edit_altura.isEmpty()){
                mensagem.setText("Informe a sua altura")
            }else{
                calculoIMC()
            }

        }
    }

    private fun calculoIMC(){
        val pesoId = binding.editPeso
        val alturaId = binding.editAltura

        val peso = Integer.parseInt(pesoId.text.toString())
        val altura = java.lang.Float.parseFloat(alturaId.text.toString())
        val resultado = binding.txtInforme
        val imc = peso / (altura * altura)

        var Mensagem = when{
            imc <= 18.5 -> "Cuidado, você está abaixo do seu peso"
            imc <= 24.9 -> "Parabéns. Você está dentro do seu peso ideal"
            imc <= 29.9 -> "Atenção. você está um pouco acima do seu peso ideal"
            imc <= 34.9 -> "Cuidado, você está com obsidade grau 1"
            imc <= 39.9 -> "Muito cuidado. Você com obesidade grau 2"
            else -> "Obesidade grau 3"
        }

        imc.toString()
        resultado.setText("O seu IMC está em $imc \n $Mensagem")
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // nesse caso é para criar um botão de menu. Vou criar outra sobreescrita de metodos para limpar os dados na tela
        var inflate = menuInflater
        inflate.inflate(R.menu.menu_principal, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        //aqui coloquei a logica, para limpar os dados informados
        when(item.itemId){
            R.id.reset -> {
                val limparEditPeso = binding.editPeso
                val limparEditAltura = binding.editAltura
                val limparMensagem = binding.txtInforme

                limparEditPeso.setText("")
                limparEditAltura.setText("")
                limparMensagem.setText("")

            }
        }

        return super.onOptionsItemSelected(item)
    }
}