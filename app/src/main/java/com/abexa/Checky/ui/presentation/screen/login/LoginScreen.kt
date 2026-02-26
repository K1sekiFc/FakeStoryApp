package com.abexa.Checky.ui.presentation.screen.login


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import androidx.compose.ui.graphics.Color

import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation

import com.abexa.Checky.R

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.abexa.Checky.ui.presentation.component.AppTopBarDef
import com.abexa.Checky.ui.presentation.component.GradientBackground
import com.abexa.Checky.ui.presentation.theme.White40
import com.abexa.Checky.ui.theme.defaultOutlinedTextFieldColors

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(loginViewModel: LoginViewModel = hiltViewModel(),navigateToMain: () -> Unit, navigateToRegister: () -> Unit, navigateBack:()-> Unit) {
//    var user by remember { mutableStateOf("") }
//    var password by remember { mutableStateOf("") }
    val uiState by loginViewModel.uiState.collectAsStateWithLifecycle()

    var passwordHidden by remember { mutableStateOf(true) }
    LaunchedEffect(Unit) {
        loginViewModel.navigationEvent.collect {
            navigateToMain()
        }
    }


    GradientBackground {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = { AppTopBarDef(title = stringResource(R.string.login_screen_title_appbar), showBackButton = true,onBackClick = navigateBack, subtitle = {}) },
            containerColor = Color.Transparent
        ) { padding ->
            Column(
                modifier = Modifier.padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.weight(0.4f))
                Image(
                    modifier = Modifier.size(180.dp),
                    painter = painterResource(R.drawable.icon_def_1),
                    contentDescription = null
                )

                Spacer(modifier = Modifier.weight(0.1f))
                Text(
                    text = stringResource(R.string.login_screen_title),
                    modifier = Modifier.padding(bottom = 5.dp),
                    color = MaterialTheme.colorScheme.onBackground,
                    style = MaterialTheme.typography.titleLarge,
                    fontSize = 40.sp,
                    fontWeight = androidx.compose.ui.text.font.FontWeight.Bold
                )

                OutlinedTextField(
                    value = uiState.user,
                    onValueChange = { loginViewModel.onUserChanged(it) },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 15.dp),
                    label = { Text(text = stringResource(R.string.login_screen_label_user)) },
                    singleLine = true,
                    colors = defaultOutlinedTextFieldColors(),
                    shape = RoundedCornerShape(10.dp)
                )

                Spacer(modifier = Modifier.height(7.dp))

                OutlinedTextField(
                    value = uiState.password,
                    onValueChange = { loginViewModel.onPasswordChanged(it) },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 15.dp),
                    visualTransformation =  if (passwordHidden)
                        PasswordVisualTransformation()
                    else
                        VisualTransformation.None,
                    trailingIcon = {
                        IconButton(onClick = { passwordHidden = !passwordHidden }) {
                            Icon(
                                imageVector = if (passwordHidden)
                                    Icons.Default.Visibility
                                else
                                    Icons.Default.VisibilityOff,
                                contentDescription = null
                            )
                        }
                    },

                    singleLine = true,
                    label = { Text(text = stringResource(R.string.login_screen_label_password)) },
                    colors = defaultOutlinedTextFieldColors(),
                    shape = RoundedCornerShape(10.dp)
                )

                Spacer(modifier = Modifier.height(20.dp))

                Button(
                    onClick = {loginViewModel.onClickSelected()},
                    enabled = uiState.isLoginEnabled,
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonColors(
                        containerColor = MaterialTheme.colorScheme.primaryContainer,
                        contentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                        disabledContainerColor =MaterialTheme.colorScheme.tertiaryContainer,
                        disabledContentColor = MaterialTheme.colorScheme.errorContainer,
                        ),
                    border = BorderStroke(
                        width = 2.dp,
                        color = White40,
                    )
                    ) {
                    Text(
                        text = stringResource(R.string.login_screen_button_sesion),
                        modifier = Modifier.padding(),
                        fontSize = 15.sp,
                        color = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                }

                TextButton(onClick = {}) {
                    Text(stringResource(R.string.login_screen_textButton_password_lose))
                }

                Spacer(modifier = Modifier.weight(1f))

                Button(
                    onClick = { navigateToRegister() },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp),
                    colors = ButtonColors(
                        containerColor = MaterialTheme.colorScheme.primaryContainer,
                        contentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                        disabledContainerColor =MaterialTheme.colorScheme.tertiaryContainer,
                        disabledContentColor = MaterialTheme.colorScheme.errorContainer,
                    ),
                    border = BorderStroke(
                        width = 2.dp,
                        color = White40,
                    )
                ) {
                    Text(
                        text=stringResource(R.string.login_screen_button_register),
                        modifier = Modifier.padding(),
                        fontSize = 15.sp,
                        color= MaterialTheme.colorScheme.onPrimaryContainer
                    )
                }
            }
        }
    }
}

