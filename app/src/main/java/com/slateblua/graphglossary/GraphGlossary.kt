package com.slateblua.graphglossary

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import cafe.adriel.voyager.navigator.Navigator
import com.slateblua.graphglossary.appmodule.commonModule
import com.slateblua.graphglossary.home.HomeScreen
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class GraphGlossary : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startKoin {
            modules(commonModule)
            androidContext(this@GraphGlossary)
        }.koin
        setContent {
            Navigator(HomeScreen())
        }
    }
}
