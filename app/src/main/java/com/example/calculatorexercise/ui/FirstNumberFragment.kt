package com.example.calculatorexercise.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.calculatorexercise.data.Operation
import com.example.calculatorexercise.databinding.FragmentFirstNumberBinding
//import com.example.calculatorexercise.viewModel.FirstNumberViewModel

/**
 * File for [FirstNumberFragment]
 * Declaration of fragment_first_number visuals.
 *
 * @author Jose Miguel Garcia Reyes
 */
class FirstNumberFragment : Fragment() {
    private lateinit var binding: FragmentFirstNumberBinding
    //private lateinit var firstNumberViewModel: FirstNumberViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentFirstNumberBinding.inflate(layoutInflater, container, false)
        //firstNumberViewModel = FirstNumberViewModel()
        //binding.firstViewModel = firstNumberViewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var operation: Operation

        binding.operationButton.setOnClickListener {
            val number1 = binding.editTextNumber.text.toString().toFloatOrNull()

            if (number1 != null) {
                operation = Operation(firstNumber = number1)
                val directions = FirstNumberFragmentDirections.actionFirstNumberFragmentToOperationFragment(operation)
                findNavController().navigate(directions)
            }
            else {
                Toast.makeText(context, "Enter a valid number", Toast.LENGTH_SHORT).show()
            }
        }
    }

}
