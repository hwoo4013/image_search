package com.example.image_search_0201.model

data class SearchItemModel (
    var title: String,
    var dateTime: String,
    var url: String,
    var isLike: Boolean = false
)