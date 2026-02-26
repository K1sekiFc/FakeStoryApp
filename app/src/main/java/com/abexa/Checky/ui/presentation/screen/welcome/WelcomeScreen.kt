package com.abexa.Checky.ui.presentation.screen.welcome

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.abexa.Checky.R
import com.abexa.Checky.ui.presentation.component.ImageFadeBackground

@Composable
fun WelcomeScreen(
    welcomeViewModel: WelcomeViewModel = hiltViewModel(),
    navigateToLogin: () -> Unit
) {
    val uiState by welcomeViewModel.uiState.collectAsStateWithLifecycle()

    ImageFadeBackground(imageRes = R.drawable.window_screen) {
        Scaffold(
            containerColor = Color.Transparent
        ) { padding ->

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(50.dp),
                verticalArrangement = Arrangement.Bottom
            ) {

                Text(
                    text = "Checky",
                    color = Color.White,
                    fontSize = 32.sp
                )

                Spacer(modifier = Modifier.height(20.dp))

                Button(
                    onClick = { navigateToLogin() },
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.primaryContainer,
                        contentColor = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                ) {
                    Text(
                        text = stringResource(R.string.welcome_screen_button_welcome),
                        fontSize = 20.sp
                    )
                }

                Spacer(modifier = Modifier.height(40.dp))
            }
        }
    }
//    GradientBackground {
//        Scaffold(
//            modifier = Modifier.fillMaxSize(),
////            topBar = {
////                AppTopBarDef(title = "Checky", navigateBack = navigateBack, subtitle = "") },
////        bottomBar= AppBottomBar(),
//            containerColor = Color.Transparent
//        ) { padding ->
//            Column(
//                modifier = Modifier.padding(50.dp),
//                verticalArrangement = Arrangement.Center
//            ) {
//                Spacer(Modifier.weight(0.9f))
//                Button(
//                    onClick = {navigateToLogin()},
//                    modifier = Modifier.fillMaxWidth(),
//                    colors = ButtonColors(
//                        containerColor = MaterialTheme.colorScheme.primaryContainer,
//                        contentColor = MaterialTheme.colorScheme.onPrimaryContainer ,
//                        disabledContainerColor =MaterialTheme.colorScheme.tertiaryContainer,
//                        disabledContentColor = MaterialTheme.colorScheme.errorContainer,
//
//                        ),
//                    ) {
//                    Text(
//                        text=stringResource(R.string.welcome_screen_button_welcome),
//                        modifier = Modifier.padding(),
//                        fontSize = 20.sp,
//                        color = MaterialTheme.colorScheme.onPrimaryContainer
//                    )
//                }
//                Spacer(Modifier.weight(0.4f))
//            }
//        }
//    }

}