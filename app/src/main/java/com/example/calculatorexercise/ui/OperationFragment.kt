package com.example.calculatorexercise.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.calculatorexercise.data.OperationType
import com.example.calculatorexercise.databinding.FragmentOperationBinding
import com.example.calculatorexercise.ui.viewmodel.SharedViewModel

/**
 * File for [OperationFragment]
 * Declaration of fragment_operation visuals.
 *
 * @author Jose Miguel Garcia Reyes
 */
class OperationFragment : Fragment() {
    private lateinit var binding: FragmentOperationBinding
    private val sharedViewModel: SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentOperationBinding.inflate(layoutInflater, container, false)

        with(binding) {
            addButton.setOnClickListener {
                navigateToSecondNumberFragment(OperationType.ADDITION)
            }
            minusButton.setOnClickListener {
                navigateToSecondNumberFragment(OperationType.SUBTRACTION)
            }
            multiplicationButton.setOnClickListener {
                navigateToSecondNumberFragment(OperationType.MULTIPLICATION)
            }
            divisionButton.setOnClickListener {
                navigateToSecondNumberFragment(OperationType.DIVISION)
            }
            return root
        }


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.fistNumberValue.text = sharedViewModel.operation.value?.firstNumber.toString()

    }

    private fun navigateToSecondNumberFragment(type: OperationType) {
        sharedViewModel.saveOperator(type)
        val directions = OperationFragmentDirections.actionOperationFragmentToSecondNumberFragment()
        findNavController().navigate(directions)
    }

}
