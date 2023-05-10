package com.example.calculatorexercise.ui

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.calculatorexercise.databinding.FragmentSecondNumberBinding
import com.example.calculatorexercise.ui.viewmodel.SharedViewModel

/**
 * File for [SecondNumberFragment]
 * Declaration of fragment_second_number visuals.
 *
 * @author Jose Miguel Garcia Reyes
 */
class SecondNumberFragment : Fragment() {
    private lateinit var binding: FragmentSecondNumberBinding
    private val sharedViewModel: SharedViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentSecondNumberBinding.inflate(layoutInflater, container, false)

        binding.editTextNumber2.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                sharedViewModel.saveSecondNumber(s.toString())
            }

            override fun afterTextChanged(s: Editable?) {}
        })

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.firstNumberVal.text = sharedViewModel.operation.value?.firstNumber.toString()
        binding.operationVal.text = sharedViewModel.operation.value?.operationType.toString()

        binding.resultButton.setOnClickListener {

            val number2 = binding.editTextNumber2.text.toString().toFloatOrNull()

            if (number2 != null) {
                val directions =
                    SecondNumberFragmentDirections.actionSecondNumberFragmentToResultFragment()
                findNavController().navigate(directions)
            }
            else {
                Toast.makeText(context, "Enter a valid number", Toast.LENGTH_SHORT).show()
            }
        }
    }

}
