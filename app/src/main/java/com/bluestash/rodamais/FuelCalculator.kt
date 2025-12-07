package com.bluestash.rodamais

object FuelCalculator {
    
    fun calculateCostPerKm(pricePerLiter: Double, consumption: Double): Double {
        return if (consumption > 0) {
            pricePerLiter / consumption
        } else {
            0.0
        }
    }
    
    fun compareFuels(costPerKm1: Double, costPerKm2: Double): Int {
        return when {
            costPerKm1 < costPerKm2 -> 1
            costPerKm2 < costPerKm1 -> 2
            else -> 0
        }
    }
    
    fun calculateDifference(costPerKm1: Double, costPerKm2: Double): Double {
        return kotlin.math.abs(costPerKm1 - costPerKm2)
    }
    
    fun calculateSavingsPercentage(difference: Double, maxCost: Double): Double {
        return if (maxCost > 0) {
            (difference / maxCost) * 100
        } else {
            0.0
        }
    }
    
    fun validateData(price: Double, consumption: Double): Boolean {
        return price > 0 && consumption > 0
    }
}