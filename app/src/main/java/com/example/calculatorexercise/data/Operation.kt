package com.example.calculatorexercise.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Operation(
    val firstNumber: Float = 0.4f,
    val operationType: OperationType = OperationType.ADDITION,
    val secondNumber: Float = 0.4f
) : Parcelable