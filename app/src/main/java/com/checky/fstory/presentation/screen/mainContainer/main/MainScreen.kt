package com.checky.fstory.presentation.screen.mainContainer.main

import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import com.checky.fstory.R
import com.checky.fstory.presentation.component.DropDownMenuMain
import com.checky.fstory.domain.entity.ProductEntity
import com.checky.fstory.presentation.component.AppTopBarDef
import com.checky.fstory.presentation.component.GradientBackground
import com.checky.fstory.presentation.theme.ColorFamily
import com.checky.fstory.presentation.theme.unspecified_scheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(mainViewModel: MainViewModel = hiltViewModel(), navigateToProfile: () -> Unit, bottomPadding: Dp = 0.dp,) {

    val uiState by mainViewModel.uiState.collectAsStateWithLifecycle()

    GradientBackground {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            contentWindowInsets = WindowInsets(0, 0, 0, 0),
            topBar = {
                AppTopBarDef(
                    title = stringResource(R.string.app_name),
                    subtitle = {
                        Icon(
                            painter = painterResource(R.drawable.image_icon_default),
                            contentDescription = null,
                            modifier = Modifier.size(70.dp),
                            tint = unspecified_scheme.color
                        )
                    },
                    showBackButton = false,
                    actions = {
                        IconButton(onClick = { navigateToProfile() }) {
                            Icon(
                                imageVector = Icons.Default.ShoppingCart,
                                contentDescription = null
                            )
                        }

                    }
                )
            },
            containerColor = Color.Transparent
        ) { innerPadding ->
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding) // Usa el padding de su propia TopBar
                    .padding(bottom = bottomPadding) // Usa el padding de la BottomBar del padre
                    .padding(horizontal = 20.dp),
            ) {
                items(uiState.productList) { product ->
                    ItemGrid(product)
                }
            }

//            LazyColumn(
//                modifier = Modifier
//                    .padding(20.dp)
//                    .padding(padding),
//                horizontalAlignment = Alignment.CenterHorizontally
//            ) {
//                item {
//                    Text(
//                        text = stringResource(R.string.main_screen_button_profile),
//                        modifier = Modifier.padding(),
//                        fontSize = 15.sp,
//                        color = MaterialTheme.colorScheme.onPrimaryContainer
//                    )
//                    Icon(
//                        imageVector = Icons.Default.Person,
//                        contentDescription = null,
//                        modifier = Modifier.size(50.dp),
//                        tint = MaterialTheme.colorScheme.onBackground
//                    )
//                }
//            }
        }
    }
}

@Composable
fun ItemGrid(product: ProductEntity) {
    Card(
        modifier = Modifier.padding(8.dp).fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
    ) {
        Column(
            modifier = Modifier.padding(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AsyncImage(
                model = product.image,
                contentDescription = null,
                modifier = Modifier.size(120.dp)
            )
            Text(
                text = product.title,
                maxLines = 1,
                style = MaterialTheme.typography.bodyMedium
            )
            Text(
                text = "$${product.price}",
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )
        }
    }
}
