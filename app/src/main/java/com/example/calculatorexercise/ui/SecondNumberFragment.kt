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
            override fun beforeTextChanged(number: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun afterTextChanged(s: Editable?) {}
            override fun onTextChanged(number: CharSequence?, start: Int, before: Int, count: Int) {
                sharedViewModel.setSecondNumber(number.toString().toFloat())
            }
        })
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            firstNumberVal.text = sharedViewModel.getFirstNumber().toString()
            operationVal.text = sharedViewModel.getOperator()

            resultButton.setOnClickListener {
                if (editTextNumber2.text.isNotEmpty()) {
                    val directions = SecondNumberFragmentDirections.actionSecondNumberFragmentToResultFragment()
                    findNavController().navigate(directions)
                }
                else {
                    Toast.makeText(context,"Add a valid value",Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

}
