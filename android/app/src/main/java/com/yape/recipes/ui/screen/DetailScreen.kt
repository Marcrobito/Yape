package com.yape.recipes.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.yape.recipes.base.MAP_ROUTE_STRING
import com.yape.recipes.mvi.Action.LoadDetailAction
import com.yape.recipes.ui.components.InAppHyperlinkText
import com.yape.recipes.ui.components.Loader

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun DetailScreen(
    navController: NavHostController? = null,
    detailViewModel: DetailViewModel = hiltViewModel(),
    id: Int
) {
    val state = detailViewModel.state.collectAsState()
    with(state.value) {
        if (data == null && error == null) {
            detailViewModel.userAction(LoadDetailAction(id))
        }
        data?.let { recipe ->
            Box(
                modifier = Modifier
                    .fillMaxSize(),
            ) {
                Column() {

                    Box() {
                        GlideImage(
                            model = recipe.thumb,
                            contentDescription = "",
                            modifier = Modifier
                                .fillMaxHeight(0.28F)
                                .fillMaxWidth(),
                            contentScale = ContentScale.Crop
                        )
                        Box(
                            modifier = Modifier
                                .fillMaxHeight(0.28F)
                                .fillMaxWidth()
                                .background(
                                    brush = Brush.verticalGradient(
                                        colors = listOf(
                                            Color(0F, 0F, 0F, 0.2F),
                                            Color(0F, 0F, 0F, 0.8F)
                                        )
                                    )
                                )
                        )
                        IconButton(onClick = {
                            navController?.popBackStack()
                        }) {
                            Icon(
                                imageVector = Icons.Default.ArrowBack,
                                contentDescription = "",
                                tint = Color.White
                            )
                        }
                        Column(
                            horizontalAlignment = Alignment.Start,
                            modifier = Modifier
                                .fillMaxHeight(0.28F)
                                .padding(16.dp),
                            verticalArrangement = Arrangement.Bottom
                        ) {
                            Text(
                                text = recipe.meal,
                                color = Color.White,
                                fontSize = 24.sp,
                                fontWeight = FontWeight.SemiBold
                            )
                            InAppHyperlinkText(
                                fullText = "Origin: ${recipe.region}",
                                linkText = Pair(recipe.region) {
                                    navController?.navigate("$MAP_ROUTE_STRING/${recipe.region}")
                                },
                                fontSize = 18.sp
                            )
                        }
                    }
                    Column(
                        modifier = Modifier
                            .weight(weight = 1f, fill = false)
                            .padding(horizontal = 16.dp, vertical = 16.dp)
                    ) {
                        Text(
                            text = "Ingredients",
                            fontSize = 24.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                        LazyVerticalGrid(
                            columns = GridCells.Fixed(2),
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            items(data.ingredients) { ingredient ->
                                Text(
                                    modifier = Modifier
                                        .fillMaxWidth(0.45F),
                                    text = "${ingredient.ingredient} : ${ingredient.measure}"
                                )
                            }
                        }
                        Text(
                            modifier = Modifier.padding(vertical = 8.dp),
                            text = "Instructions",
                            fontSize = 24.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                        Text(
                            modifier = Modifier.verticalScroll(rememberScrollState()),
                            text = data.instructions,
                            textAlign = TextAlign.Justify
                        )
                    }

                }
            }

            if (isLoading)
                Loader()
        }
    }


}