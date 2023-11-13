package com.example.kotlin101

import com.google.gson.annotations.SerializedName
//Les datas class récupèrent et stockent les données souhaités de la base de donnée
data class Country (
    @SerializedName("name") val name: Name,
    @SerializedName("flag") val flag: String,
    @SerializedName("capital") val capital: List<String>?,
    @SerializedName("continents") val continents: List<String>,
    @SerializedName("languages") val languages: Map<String, String>?,
    @SerializedName("currencies") val currencies: Map<String, Currency>,
    @SerializedName("timezones")val timezones: List<String>,
):java.io.Serializable
//les données de l'API ne peuvent etre récuperer qu'avec ces datas class.
data class Name(
    @SerializedName("common") val common: String,
    @SerializedName("official")val official: String,
):java.io.Serializable

data class Currency(
    @SerializedName("name") val name: String,
    @SerializedName("symbol")val symbol: String,
):java.io.Serializable
