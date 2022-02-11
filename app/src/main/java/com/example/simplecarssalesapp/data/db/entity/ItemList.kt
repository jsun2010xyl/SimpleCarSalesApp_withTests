package com.example.simplecarssalesapp.data.db.entity


import com.google.gson.annotations.SerializedName

data class ItemList(
    val backfillCount: Int,
    val breadCrumbs: List<BreadCrumb>,
    val dealerNewCount: Int,
    val dealerUsedCount: Int,
    val enhancedCount: Int,
    val facetCountMap: FacetCountMap,
    val listings: List<Listings>,
    val page: Int,
    val pageSize: Int,
    val relatedLinks: RelatedLinks,
    val searchArea: SearchArea,
    val searchRequest: SearchRequest,
    val seoUrl: String,
    val totalListingCount: Int,
    val totalPageCount: Int
)