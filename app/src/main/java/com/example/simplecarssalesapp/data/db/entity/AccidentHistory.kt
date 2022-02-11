package com.example.simplecarssalesapp.data.db.entity


import com.google.gson.annotations.SerializedName

data class AccidentHistory(
    val accidentSummary: List<String>,
    val icon: String,
    val iconUrl: String,
    val text: String
)