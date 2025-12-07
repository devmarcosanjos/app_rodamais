package com.bluestash.rodamais

import org.junit.Test
import org.junit.Assert.*
import org.junit.Before

/**
 * Testes unitários para a classe FuelCalculator.
 */
class FuelCalculatorTest {

    @Test
    fun `gasolina maior que alcool - gasolina mais cara`() {
        val priceGasoline = 6.50
        val consumptionGasoline = 10.0
        val priceAlcohol = 4.50
        val consumptionAlcohol = 8.0
        
        val costGasoline = FuelCalculator.calculateCostPerKm(priceGasoline, consumptionGasoline)
        val costAlcohol = FuelCalculator.calculateCostPerKm(priceAlcohol, consumptionAlcohol)
        val comparison = FuelCalculator.compareFuels(costGasoline, costAlcohol)
        
        assertEquals(0.65, costGasoline, 0.0001)
        assertEquals(0.5625, costAlcohol, 0.0001)
        assertEquals(2, comparison)
        assertTrue(costGasoline > costAlcohol)
    }
    
    @Test
    fun `alcool maior que gasolina - alcool mais caro`() {
        val priceGasoline = 5.00
        val consumptionGasoline = 12.0
        val priceAlcohol = 4.80
        val consumptionAlcohol = 7.0
        
        val costGasoline = FuelCalculator.calculateCostPerKm(priceGasoline, consumptionGasoline)
        val costAlcohol = FuelCalculator.calculateCostPerKm(priceAlcohol, consumptionAlcohol)
        val comparison = FuelCalculator.compareFuels(costGasoline, costAlcohol)
        
        assertEquals(0.4167, costGasoline, 0.0001)
        assertEquals(0.6857, costAlcohol, 0.0001)
        assertEquals(1, comparison)
        assertTrue(costAlcohol > costGasoline)
    }
    
    @Test
    fun `campo em branco - deve retornar zero ou false`() {
        val emptyPrice = 0.0
        val emptyConsumption = 0.0
        val validPrice = 5.89
        val validConsumption = 10.0
        
        val costWithEmptyField = FuelCalculator.calculateCostPerKm(emptyPrice, emptyConsumption)
        val validationWithEmptyField = FuelCalculator.validateData(emptyPrice, emptyConsumption)
        val validationEmptyPrice = FuelCalculator.validateData(emptyPrice, validConsumption)
        val validationEmptyConsumption = FuelCalculator.validateData(validPrice, emptyConsumption)
        
        assertEquals(0.0, costWithEmptyField, 0.0001)
        assertFalse(validationWithEmptyField)
        assertFalse(validationEmptyPrice)
        assertFalse(validationEmptyConsumption)
    }
}

