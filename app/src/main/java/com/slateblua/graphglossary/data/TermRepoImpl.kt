package com.slateblua.graphglossary.data

import com.slateblua.graphglossary.data.model.Term
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json

class TermRepoImpl : TermRepo {

    private val httpClient = HttpClient {
        install(ContentNegotiation) {
            json()
        }
    }
    override suspend fun getTerms(): List<Term> {
        return httpClient
            .get("https://slateblua.github.io/graph-glossary/glossary.json")
            .body<List<Term>>()
    }
}