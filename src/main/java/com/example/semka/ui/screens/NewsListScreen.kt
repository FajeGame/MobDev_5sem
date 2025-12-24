package com.example.semka.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.semka.data.model.Article
import com.example.semka.viewmodel.NewsViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewsListScreen(
    onArticleClick: (Int) -> Unit,
    viewModel: NewsViewModel = viewModel()
) {
    val uiState by viewModel.uiState.collectAsState()

    Scaffold(
        topBar = { TopAppBar(title = { Text("Космические новости") }) }
    ) { padding ->
        LazyColumn(
            modifier = Modifier.padding(padding),
            contentPadding = PaddingValues(16.dp)
        ) {
            items(uiState.articles) { article ->
                ArticleItem(
                    article = article,
                    onClick = { onArticleClick(article.id) }
                )
                Spacer(modifier = Modifier.height(12.dp))
            }
        }
    }
}

@Composable
fun ArticleItem(article: Article, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
    ) {
        Column(Modifier.padding(12.dp)) {
            Text(text = article.title, style = MaterialTheme.typography.titleMedium)
            Text(text = article.summary, style = MaterialTheme.typography.bodyMedium)
            Text(text = article.publishedAt.toString(), style = MaterialTheme.typography.labelSmall)
        }
    }
}