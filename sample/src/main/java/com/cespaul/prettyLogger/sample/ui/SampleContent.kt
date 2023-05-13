package com.cespaul.prettyLogger.sample.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.*
import com.cespaul.prettyLogger.sample.model.TestPostModel
import com.cespaul.prettyLogger.sample.model.TestPostModelItem
import kotlinx.coroutines.flow.Flow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp


@Composable
fun PostsList(postsFlow: Flow<TestPostModel>) {
    val posts = remember { mutableStateListOf<TestPostModelItem>() }
    val items by postsFlow.collectAsState(emptyList())

    LaunchedEffect(postsFlow) {
        postsFlow.collect { newItems ->
            posts.clear()
            posts.addAll(newItems)
        }
    }

    LazyColumn {
        itemsIndexed(items) { i, post ->
            ItemRow(post)
        }
    }
}

@Preview
@Composable
private fun ItemRow(
    @PreviewParameter(TestPostModelItemProvider::class) item: TestPostModelItem
) {
    Card(
        shape = RoundedCornerShape(4.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = item.title,
                style = MaterialTheme.typography.h6,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(Modifier.height(8.dp))
            Text(
                text = item.body,
                style = MaterialTheme.typography.body1,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

class TestPostModelItemProvider : PreviewParameterProvider<TestPostModelItem> {
    override val values: Sequence<TestPostModelItem>
        get() = sequence {
            TestPostModelItem(
                body = "meli",
                id = 5374,
                title = "malorum",
                userId = 7084
            )
        }
}
