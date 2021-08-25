package com.example.holidays.repository

import com.example.holidays.retrofit.RetrofitService

class MainRepository constructor(private val retrofitService: RetrofitService) {

    fun getAllCountries() = retrofitService.getAllCountries()
}