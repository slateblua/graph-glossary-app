package com.slateblua.graphglossary.data

import com.slateblua.graphglossary.data.model.Term

interface TermRepo {
    suspend fun getTerms(): List<Term>
}