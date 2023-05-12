package com.example.calculatorexercise.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.calculatorexercise.databinding.FragmentResultBinding
import com.example.calculatorexercise.ui.viewmodel.SharedViewModel

/**
 * File for [ResultFragment]
 * Declaration of fragment_result visuals.
 *
 * @author Jose Miguel Garcia Reyes
 */
class ResultFragment : Fragment() {
    private lateinit var binding: FragmentResultBinding
    private val sharedViewModel: SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentResultBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            number1Value.text = sharedViewModel.getFirstNumber().toString()
            operatorValue.text = sharedViewModel.getOperator()
            number2Value.text = sharedViewModel.getSecondNumber().toString()

            resultNumberTextView.text = sharedViewModel.getTotal().toString()

            restartButton.setOnClickListener {
                sharedViewModel.clearModel()
                val directions = ResultFragmentDirections.actionResultFragmentToFirstNumberFragment()
                findNavController().navigate(directions)
            }
        }
    }
}