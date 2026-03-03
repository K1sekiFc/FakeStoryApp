package com.checky.fstory.ui.presentation.screen.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.checky.fstory.ui.domain.usecase.UsecaseLogin
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject



@HiltViewModel
class LoginViewModel @Inject constructor(val login: UsecaseLogin) : ViewModel() {

    private val _uiState = MutableStateFlow(LoginUiState())
    val uiState: StateFlow<LoginUiState> = _uiState

    private val _navigationEvent = MutableSharedFlow<Unit>()
    val navigationEvent = _navigationEvent.asSharedFlow()



    fun onUserChanged(user: String) {
        _uiState.update { state -> state.copy(user = user) }
        verifyLogin()
    }

    fun onPasswordChanged(password: String) {
        _uiState.update {
            it.copy(password = password)
        }
        verifyLogin()
    }

    fun onClickSelected() {


        viewModelScope.launch {

            _uiState.update { it.copy(isLoading = true) }

            val response = withContext(Dispatchers.IO) {
                login(_uiState.value.user, _uiState.value.password)
            }

            println("LOGIN RESPONSE: $response")

            _uiState.update { it.copy(isLoading = false) }

            if (response != null) {
                _navigationEvent.emit(Unit)
            }
        }
    }

//    fun onClickSelected() {
//        viewModelScope.launch(Dispatchers.IO) {
//            val response = login(_uiState.value.user, _uiState.value.password)
//             withContext(Dispatchers.Main) {
//                if (response != null) {
//                    Log.i("LOGIN", "SUCCESS ${response.token}")
//                } else {
//                    Log.i("LOGIN", "ERROR")
//                }
//            }
//        }
//    }

    private fun verifyLogin() {
        val enabledLogin =
            isEmailValid(_uiState.value.user) && isPasswordValid(_uiState.value.password)
        _uiState.update {
            it.copy(isLoginEnabled = enabledLogin)
        }
    }

    private fun isEmailValid(user: String): Boolean =
        user.isNotBlank()
//        Patterns.EMAIL_ADDRESS.matcher(user).matches()

    private fun isPasswordValid(password: String): Boolean = password.length >= 6

}

data class LoginUiState(
    val user: String = "johnd",
    var password: String = "m38rmF\$",
    val isLoading: Boolean = false,
    val isLoginEnabled: Boolean = false,
    val isLoginSuccess: Boolean = false
)