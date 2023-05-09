package com.example.calculatorexercise.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.calculatorexercise.data.OperationType
import com.example.calculatorexercise.databinding.FragmentOperationBinding

/**
 * File for [OperationFragment]
 * Declaration of fragment_operation visuals.
 *
 * @author Jose Miguel Garcia Reyes
 */
class OperationFragment : Fragment() {
    private lateinit var binding: FragmentOperationBinding
    private val args by navArgs<OperationFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentOperationBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.fistNumberValue.text = args.operationObject.firstNumber.toString()

        binding.addButton.setOnClickListener {
            navigateToSecondNumberFragment(OperationType.ADDITION)
        }
        binding.minusButton.setOnClickListener {
            navigateToSecondNumberFragment(OperationType.SUBTRACTION)
        }
        binding.multiplicationButton.setOnClickListener {
            navigateToSecondNumberFragment(OperationType.MULTIPLICATON)
        }
        binding.divisionButton.setOnClickListener {
            navigateToSecondNumberFragment(OperationType.DIVISION)
        }
    }

    private fun navigateToSecondNumberFragment(type: OperationType) {
        val directions =
            OperationFragmentDirections.actionOperationFragmentToSecondNumberFragment(args.operationObject.copy(operationType = type))
        findNavController().navigate(directions)
    }

}
