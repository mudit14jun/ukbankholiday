package com.example.holidays.viewmodel


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.holidays.model.Country
import com.example.holidays.repository.MainRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel constructor(private val repository: MainRepository)  : ViewModel() {

    val countryList = MutableLiveData<Country>()
    val errorMessage = MutableLiveData<String>()

    fun getAllCountries() {

        val response = repository.getAllCountries()
        response.enqueue(object : Callback<Country> {
            override fun onResponse(call: Call<Country>, response: Response<Country>) {
                countryList.postValue(response.body())
            }

            override fun onFailure(call: Call<Country>, t: Throwable) {
                errorMessage.postValue(t.message)
            }
        })
    }
}