package com.bluestash.rodamais

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import com.google.android.material.button.MaterialButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var tvConsumo1: TextView
    private lateinit var tvConsumo2: TextView
    private lateinit var tilConsumo1: TextInputLayout
    private lateinit var tilConsumo2: TextInputLayout
    private lateinit var tilValor1: TextInputLayout
    private lateinit var tilValor2: TextInputLayout
    private lateinit var etConsumo1: TextInputEditText
    private lateinit var etConsumo2: TextInputEditText
    private lateinit var etValor1: TextInputEditText
    private lateinit var etValor2: TextInputEditText
    private lateinit var btnBuscar1: ImageButton
    private lateinit var btnBuscar2: ImageButton
    private lateinit var btnCalcular: MaterialButton
    
    private var combustivel1: String = ""
    private var combustivel2: String = ""

    companion object {
        private const val REQUEST_COMBUSTIVEL_1 = 1
        private const val REQUEST_COMBUSTIVEL_2 = 2
        private const val REQUEST_RESULT = 3
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvConsumo1 = findViewById(R.id.tvConsumo1)
        tvConsumo2 = findViewById(R.id.tvConsumo2)
        tilConsumo1 = findViewById(R.id.tilConsumo1)
        tilConsumo2 = findViewById(R.id.tilConsumo2)
        tilValor1 = findViewById(R.id.tilValor1)
        tilValor2 = findViewById(R.id.tilValor2)
        etConsumo1 = findViewById(R.id.etConsumo1)
        etConsumo2 = findViewById(R.id.etConsumo2)
        etValor1 = findViewById(R.id.etValor1)
        etValor2 = findViewById(R.id.etValor2)
        btnBuscar1 = findViewById(R.id.btnBuscar1)
        btnBuscar2 = findViewById(R.id.btnBuscar2)
        btnCalcular = findViewById(R.id.btnCalcular)

        btnBuscar1.setOnClickListener {
            abrirSelecaoCombustivel(REQUEST_COMBUSTIVEL_1)
        }

        btnBuscar2.setOnClickListener {
            abrirSelecaoCombustivel(REQUEST_COMBUSTIVEL_2)
        }
        
        btnCalcular.setOnClickListener {
            calcularMelhorCombustivel()
        }
    }

    @Suppress("DEPRECATION")
    private fun abrirSelecaoCombustivel(requestCode: Int) {
        val intent = Intent(this, SelectFuelActivity::class.java)
        startActivityForResult(intent, requestCode)
    }

    @Suppress("DEPRECATION")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        when (requestCode) {
            REQUEST_COMBUSTIVEL_1 -> {
                if (resultCode == Activity.RESULT_OK && data != null) {
                    val combustivel = data.getStringExtra("COMBUSTIVEL") ?: return
                    combustivel1 = combustivel
                    tvConsumo1.text = "Consumo | $combustivel"
                }
            }
            REQUEST_COMBUSTIVEL_2 -> {
                if (resultCode == Activity.RESULT_OK && data != null) {
                    val combustivel = data.getStringExtra("COMBUSTIVEL") ?: return
                    combustivel2 = combustivel
                    tvConsumo2.text = "Consumo | $combustivel"
                }
            }
            REQUEST_RESULT -> {
                // Quando voltar da tela de resultado, resetar todos os campos
                resetarCampos()
            }
        }
    }
    
    private fun calcularMelhorCombustivel() {
        // Limpar erros anteriores
        limparErros()
        
        // Validar campos
        val consumo1Text = etConsumo1.text?.toString()?.trim() ?: ""
        val consumo2Text = etConsumo2.text?.toString()?.trim() ?: ""
        val valor1Text = etValor1.text?.toString()?.trim() ?: ""
        val valor2Text = etValor2.text?.toString()?.trim() ?: ""
        
        var temErro = false
        
        if (combustivel1.isEmpty() || combustivel2.isEmpty()) {
            mostrarErro("Selecione os dois tipos de combustível")
            return
        }
        
        if (consumo1Text.isEmpty()) {
            tilConsumo1.error = "Campo obrigatório"
            temErro = true
        } else {
            val consumo1 = consumo1Text.toDoubleOrNull()
            if (consumo1 == null || consumo1 <= 0) {
                tilConsumo1.error = "Valor inválido"
                temErro = true
            }
        }
        
        if (consumo2Text.isEmpty()) {
            tilConsumo2.error = "Campo obrigatório"
            temErro = true
        } else {
            val consumo2 = consumo2Text.toDoubleOrNull()
            if (consumo2 == null || consumo2 <= 0) {
                tilConsumo2.error = "Valor inválido"
                temErro = true
            }
        }
        
        if (valor1Text.isEmpty()) {
            tilValor1.error = "Campo obrigatório"
            temErro = true
        } else {
            val valor1 = valor1Text.toDoubleOrNull()
            if (valor1 == null || valor1 <= 0) {
                tilValor1.error = "Valor inválido"
                temErro = true
            }
        }
        
        if (valor2Text.isEmpty()) {
            tilValor2.error = "Campo obrigatório"
            temErro = true
        } else {
            val valor2 = valor2Text.toDoubleOrNull()
            if (valor2 == null || valor2 <= 0) {
                tilValor2.error = "Valor inválido"
                temErro = true
            }
        }
        
        if (temErro) {
            return
        }
        
        val consumo1 = consumo1Text.toDouble()
        val consumo2 = consumo2Text.toDouble()
        val valor1 = valor1Text.toDouble()
        val valor2 = valor2Text.toDouble()
        
        // Navegar para ResultActivity
        val intent = Intent(this, ResultActivity::class.java)
        intent.putExtra("COMBUSTIVEL1", combustivel1)
        intent.putExtra("COMBUSTIVEL2", combustivel2)
        intent.putExtra("CONSUMO1", consumo1)
        intent.putExtra("CONSUMO2", consumo2)
        intent.putExtra("VALOR1", valor1)
        intent.putExtra("VALOR2", valor2)
        startActivityForResult(intent, REQUEST_RESULT)
    }
    
    private fun limparErros() {
        tilConsumo1.error = null
        tilConsumo2.error = null
        tilValor1.error = null
        tilValor2.error = null
    }
    
    private fun mostrarErro(mensagem: String) {
        Snackbar.make(findViewById(android.R.id.content), mensagem, Snackbar.LENGTH_LONG)
            .setBackgroundTint(getColor(R.color.error))
            .setTextColor(getColor(R.color.white))
            .show()
    }
    
    private fun resetarCampos() {
        // Limpar textos dos campos
        etConsumo1.text?.clear()
        etConsumo2.text?.clear()
        etValor1.text?.clear()
        etValor2.text?.clear()
        
        // Limpar erros
        limparErros()
        
        // Resetar textos dos títulos
        tvConsumo1.text = "Combustível 1"
        tvConsumo2.text = "Combustível 2"
        
        // Resetar variáveis de combustível
        combustivel1 = ""
        combustivel2 = ""
        
        // Reabilitar campos e botões
        etConsumo1.isEnabled = true
        etConsumo2.isEnabled = true
        btnBuscar1.isEnabled = true
        btnBuscar2.isEnabled = true
        etConsumo1.alpha = 1.0f
        etConsumo2.alpha = 1.0f
        btnBuscar1.alpha = 1.0f
        btnBuscar2.alpha = 1.0f
    }
}