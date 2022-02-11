package com.example.simplecarssalesapp.data.db.entity


import com.google.gson.annotations.SerializedName

data class Dealer(
    val address: String,
    val backfill: Boolean,
    val carfaxId: String,
    val cfxMicrositeUrl: String,
    val city: String,
    val dealerAverageRating: Double,
    val dealerInventoryUrl: String,
    val dealerLeadType: String,
    val dealerReviewComments: String,
    val dealerReviewCount: Int,
    val dealerReviewDate: String,
    val dealerReviewRating: Int,
    val dealerReviewReviewer: String,
    val dealerReviewTitle: String,
    val latitude: String,
    val longitude: String,
    val name: String,
    val onlineOnly: Boolean,
    val phone: String,
    val state: String,
    val zip: String
)