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

    private lateinit var tvConsumption1: TextView
    private lateinit var tvConsumption2: TextView
    private lateinit var tilConsumption1: TextInputLayout
    private lateinit var tilConsumption2: TextInputLayout
    private lateinit var tilPrice1: TextInputLayout
    private lateinit var tilPrice2: TextInputLayout
    private lateinit var etConsumption1: TextInputEditText
    private lateinit var etConsumption2: TextInputEditText
    private lateinit var etPrice1: TextInputEditText
    private lateinit var etPrice2: TextInputEditText
    private lateinit var btnSearch1: ImageButton
    private lateinit var btnSearch2: ImageButton
    private lateinit var btnCalculate: MaterialButton
    
    private var fuel1: String = ""
    private var fuel2: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvConsumption1 = findViewById(R.id.tvConsumo1)
        tvConsumption2 = findViewById(R.id.tvConsumo2)
        tilConsumption1 = findViewById(R.id.tilConsumo1)
        tilConsumption2 = findViewById(R.id.tilConsumo2)
        tilPrice1 = findViewById(R.id.tilValor1)
        tilPrice2 = findViewById(R.id.tilValor2)
        etConsumption1 = findViewById(R.id.etConsumo1)
        etConsumption2 = findViewById(R.id.etConsumo2)
        etPrice1 = findViewById(R.id.etValor1)
        etPrice2 = findViewById(R.id.etValor2)
        btnSearch1 = findViewById(R.id.btnBuscar1)
        btnSearch2 = findViewById(R.id.btnBuscar2)
        btnCalculate = findViewById(R.id.btnCalcular)

        btnSearch1.setOnClickListener {
            openFuelSelection(Constants.RequestCodes.FUEL_1)
        }

        btnSearch2.setOnClickListener {
            openFuelSelection(Constants.RequestCodes.FUEL_2)
        }
        
        btnCalculate.setOnClickListener {
            calculateBestFuel()
        }
    }

    @Suppress("DEPRECATION")
    private fun openFuelSelection(requestCode: Int) {
        val intent = Intent(this, SelectFuelActivity::class.java)
        startActivityForResult(intent, requestCode)
    }

    @Suppress("DEPRECATION")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        when (requestCode) {
            Constants.RequestCodes.FUEL_1 -> {
                if (resultCode == Activity.RESULT_OK && data != null) {
                    val fuel = data.getStringExtra(Constants.IntentKeys.FUEL) ?: return
                    fuel1 = fuel
                    tvConsumption1.text = "${Constants.InterfaceTexts.CONSUMPTION_PREFIX}$fuel"
                }
            }
            Constants.RequestCodes.FUEL_2 -> {
                if (resultCode == Activity.RESULT_OK && data != null) {
                    val fuel = data.getStringExtra(Constants.IntentKeys.FUEL) ?: return
                    fuel2 = fuel
                    tvConsumption2.text = "${Constants.InterfaceTexts.CONSUMPTION_PREFIX}$fuel"
                }
            }
            Constants.RequestCodes.RESULT -> {
                resetFields()
            }
        }
    }
    
    private fun calculateBestFuel() {
        clearErrors()
        
        val consumption1Text = etConsumption1.text?.toString()?.trim() ?: ""
        val consumption2Text = etConsumption2.text?.toString()?.trim() ?: ""
        val price1Text = etPrice1.text?.toString()?.trim() ?: ""
        val price2Text = etPrice2.text?.toString()?.trim() ?: ""
        
        var hasError = false
        
        if (fuel1.isEmpty() || fuel2.isEmpty()) {
            showError(Constants.Messages.SELECT_TWO_FUELS)
            return
        }
        
        if (consumption1Text.isEmpty()) {
            tilConsumption1.error = Constants.Messages.REQUIRED_FIELD
            hasError = true
        } else {
            val consumption1 = consumption1Text.toDoubleOrNull()
            if (consumption1 == null || consumption1 <= 0) {
                tilConsumption1.error = Constants.Messages.INVALID_VALUE
                hasError = true
            }
        }
        
        if (consumption2Text.isEmpty()) {
            tilConsumption2.error = Constants.Messages.REQUIRED_FIELD
            hasError = true
        } else {
            val consumption2 = consumption2Text.toDoubleOrNull()
            if (consumption2 == null || consumption2 <= 0) {
                tilConsumption2.error = Constants.Messages.INVALID_VALUE
                hasError = true
            }
        }
        
        if (price1Text.isEmpty()) {
            tilPrice1.error = Constants.Messages.REQUIRED_FIELD
            hasError = true
        } else {
            val price1 = price1Text.toDoubleOrNull()
            if (price1 == null || price1 <= 0) {
                tilPrice1.error = Constants.Messages.INVALID_VALUE
                hasError = true
            }
        }
        
        if (price2Text.isEmpty()) {
            tilPrice2.error = Constants.Messages.REQUIRED_FIELD
            hasError = true
        } else {
            val price2 = price2Text.toDoubleOrNull()
            if (price2 == null || price2 <= 0) {
                tilPrice2.error = Constants.Messages.INVALID_VALUE
                hasError = true
            }
        }
        
        if (hasError) {
            return
        }
        
        val consumption1 = consumption1Text.toDouble()
        val consumption2 = consumption2Text.toDouble()
        val price1 = price1Text.toDouble()
        val price2 = price2Text.toDouble()
        
        val intent = Intent(this, ResultActivity::class.java)
        intent.putExtra(Constants.IntentKeys.FUEL1, fuel1)
        intent.putExtra(Constants.IntentKeys.FUEL2, fuel2)
        intent.putExtra(Constants.IntentKeys.CONSUMPTION1, consumption1)
        intent.putExtra(Constants.IntentKeys.CONSUMPTION2, consumption2)
        intent.putExtra(Constants.IntentKeys.PRICE1, price1)
        intent.putExtra(Constants.IntentKeys.PRICE2, price2)
        startActivityForResult(intent, Constants.RequestCodes.RESULT)
    }
    
    private fun clearErrors() {
        tilConsumption1.error = null
        tilConsumption2.error = null
        tilPrice1.error = null
        tilPrice2.error = null
    }
    
    private fun showError(message: String) {
        Snackbar.make(findViewById(android.R.id.content), message, Snackbar.LENGTH_LONG)
            .setBackgroundTint(getColor(R.color.error))
            .setTextColor(getColor(R.color.white))
            .show()
    }
    
    private fun resetFields() {
        etConsumption1.text?.clear()
        etConsumption2.text?.clear()
        etPrice1.text?.clear()
        etPrice2.text?.clear()
        
        clearErrors()
        
        tvConsumption1.text = Constants.InterfaceTexts.FUEL_1
        tvConsumption2.text = Constants.InterfaceTexts.FUEL_2
        
        fuel1 = ""
        fuel2 = ""
    }
}