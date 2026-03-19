package com.checky.fstory.data.util

import com.checky.fstory.domain.util.ErrorHandler
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

class ErrorHandlerImpl @Inject constructor() : ErrorHandler {
    private val _error = MutableStateFlow<String?>(null)
    override val errorState: StateFlow<String?> = _error.asStateFlow()

    override fun showError(message: String?) {
        _error.value = message
    }

    override fun dismissError() {
        _error.value = null
    }
}