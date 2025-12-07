package com.bluestash.rodamais

import android.app.Activity
import android.os.Bundle
import android.widget.TextView
import com.google.android.material.button.MaterialButton
import androidx.appcompat.app.AppCompatActivity

class ResultActivity : AppCompatActivity() {

    private lateinit var tvValores: TextView
    private lateinit var tvRecomendacao: TextView
    private lateinit var btnVoltar: MaterialButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        tvValores = findViewById(R.id.tvValores)
        tvRecomendacao = findViewById(R.id.tvRecomendacao)
        btnVoltar = findViewById(R.id.btnVoltar)

        val combustivel1 = intent.getStringExtra("COMBUSTIVEL1") ?: ""
        val combustivel2 = intent.getStringExtra("COMBUSTIVEL2") ?: ""
        val consumo1 = intent.getDoubleExtra("CONSUMO1", 0.0)
        val consumo2 = intent.getDoubleExtra("CONSUMO2", 0.0)
        val valor1 = intent.getDoubleExtra("VALOR1", 0.0)
        val valor2 = intent.getDoubleExtra("VALOR2", 0.0)

        // Calcular custo por km
        //val custoPorKm1 = valor1 / consumo1
        val custoPorKm1 = if(consumo1 > 0) valor1 / consumo1 else 0.0
        //val custoPorKm2 = valor2 / consumo2
        val custoPorKm2 = if(consumo2 > 0) valor2 / consumo2 else 0.0

        tvValores.text = buildString {
            append("$combustivel1:\n")
            append("  Preço: R$ %.2f/L\n".format(valor1))
            append("  Consumo: %.2f km/L\n".format(consumo1))
            append("  Custo/km: R$ %.4f\n\n".format(custoPorKm1))
            append("$combustivel2:\n")
            append("  Preço: R$ %.2f/L\n".format(valor2))
            append("  Consumo: %.2f km/L\n".format(consumo2))
            append("  Custo/km: R$ %.4f".format(custoPorKm2))
        }

        val recomendacao = calcularMelhorCombustivel(
            combustivel1, combustivel2, 
            custoPorKm1, custoPorKm2
        )
        tvRecomendacao.text = recomendacao

        btnVoltar.setOnClickListener {
            // Retornar resultado para indicar que deve resetar os campos
            setResult(Activity.RESULT_OK)
            finish() // volta para a tela anterior
        }
    }

    private fun calcularMelhorCombustivel(
        combustivel1: String, 
        combustivel2: String,
        custoPorKm1: Double, 
        custoPorKm2: Double
    ): String {
        val diferenca = kotlin.math.abs(custoPorKm1 - custoPorKm2)
        val percentualEconomia = (diferenca / kotlin.math.max(custoPorKm1, custoPorKm2)) * 100
        
        return if (custoPorKm1 < custoPorKm2) {
            buildString {
                append("$combustivel1 é mais econômico!\n")
                append("Economia de R$ %.4f por km\n".format(diferenca))
                append("(%.1f%% mais barato)".format(percentualEconomia))
            }
        } else {
            buildString {
                append("$combustivel2 é mais econômico!\n")
                append("Economia de R$ %.4f por km\n".format(diferenca))
                append("(%.1f%% mais barato)".format(percentualEconomia))
            }
        }
    }
}