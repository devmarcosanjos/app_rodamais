package com.bluestash.rodamais

import android.app.Activity
import android.os.Bundle
import com.google.android.material.button.MaterialButton
import com.google.android.material.card.MaterialCardView
import androidx.appcompat.app.AppCompatActivity

class SelectFuelActivity : AppCompatActivity() {

    private lateinit var btnGasolina: MaterialButton
    private lateinit var btnAlcool: MaterialButton
    private lateinit var btnDiesel: MaterialButton
    private lateinit var btnVoltar: MaterialButton
    private lateinit var cardGasolina: MaterialCardView
    private lateinit var cardAlcool: MaterialCardView
    private lateinit var cardDiesel: MaterialCardView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_fuel)

        btnGasolina = findViewById(R.id.btnGasolina)
        btnAlcool = findViewById(R.id.btnAlcool)
        btnDiesel = findViewById(R.id.btnDiesel)
        btnVoltar = findViewById(R.id.btnVoltar)
        cardGasolina = findViewById(R.id.cardGasolina)
        cardAlcool = findViewById(R.id.cardAlcool)
        cardDiesel = findViewById(R.id.cardDiesel)

        btnGasolina.setOnClickListener { retornarCombustivel("Gasolina") }
        btnAlcool.setOnClickListener { retornarCombustivel("Álcool") }
        btnDiesel.setOnClickListener { retornarCombustivel("Diesel") }
        
        cardGasolina.setOnClickListener { retornarCombustivel("Gasolina") }
        cardAlcool.setOnClickListener { retornarCombustivel("Álcool") }
        cardDiesel.setOnClickListener { retornarCombustivel("Diesel") }
        
        btnVoltar.setOnClickListener {
            finish()
        }
    }

    private fun retornarCombustivel(tipo: String) {
        val resultIntent = intent
        resultIntent.putExtra("COMBUSTIVEL", tipo)
        setResult(Activity.RESULT_OK, resultIntent)
        finish()
    }
}