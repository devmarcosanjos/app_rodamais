package com.bluestash.rodamais

import android.app.Activity
import android.os.Bundle
import com.google.android.material.button.MaterialButton
import com.google.android.material.card.MaterialCardView
import androidx.appcompat.app.AppCompatActivity

class SelectFuelActivity : AppCompatActivity() {

    private lateinit var btnBack: MaterialButton
    private lateinit var cardGasoline: MaterialCardView
    private lateinit var cardAlcohol: MaterialCardView
    private lateinit var cardDiesel: MaterialCardView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_fuel)

        btnBack = findViewById(R.id.btnVoltar)
        cardGasoline = findViewById(R.id.cardGasolina)
        cardAlcohol = findViewById(R.id.cardAlcool)
        cardDiesel = findViewById(R.id.cardDiesel)

        cardGasoline.setOnClickListener { returnFuel(Constants.FuelTypes.GASOLINE) }
        cardAlcohol.setOnClickListener { returnFuel(Constants.FuelTypes.ALCOHOL) }
        cardDiesel.setOnClickListener { returnFuel(Constants.FuelTypes.DIESEL) }
        
        btnBack.setOnClickListener {
            finish()
        }
    }

    private fun returnFuel(type: String) {
        val resultIntent = intent
        resultIntent.putExtra(Constants.IntentKeys.FUEL, type)
        setResult(Activity.RESULT_OK, resultIntent)
        finish()
    }
}