package com.example.calculatorexercise.ui

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
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
    private lateinit var sharedViewModel: SharedViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?, savedInstanceState: Bundle?
    ): View {

        binding = FragmentFirstNumberBinding.inflate(layoutInflater, container, false)
        binding.editTextNumber1.addTextChangedListener(
            object : TextWatcher {
                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    //sharedViewModel.saveFirstNumber( s.toString().toFloat() )
                }
                override fun afterTextChanged(s: Editable?) {}
            }
        )
        sharedViewModel = SharedViewModel()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //val number = binding.editTextNumber1.text.toString().toFloat()

        setObservers()
        /*binding.operationButton.setOnClickListener {
            val directions = FirstNumberFragmentDirections.actionFirstNumberFragmentToOperationFragment(operation)
            findNavController().navigate(directions)
        }*/
    }

    private fun setObservers() {
        sharedViewModel.operation.observe(viewLifecycleOwner){ operation ->
            binding.editTextNumber1.setText(operation.firstNumber.toString())
        }
    }

}
