package com.example.calculatorexercise.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.calculatorexercise.data.OperationType

class ResultViewModel: ViewModel() {

    fun arithmeticOperation(a: Float, b: Float, type: OperationType) : Float {
        return when (type) {
            OperationType.ADDITION -> {
                a + b
            }

            OperationType.SUBTRACTION -> {
                a - b
            }

            OperationType.MULTIPLICATION -> {
                a * b
            }

            OperationType.DIVISION -> {
                a / b
            }
        }
    }
}