package com.example.semka.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.semka.data.model.Article

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ArticleDetailScreen(article: Article) {
    Scaffold(
        topBar = { TopAppBar(title = { Text("Статья") }) }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp)
        ) {
            Text(text = article.title, style = MaterialTheme.typography.headlineSmall)
            Spacer(modifier = Modifier.height(12.dp))
            Text(text = article.summary, style = MaterialTheme.typography.bodyLarge)
            Spacer(modifier = Modifier.height(16.dp))
            OutlinedButton(onClick = { /* открыть в браузере */ }) {
                Text("Читать оригинал")
            }
        }
    }
}