package com.checky.fstory.presentation.screen.mainContainer.profile


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.checky.fstory.domain.usecase.UseCaseGetProfile

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val getProfile: UseCaseGetProfile
): ViewModel(){

    private val _uiState = MutableStateFlow(ProfileUIState())

    val uiState : StateFlow<ProfileUIState> = _uiState

    init{
        this.fetchProfile()
    }
    private fun fetchProfile () {
        viewModelScope.launch {
            try {
                val user = getProfile()
                _uiState.update { it.copy(
                    email = user.email,
                    name = user.fullName,
                    username =user.username,
                    password= user.password,
                    phone = user.phone
                )
                }
            }catch (e: Exception){
                print("$e")
            }
        }

    }


}

data class ProfileUIState(

    val name : String = "",
    val email : String = "",
    val password : String = "",
    val username : String = "",
    val phone: String =""
)