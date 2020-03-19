package com.coroutineadvance.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.coroutineadvance.R
import com.coroutineadvance.databinding.FragmentSecondBinding
import com.coroutineadvance.utils.viewModelProvider
import com.coroutineadvance.viewmodel.MovieViewModel
import dagger.android.support.DaggerFragment
import javax.inject.Inject

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : DaggerFragment() {

    @Inject
    lateinit var viewmodelFactCory: ViewModelProvider.Factory
    private lateinit var viewModel: MovieViewModel

    private lateinit var binding: FragmentSecondBinding

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentSecondBinding.inflate(LayoutInflater.from(context), container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = viewModelProvider(viewmodelFactCory)

        binding.buttonSecond.setOnClickListener {
            Toast.makeText(context, "hello world", Toast.LENGTH_LONG).show()
            view.findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }
    }
}
