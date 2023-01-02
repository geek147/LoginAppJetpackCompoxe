package com.codeonwheels.loginapp.domain.model


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class SaltUserModel(
    @SerializedName("data")
    val `data`: List<Data>,
    @SerializedName("page")
    val page: Int,
    @SerializedName("per_page")
    val perPage: Int,
    @SerializedName("support")
    val support: Support,
    @SerializedName("total")
    val total: Int,
    @SerializedName("total_pages")
    val totalPages: Int
) {
    @Keep
    data class Data(
        @SerializedName("color")
        val color: String,
        @SerializedName("id")
        val id: Int,
        @SerializedName("name")
        val name: String,
        @SerializedName("pantone_value")
        val pantoneValue: String,
        @SerializedName("year")
        val year: Int
    )

    @Keep
    data class Support(
        @SerializedName("text")
        val text: String,
        @SerializedName("url")
        val url: String
    )
}