package com.owenlejeune.mydex.api.pokeapi.v2.model.berry

import com.google.gson.annotations.SerializedName
import com.owenlejeune.mydex.api.pokeapi.v2.model.misc.NameAndUrl

class Berry(
    @SerializedName("firmness") val firmness: NameAndUrl,
    @SerializedName("flavors") val flavors: List<Flavor>,
    @SerializedName("growth_time") val growthTime: Int,
    @SerializedName("id") val id: Int,
    @SerializedName("item") val item: NameAndUrl,
    @SerializedName("max_harvest") val maxHarvest: Int,
    @SerializedName("name") val name: String,
    @SerializedName("natural_gift_power") val naturalGiftPower: Int,
    @SerializedName("natural_gift_type") val naturalGiftType: NameAndUrl,
    @SerializedName("size") val size: Int,
    @SerializedName("smoothness") val smoothness: Int,
    @SerializedName("soil_dryness") val soilDryness: Int
)