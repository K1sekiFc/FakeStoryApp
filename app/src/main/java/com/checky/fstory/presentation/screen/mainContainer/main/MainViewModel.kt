package com.checky.fstory.presentation.screen.mainContainer.main


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.checky.fstory.domain.entity.ProductEntity
import com.checky.fstory.domain.repository.ProductRepository
import com.checky.fstory.domain.usecase.UseCaseGetAllProducts
import com.checky.fstory.domain.util.ErrorHandler
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getAllProduct: UseCaseGetAllProducts, private val repository: ProductRepository,private val errorHandler: ErrorHandler
) : ViewModel(), ErrorHandler by errorHandler {
    private val _uiState = MutableStateFlow(MainUiState())
    val uiState = combine(_uiState, errorState) { state, error ->
        state.copy(error = error)
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), MainUiState())

//    val uiState: StateFlow<MainUiState> = _uiState

    init {
        observeProducts()
//        fetchMain()
        refreshFromServer()
    }

//    fun dismissError() {
//        _uiState.update { it.copy(error = null) }
//    }
    private fun observeProducts() {
        viewModelScope.launch {
            getAllProduct().collect { products ->
                _uiState.update { it.copy(productList = products) }
            }
        }
    }
//    private fun fetchMain() {
//        viewModelScope.launch {
//            _uiState.update { it.copy(isLoading = true) }
//            try {
//                getAllProduct().collect { products ->
//                    _uiState.update {
//                        it.copy(
//                            productList = products,
//                            isLoading = false
//                        )
//                    }
//                }
//            } catch (e: Exception) {
//                _uiState.update {
//                    it.copy(
//                        error = e.message,
//                        isLoading = false
//                    )
//                }
//            }
//        }
//    }

    private fun refreshFromServer() {
        viewModelScope.launch {
            try {
                repository.refreshProduct()
            } catch (e: Exception) {
                _uiState.update { it.copy(error = "Error de red: ${e.message}") }
            } finally {
                _uiState.update { it.copy(isLoading = false) }
            }
        }

    }
}

data class MainUiState(
    val productList: List<ProductEntity> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)