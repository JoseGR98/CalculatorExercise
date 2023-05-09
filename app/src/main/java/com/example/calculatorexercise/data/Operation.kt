package com.example.calculatorexercise.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Operation(
    val firstNumber: Float = 0.0f,
    val operationType: OperationType = OperationType.ADDITION,
    val secondNumber: Float = 0.0f
) : Parcelable