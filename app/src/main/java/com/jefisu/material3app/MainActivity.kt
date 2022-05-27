package com.jefisu.material3app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.twotone.Refresh
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.jefisu.material3app.ui.theme.Material3AppTheme
import kotlin.random.Random

@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Material3AppTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {
                        SmallTopAppBar(
                            title = { Text(text = "Material 3") },
                            colors = TopAppBarDefaults.smallTopAppBarColors(
                                containerColor = MaterialTheme.colorScheme.secondaryContainer
                            )
                        )
                    },
                    floatingActionButton = {
                        FloatingActionButton(
                            onClick = { /*TODO*/ },
                            containerColor = MaterialTheme.colorScheme.tertiaryContainer
                        ) {
                            Icon(
                                imageVector = Icons.TwoTone.Refresh,
                                contentDescription = null
                            )
                        }
                    }
                ) { innerPadding ->
                    LazyColumn(
                        contentPadding = innerPadding
                    ) {
                        val photosId = (1..10).toList()
                        items(photosId) {
                            ImageCard(
                                title = "Lorem Ipsum",
                                description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. " +
                                        "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s",
                                imageUrl = "https://picsum.photos/seed/${Random.nextInt()}/300/200",
                                modifier = Modifier.padding(
                                    start = 16.dp,
                                    end = 16.dp,
                                    top = 24.dp,
                                    bottom = if (it == photosId.last()) 24.dp else 0.dp
                                )
                            )
                        }
                    }
                }
            }
        }
    }
}