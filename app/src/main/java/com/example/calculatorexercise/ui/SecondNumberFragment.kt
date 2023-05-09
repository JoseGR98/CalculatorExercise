package com.example.calculatorexercise.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.calculatorexercise.databinding.FragmentSecondNumberBinding

/**
 * File for [SecondNumberFragment]
 * Declaration of fragment_second_number visuals.
 *
 * @author Jose Miguel Garcia Reyes
 */
class SecondNumberFragment : Fragment() {
    private lateinit var binding: FragmentSecondNumberBinding
    private val args by navArgs<SecondNumberFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentSecondNumberBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.firstNumberVal.text = args.operationObject.firstNumber.toString()
        binding.operationVal.text = args.operationObject.operationType.toString()

        binding.resultButton.setOnClickListener {
            val number2 = binding.editTextNumber2.text.toString().toFloatOrNull()

            if (number2 != null) {
                val directions =
                    SecondNumberFragmentDirections.actionSecondNumberFragmentToResultFragment(
                        args.operationObject.copy(secondNumber = number2)
                    )
                findNavController().navigate(directions)
            }
            else {
                Toast.makeText(context, "Enter a valid number", Toast.LENGTH_SHORT).show()
            }
        }
    }

}
