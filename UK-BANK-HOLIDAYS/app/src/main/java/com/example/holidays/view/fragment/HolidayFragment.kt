package com.example.holidays.view.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.holidays.R
import com.example.holidays.databinding.FragmentHolidayBinding
import com.example.holidays.repository.MainRepository
import com.example.holidays.retrofit.RetrofitService
import com.example.holidays.view.adapter.MainAdapter
import com.example.holidays.viewmodel.MainViewModel
import com.example.holidays.viewmodel.MyViewModelFactory


class HolidayFragment : Fragment() {

    private val TAG = "HolidayFragment"
  //  private lateinit var binding: FragmentEnglandAndWalesBinding
  lateinit var viewModel: MainViewModel;

    private val countryEnglandAndWales = 0
    private val countryNorthernIreland = 1
    private val countryScotland = 2

    private val retrofitService = RetrofitService.getInstance()
    val adapter = MainAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var binding: FragmentHolidayBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_holiday, container, false
        )
        val view: View = binding.getRoot()
        viewModel = ViewModelProvider(this, MyViewModelFactory(MainRepository(retrofitService))).get(MainViewModel::class.java)

        val args = arguments
        val position = args?.getInt("position", 0)


        binding.recyclerview.adapter = adapter

        viewModel.countryList.observe(viewLifecycleOwner, Observer {
            Log.d(TAG, "onCreate: $it")
            when(position){
                countryEnglandAndWales-> {
                    adapter.setEventList(it.englandAndWales.events)
                    binding.country.text = it.englandAndWales.division
                }
                countryNorthernIreland->{adapter.setEventList(it.northernIreland.events)
                    binding.country.text = it.northernIreland.division
                }
                countryScotland-> {
                    adapter.setEventList(it.scotland.events)
                    binding.country.text = it.scotland.division
                }
            }
        })


        viewModel.errorMessage.observe(viewLifecycleOwner, Observer {

        })
        viewModel.getAllCountries()

        return view
    }
}
