package com.bluestash.rodamais

import org.junit.Test
import org.junit.Assert.*

/**
 * Testes unitários básicos.
 * 
 * Para testes completos da lógica de cálculo de combustíveis,
 * veja [FuelCalculatorTest].
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }
    
    @Test
    fun `teste basico - verifica que FuelCalculator existe`() {
        val cost = FuelCalculator.calculateCostPerKm(5.0, 10.0)
        assertEquals(0.5, cost, 0.001)
    }
}