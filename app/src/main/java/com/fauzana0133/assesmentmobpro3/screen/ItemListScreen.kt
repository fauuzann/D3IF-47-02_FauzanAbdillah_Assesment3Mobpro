package com.fauzana0133.assesmentmobpro3.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.fauzana0133.assesmentmobpro3.viewmodel.ItemViewModel

@Composable
fun ItemListScreen(viewModel: ItemViewModel) {
    val items = viewModel.itemList
    val loading = viewModel.isLoading

    if (loading) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator()
        }
    } else {
        LazyColumn {
            items(items) { item ->
                Card(modifier = Modifier.padding(8.dp)) {
                    Column(modifier = Modifier.padding(8.dp)) {
                        AsyncImage(
                            model = item.imageUrl,
                            contentDescription = null,
                            modifier = Modifier.size(200.dp)
                        )
                        Text(item.name, style = MaterialTheme.typography.titleLarge)
                        Text(item.description)
                    }
                }
            }
        }
    }
}
