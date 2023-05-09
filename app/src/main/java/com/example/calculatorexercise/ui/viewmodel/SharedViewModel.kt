package com.example.calculatorexercise.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.calculatorexercise.data.Operation
import com.example.calculatorexercise.data.OperationType

class SharedViewModel: ViewModel() {
    private val _operation = MutableLiveData(Operation())

    val operation : LiveData<Operation>
        get() = _operation

    fun saveFirstNumber(number: Float) {
        _operation.value = _operation.value?.copy(firstNumber = number)
    }
    fun saveOperator(operator: OperationType) {
        _operation.value = _operation.value?.copy(operationType = operator)
    }
    fun saveSecondNumber(number: Float) {
        _operation.value = _operation.value?.copy(secondNumber = number)
    }
    fun notNullFirstNumberValidation(): Boolean {
        return _operation.value?.firstNumber.toString().isNotEmpty()
    }
    fun notNullSecondNumberValidation(): Boolean {
        return _operation.value?.secondNumber.toString().isNotEmpty()
    }

}
