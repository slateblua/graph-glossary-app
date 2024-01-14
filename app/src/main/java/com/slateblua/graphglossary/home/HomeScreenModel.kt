package com.slateblua.graphglossary.home

import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import com.slateblua.graphglossary.data.model.Term
import com.slateblua.graphglossary.data.TermRepo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
class HomeScreenModel(val termRepo: TermRepo) : ScreenModel {

    private val _state = MutableStateFlow(HomeState())
    val state = _state.asStateFlow()

    init {
        updateTerms()
    }
    private fun updateTerms() {
        screenModelScope.launch {
            val terms = termRepo.getTerms()
            _state.update {
                it.copy(terms = terms)
            }
        }
    }

    fun searchTerm(query: String) {
        screenModelScope.launch {
            setUserMessage(query)
            val terms = termRepo.getTerms().filter { term ->
                term.term.contains(query, ignoreCase = true) }
            _state.update {
                it.copy(terms = terms)
            }
        }
    }

    private fun setUserMessage(query: String) {
        _state.update {
            it.copy(userMessage = query)
        }
    }
    data class HomeState(
        val terms: List<Term> = emptyList(),
        val userMessage: String = "",
    )
}


