package com.slateblua.graphglossary.appmodule

import com.slateblua.graphglossary.data.TermRepo
import com.slateblua.graphglossary.data.TermRepoImpl
import com.slateblua.graphglossary.home.HomeScreenModel
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import org.koin.dsl.module

val commonModule = module {

    single<HomeScreenModel> { HomeScreenModel(termRepo = get()) }

    single<TermRepo> { TermRepoImpl(httpClient = get()) }

    single {
        HttpClient() {
            install(ContentNegotiation) {
                json()
            }
        }
    }
}