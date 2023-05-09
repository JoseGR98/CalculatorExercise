package com.example.calculatorexercise.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.calculatorexercise.R
import com.example.calculatorexercise.data.OperationType
import com.example.calculatorexercise.databinding.FragmentResultBinding

/**
 * File for [ResultFragment]
 * Declaration of fragment_result visuals.
 *
 * @author Jose Miguel Garcia Reyes
 */
class ResultFragment : Fragment() {
    private lateinit var binding: FragmentResultBinding
    private val args by navArgs<ResultFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentResultBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val a = args.operationObject.firstNumber
        val type = args.operationObject.operationType
        val b = args.operationObject.secondNumber

        val total: Float = when (type) {
            OperationType.ADDITION -> {
                a + b
            }
            OperationType.SUBTRACTION -> {
                a - b
            }
            OperationType.MULTIPLICATON -> {
                a * b
            }
            OperationType.DIVISION -> {
                a / b
            }
        }
        binding.resultNumberTextView.text = total.toString()

        binding.restartButton.setOnClickListener {
            findNavController().navigate(R.id.action_resultFragment_to_firstNumberFragment)
        }
    }

}