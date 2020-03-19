package com.coroutineadvance.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.coroutineadvance.R
import com.coroutineadvance.databinding.FragmentFirstBinding
import com.coroutineadvance.model.MovieModel
import com.coroutineadvance.network.BaseModel
import com.coroutineadvance.ui.adapter.MovieAdapter
import com.coroutineadvance.utils.viewModelProvider
import com.coroutineadvance.viewmodel.MovieViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton
import dagger.android.support.DaggerFragment
import javax.inject.Inject

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : DaggerFragment() {

    @Inject
    lateinit var viewmodelFactory: ViewModelProvider.Factory

    private lateinit var viewModel: MovieViewModel
    private lateinit var binding: FragmentFirstBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFirstBinding.inflate(LayoutInflater.from(context), container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = viewModelProvider(viewmodelFactory)
        viewModel.getMoviesList()
        viewModel.response.observe(this, Observer<BaseModel<Any>> { baseModel ->
        when(baseModel){
            is BaseModel.SUCCESS -> {
                val list=baseModel?.data as MovieModel
                binding.rv.apply{
                    layoutManager=LinearLayoutManager(context)
                    adapter=MovieAdapter(list.results)
                }
            }
        }
        })
        /*view.findViewById<FloatingActionButton>(R.id.fab).setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }*/
    }
}
