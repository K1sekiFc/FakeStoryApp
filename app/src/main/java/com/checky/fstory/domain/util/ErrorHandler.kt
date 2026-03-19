package com.checky.fstory.domain.util

import kotlinx.coroutines.flow.StateFlow

interface ErrorHandler {
    val errorState: StateFlow<String?>
    fun showError(message: String?)
    fun dismissError()
}