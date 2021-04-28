package com.mount.domain.model

data class User(
    val name : String,
    val profileImageUrl : String,
    val isBookmark : Boolean,
    var isHeaderShow : Boolean = false
) {
    fun nameFirst() : Char = name.first().toUpperCase()
}

