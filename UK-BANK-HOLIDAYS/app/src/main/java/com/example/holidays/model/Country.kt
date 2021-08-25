package com.example.holidays.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Country(@SerializedName("england-and-wales")
                   @Expose
                   val englandAndWales : EnglandAndWales ,
                   @SerializedName("northern-ireland")
                   @Expose
                   val northernIreland: NorthernIreland,val scotland: Scotland)

