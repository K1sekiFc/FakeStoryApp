package com.checky.fstory.presentation.screen.register

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.checky.fstory.R
import com.checky.fstory.presentation.component.AppTopBarDef
import com.checky.fstory.presentation.component.GradientBackground
import com.checky.fstory.theme.defaultOutlinedTextFieldColors


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterScreen(registerViewModel: RegisterViewModel = hiltViewModel(), navigateBack: () -> Unit) {

    val uiState by registerViewModel.uiState.collectAsStateWithLifecycle()

    val title: String
    val subtitle: String
    val label: String
    val body: String
    val changeModeTitle: String
    val keyboardType : KeyboardType

    when (uiState.isRegisterMode) {
        true ->{
            title = stringResource(R.string.register_screen_title_phone)
            subtitle = stringResource(R.string.register_screen_subtitle_phone)
            label  = stringResource(R.string.register_screen_label_phone)
            body = stringResource(R.string.register_screen_body_phone)
            changeModeTitle = stringResource(R.string.register_screen_change_mode)
            keyboardType = KeyboardType.Number
        }
        false ->{
            title = stringResource(R.string.register_screen_title_email)
            subtitle = stringResource(R.string.register_screen_subtitle_email)
            label  = stringResource(R.string.register_screen_label_email)
            body = stringResource(R.string.register_screen_body_email)
            changeModeTitle = stringResource(R.string.register_screen_change_mode)
            keyboardType = KeyboardType.Email

        }
    }
    GradientBackground {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = {
                AppTopBarDef(
                    title = "", subtitle = { stringResource(R.string.register_screen_subtitle_appbar) },showBackButton = true,
                    onBackClick = navigateBack
                )
            },
            containerColor = Color.Transparent
        ) { padding ->
            Column(
                modifier = Modifier.padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.weight(0.025f))
                    Text(
                        text = title,
                        modifier = Modifier
                            .padding(bottom = 10.dp)
                            .fillMaxWidth(),
                        color = MaterialTheme.colorScheme.onBackground,
                        style = MaterialTheme.typography.titleLarge,
                        fontSize = 28.sp,
                        fontWeight = androidx.compose.ui.text.font.FontWeight.Bold
                    )
                Text(
                    text = subtitle,
                    modifier = Modifier
                        .padding(bottom = 5.dp)
                        .fillMaxWidth(),
                    color = MaterialTheme.colorScheme.onBackground,
                    style = MaterialTheme.typography.bodySmall,
                    fontSize = 15.sp,
                    fontWeight = androidx.compose.ui.text.font.FontWeight.Normal
                )

                OutlinedTextField(
                    value = uiState.value,
                    onValueChange = {registerViewModel.onValueChanged(it)},
                    keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
                    modifier = Modifier
                        .fillMaxWidth(),
                    singleLine = true,
                    label = { Text(text = label) },
                    colors = defaultOutlinedTextFieldColors(),
                    shape = RoundedCornerShape(10.dp)
                )
                Text(
                    text = body,
                    modifier = Modifier
                        .padding(bottom = 5.dp)
                        .fillMaxWidth(),
                    color = MaterialTheme.colorScheme.onBackground,
                    style = MaterialTheme.typography.bodySmall,
                    fontSize = 13.sp,
                    fontWeight = androidx.compose.ui.text.font.FontWeight.Light
                )
                Button(
                    onClick = {},
                    enabled = uiState.isRegisterEnabled,
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonColors(
                        containerColor = MaterialTheme.colorScheme.primaryContainer,
                        contentColor =MaterialTheme.colorScheme.onPrimaryContainer ,
                        disabledContainerColor =MaterialTheme.colorScheme.tertiaryContainer,
                        disabledContentColor = MaterialTheme.colorScheme.errorContainer,

                        ),
                    ) {
                    Text(
                        text=stringResource(R.string.Next),
                        modifier = Modifier.padding(),
                        fontSize = 15.sp,
                        color = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                }
                Button(
                    onClick = { registerViewModel.onRegisterChanged()},
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonColors(
                        containerColor = MaterialTheme.colorScheme.primaryContainer,
                        contentColor =MaterialTheme.colorScheme.onPrimaryContainer ,
                        disabledContainerColor =MaterialTheme.colorScheme.tertiaryContainer,
                        disabledContentColor = MaterialTheme.colorScheme.errorContainer,
                        ),

                    ) {
                    Text(
                        text = changeModeTitle,
                        modifier = Modifier.padding(),
                        fontSize = 15.sp,
                        color = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                }
                Spacer(modifier = Modifier.weight(0.1f))
                TextButton(onClick = {}) {
                    Text(stringResource(R.string.register_screen_textButton_bottom))
                }
            }
        }
    }
}


