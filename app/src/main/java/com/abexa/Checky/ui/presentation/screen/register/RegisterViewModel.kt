package com.abexa.Checky.ui.presentation.screen.register


import android.util.Patterns
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor() : ViewModel() {

    private val _uiState = MutableStateFlow(RegisterUIState())


    val uiState: StateFlow<RegisterUIState> = _uiState

    fun onRegisterChanged() {
        _uiState.update { it.copy(isRegisterMode = !it.isRegisterMode, value = "",
            isRegisterEnabled = false) }
    }

    fun onValueChanged(value: String) {
        _uiState.update { it.copy(value = value) }
        verifyRegister()
    }

    private fun verifyRegister() {
        val currentValue = _uiState.value.value
        val isPhoneMode = _uiState.value.isRegisterMode

        val enabledRegister = if (isPhoneMode) {
            isPhoneValid(currentValue)
        } else {
            isEmailValid(currentValue)
        }
        _uiState.update {
            it.copy(isRegisterEnabled = enabledRegister)
        }
    }

    private fun isEmailValid (email: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }


    private fun isPhoneValid(phone: String): Boolean = phone.length >= 9 && phone.all {
        it.isDigit()

    }



}

//sealed class RegisterUIState(){
// data class PhoneMode(val phone: String)
// data class EmailMode(val email: String)
//}
data class RegisterUIState(
    val value: String = "",
    val isRegisterMode: Boolean = true,
    val isLoading: Boolean = false,
    val isRegisterEnabled: Boolean = false,
)
