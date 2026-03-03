package com.checky.fstory.ui.presentation.screen.main


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.checky.fstory.ui.domain.entity.ProductEntity
import com.checky.fstory.ui.domain.usecase.UseCaseGetAllProducts
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getAllProduct: UseCaseGetAllProducts
) : ViewModel() {
    private val _uiState = MutableStateFlow(MainUiState())
    val uiState: StateFlow<MainUiState> = _uiState

    init {
        fetchMain()
    }

    private fun fetchMain() {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true) }
            try {
                val productList = getAllProduct()
                _uiState.update {
                     it.copy(
                            productList=productList,
                            isLoading = false
                        )
                    }
                }catch (e: Exception){
                _uiState.update {
                    it.copy(
                        error = e.message,
                        isLoading = false
                    )
                }
            }
        }
    }


}

data class MainUiState(
    val productList: List<ProductEntity> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)