package com.bluestash.rodamais

object Constants {
    
    object RequestCodes {
        const val FUEL_1 = 1
        const val FUEL_2 = 2
        const val RESULT = 3
    }
    
    object IntentKeys {
        const val FUEL = "FUEL"
        const val FUEL1 = "FUEL1"
        const val CONSUMPTION1 = "CONSUMPTION1"
        const val PRICE1 = "PRICE1"
        const val FUEL2 = "FUEL2"
        const val CONSUMPTION2 = "CONSUMPTION2"
        const val PRICE2 = "PRICE2"
    }
    
    object FuelTypes {
        const val GASOLINE = "Gasolina"
        const val ALCOHOL = "Álcool"
        const val DIESEL = "Diesel"
    }
    
    object Messages {
        const val SELECT_TWO_FUELS = "Selecione os dois tipos de combustível"
        const val REQUIRED_FIELD = "Campo obrigatório"
        const val INVALID_VALUE = "Valor inválido"
    }
    
    object InterfaceTexts {
        const val FUEL_1 = "Combustível 1"
        const val FUEL_2 = "Combustível 2"
        const val CONSUMPTION_PREFIX = "Consumo | "
    }
    
    object DefaultValues {
        const val INVALID_CONSUMPTION = 0.0
        const val INVALID_PRICE = 0.0
    }
}

