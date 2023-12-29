package com.slateblua.graphglossary.appmodule

import com.slateblua.graphglossary.data.TermRepo
import com.slateblua.graphglossary.data.TermRepoImpl
import com.slateblua.graphglossary.home.HomeScreenModel
import org.koin.dsl.module

val commonModule = module {

    single<HomeScreenModel> { HomeScreenModel(termRepo = get()) }

    single<TermRepo> { TermRepoImpl() }

}