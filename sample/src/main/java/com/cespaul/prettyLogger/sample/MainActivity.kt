package com.cespaul.prettyLogger.sample

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cespaul.prettyLogger.sample.ui.PostsList
import com.cespaul.sample.R
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainActivity : AppCompatActivity() {

    private val mainViewModel by viewModel<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Tabs(
                getTabsConfig()
            )
        }
    }

    @Composable
    fun Tabs(
        configs: Map<Int, String>,
    ) {
        val selectedTabIndex = remember { mutableStateOf(0) }

        Column(modifier = Modifier.fillMaxSize()) {
            TabRow(
                selectedTabIndex.value,
                backgroundColor = Color.Blue,
                contentColor = Color.White,
                modifier = Modifier
                    .height(48.dp)
            ) {
                for ((index, text) in configs) {
                    Tab(text = { Text(text) },
                        modifier = Modifier.background(color = colorResource(id = R.color.purple_500)),
                        selected = selectedTabIndex.value == index,
                        onClick = {
                            selectedTabIndex.value = index
                        })
                }
            }
            when (selectedTabIndex.value) {
                0 -> {
                    PostsList(mainViewModel.getPosts())
                }
                1 -> {
                    // TODO: Impl sample for Ktor.
                    DummyKtor()
//                    PostsList(mainViewModel.getPostsKtor())
                }
            }
        }
    }

    @Composable
    private fun DummyKtor() {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                fontSize = 18.sp,
                text = "Not yet implemented",
            )
        }
    }

    private fun getTabsConfig(): Map<Int, String> = mapOf(
        0 to "Okhttp",
        1 to "Ktor"
    )
}