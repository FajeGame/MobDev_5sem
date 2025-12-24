package com.example.semka

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.semka.ui.screens.ArticleDetailScreen
import com.example.semka.ui.screens.NewsListScreen
import com.example.semka.viewmodel.NewsViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp()
        }
    }
}

@Composable
fun MyApp() {
    val viewModel: NewsViewModel = viewModel()
    val navController = rememberNavController()

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        NavHost(
            navController = navController,
            startDestination = "news"
        ) {
            composable("news") {
                NewsListScreen(
                    onArticleClick = { articleId ->
                        navController.navigate("article/$articleId")
                    },
                    viewModel = viewModel
                )
            }
            composable("article/{articleId}") { backStackEntry ->
                val articleId = backStackEntry.arguments?.getString("articleId")?.toIntOrNull()
                if (articleId != null) {
                    val article = viewModel.uiState.value.articles.find { it.id == articleId }
                    if (article != null) {
                        ArticleDetailScreen(article)
                    }
                }
            }
        }
    }
}