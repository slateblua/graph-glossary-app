package com.slateblua.graphglossary.data

import com.slateblua.graphglossary.data.model.Term
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class TermRepoImpl(private val httpClient: HttpClient) : TermRepo {
    override suspend fun getTerms(): List<Term> {
        return httpClient
            .get("https://slateblua.github.io/graph-glossary/glossary.json")
            .body<List<Term>>()
    }
}