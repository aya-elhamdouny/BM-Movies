package com.example.bmmovies.domain.entities.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

open class BasePagingResponse<T> {
    @Expose
    @SerializedName("results")
    var results: List<T>? = listOf()
    @Expose
    @SerializedName("total_results")
    var totalResults: Int?=0

    @Expose
    @SerializedName("total_pages")
    var totalPages: Int?=0

    @Expose
    @SerializedName("page")
    var page: Int?=0
}