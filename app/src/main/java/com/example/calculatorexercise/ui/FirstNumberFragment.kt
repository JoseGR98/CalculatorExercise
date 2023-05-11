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
import com.example.calculatorexercise.databinding.FragmentFirstNumberBinding
import com.example.calculatorexercise.ui.viewmodel.SharedViewModel

/**
 * File for [FirstNumberFragment]
 * Declaration of fragment_first_number visuals.
 *
 * @author Jose Miguel Garcia Reyes
 */
class FirstNumberFragment : Fragment() {
    private lateinit var binding: FragmentFirstNumberBinding
    private val sharedViewModel: SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentFirstNumberBinding.inflate(layoutInflater, container, false)
        binding.editTextNumber1.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(number: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun afterTextChanged(number: Editable?) {}
            override fun onTextChanged(number: CharSequence?, start: Int, before: Int, count: Int) {
                sharedViewModel.setFirstNumber(number.toString().toFloat())
            }
        })
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            operationButton.setOnClickListener {
                if (editTextNumber1.text.isNotEmpty()) {
                    val directions = FirstNumberFragmentDirections.actionFirstNumberFragmentToOperationFragment()
                    findNavController().navigate(directions)
                }
                else {
                    Toast.makeText(context,"Add a valid value",Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
