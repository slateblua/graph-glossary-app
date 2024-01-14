package com.slateblua.graphglossary.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.getScreenModel
import com.slateblua.graphglossary.component.TermCard
import org.koin.androidx.compose.KoinAndroidContext
import org.koin.core.annotation.KoinExperimentalAPI

class HomeScreen : Screen {
    @OptIn(KoinExperimentalAPI::class)
    @Composable
    override fun Content() {
        KoinAndroidContext() {
            HomeScreenContent()
        }
    }
    @Composable
    fun HomeScreenContent(screenModel: HomeScreenModel = getScreenModel()) {

        val state = screenModel.state.collectAsState()

        Scaffold { paddingValues ->
            Column(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxWidth()
            ) {
                TextField(
                    value = state.value.userMessage,
                    onValueChange = { screenModel.searchTerm(it) },
                    label = { Text("Search") },
                    leadingIcon = { Icon(Icons.Filled.Search, contentDescription = "Search") },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth(),
                )
                LazyColumn {
                    items(state.value.terms) { term ->
                        TermCard(term)
                    }
                }
            }
        }
    }
}