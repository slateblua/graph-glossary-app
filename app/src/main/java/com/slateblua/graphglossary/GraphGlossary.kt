package com.slateblua.graphglossary

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import cafe.adriel.voyager.navigator.Navigator
import com.slateblua.graphglossary.home.HomeScreen

class GraphGlossary : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Navigator(HomeScreen())
        }
    }
}
