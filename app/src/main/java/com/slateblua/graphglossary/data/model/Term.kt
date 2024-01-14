package com.slateblua.graphglossary.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Term(
    val term: String,
    val definition: String
)
