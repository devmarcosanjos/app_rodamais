package com.bluestash.rodamais

import android.app.Activity
import android.os.Bundle
import android.widget.TextView
import com.google.android.material.button.MaterialButton
import androidx.appcompat.app.AppCompatActivity

class ResultActivity : AppCompatActivity() {

    private lateinit var tvValues: TextView
    private lateinit var tvRecommendation: TextView
    private lateinit var btnBack: MaterialButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        tvValues = findViewById(R.id.tvValores)
        tvRecommendation = findViewById(R.id.tvRecomendacao)
        btnBack = findViewById(R.id.btnVoltar)

        val fuel1 = intent.getStringExtra(Constants.IntentKeys.FUEL1) ?: ""
        val fuel2 = intent.getStringExtra(Constants.IntentKeys.FUEL2) ?: ""
        val consumption1 = intent.getDoubleExtra(Constants.IntentKeys.CONSUMPTION1, Constants.DefaultValues.INVALID_CONSUMPTION)
        val consumption2 = intent.getDoubleExtra(Constants.IntentKeys.CONSUMPTION2, Constants.DefaultValues.INVALID_CONSUMPTION)
        val price1 = intent.getDoubleExtra(Constants.IntentKeys.PRICE1, Constants.DefaultValues.INVALID_PRICE)
        val price2 = intent.getDoubleExtra(Constants.IntentKeys.PRICE2, Constants.DefaultValues.INVALID_PRICE)

        val costPerKm1 = FuelCalculator.calculateCostPerKm(price1, consumption1)
        val costPerKm2 = FuelCalculator.calculateCostPerKm(price2, consumption2)

        tvValues.text = buildString {
            append("$fuel1:\n")
            append("  Preço: R$ %.2f/L\n".format(price1))
            append("  Consumo: %.2f km/L\n".format(consumption1))
            append("  Custo/km: R$ %.4f\n\n".format(costPerKm1))
            append("$fuel2:\n")
            append("  Preço: R$ %.2f/L\n".format(price2))
            append("  Consumo: %.2f km/L\n".format(consumption2))
            append("  Custo/km: R$ %.4f".format(costPerKm2))
        }

        val comparison = FuelCalculator.compareFuels(costPerKm1, costPerKm2)
        val difference = FuelCalculator.calculateDifference(costPerKm1, costPerKm2)
        val maxCost = kotlin.math.max(costPerKm1, costPerKm2)
        val savingsPercentage = FuelCalculator.calculateSavingsPercentage(difference, maxCost)
        
        val recommendation = when (comparison) {
            1 -> buildString {
                append("$fuel1 é mais econômico!\n")
                append("Economia de R$ %.4f por km\n".format(difference))
                append("(%.1f%% mais barato)".format(savingsPercentage))
            }
            2 -> buildString {
                append("$fuel2 é mais econômico!\n")
                append("Economia de R$ %.4f por km\n".format(difference))
                append("(%.1f%% mais barato)".format(savingsPercentage))
            }
            else -> "Os dois combustíveis têm o mesmo custo por km"
        }
        
        tvRecommendation.text = recommendation

        btnBack.setOnClickListener {
            setResult(Activity.RESULT_OK)
            finish()
        }
    }
}