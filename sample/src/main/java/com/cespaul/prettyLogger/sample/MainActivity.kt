package com.cespaul.prettyLogger.sample

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.cespaul.prettyLogger.sample.ui.PostsList
import com.cespaul.prettylogger.sample.R


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Tabs(
                getTabsConfig()
            )
        }
    }

    private fun getTabsConfig(): Map<Int, String> = mapOf(
        0 to "Okhttp",
        1 to "Ktor"
    )

    @Composable
    fun Tabs(
        configs: Map<Int, String>,
    ) {
        val viewModel = androidx.lifecycle.viewmodel.compose.viewModel<MainViewModel>()
        val selectedTabIndex = remember { mutableStateOf(0) }

        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            TabRow(
                selectedTabIndex.value,
                backgroundColor = Color.Blue,
                contentColor = Color.White,
                modifier = Modifier.height(48.dp)
            ) {
                for ((index, text) in configs) {
                    Tab(text = { Text(text) },
                        modifier = Modifier.background(
                            color = colorResource(
                                id = R.color.purple_500
                            )
                        ),
                        selected = selectedTabIndex.value == index,
                        onClick = {
                            selectedTabIndex.value = index
                        }
                    )
                }
            }

            when (selectedTabIndex.value) {
                0 -> {
                    PostsList(viewModel.getPosts())
                }
                1 -> {
                    PostsList(viewModel.getPostsKtor())
                }
            }
        }
    }
}