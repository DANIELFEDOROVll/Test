package com.example.testtaskintern.presentation.gettingdata

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.example.testtaskintern.R
import com.example.testtaskintern.presentation.model.InformationItem
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.observeOn
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel


class GettingDataFragment : Fragment() {
    private val viewModel by viewModel<GettingDataViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_getting_data, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    private fun observe(){
        lifecycleScope.launch {
            viewModel.information.collect{
                getText(it)
            }
        }
    }

    private fun getText(information: InformationItem?){
        information.country
    }
}