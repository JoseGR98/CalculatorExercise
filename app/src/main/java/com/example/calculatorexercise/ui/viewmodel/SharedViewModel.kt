package com.example.calculatorexercise.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.calculatorexercise.data.Operation
import com.example.calculatorexercise.data.OperationType

class SharedViewModel: ViewModel() {
    private val _operation = MutableLiveData(Operation(0.0F,OperationType.ADDITION,0.0F))
    val operation : LiveData<Operation>
        get() = _operation

    fun setFirstNumber(number: Float) {
        if (!number.isNaN()) {
            _operation.value = _operation.value?.copy(firstNumber = number)
        }
    }
    fun setOperator(operator: OperationType) {
        _operation.value = _operation.value?.copy(operationType = operator)
    }
    fun setSecondNumber(number: Float) {
        if (!number.isNaN()) {
            _operation.value = _operation.value?.copy(secondNumber = number)
        }
    }

    fun getFirstNumber(): Float? {
        return _operation.value?.firstNumber
    }
    fun getOperator():String {
        return _operation.value?.operationType.toString()
    }
    fun getSecondNumber(): Float? {
        return _operation.value?.secondNumber
    }

    fun getTotal() : Float? {
        val operation = operation.value ?: return null
        return when (operation.operationType) {
            OperationType.ADDITION -> operation.firstNumber + operation.secondNumber
            OperationType.SUBTRACTION -> operation.firstNumber - operation.secondNumber
            OperationType.MULTIPLICATION -> operation.firstNumber * operation.secondNumber
            OperationType.DIVISION -> operation.firstNumber / operation.secondNumber
        }
    }

    fun clearModel() {
        _operation.value = Operation()
    }

}
