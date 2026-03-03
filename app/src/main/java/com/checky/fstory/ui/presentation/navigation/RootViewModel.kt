//package com.abexa.myapplication1.ui.presentation.navigation
//
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.setValue
//import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
//import androidx.lifecycle.ViewModel
//import com.abexa.myapplication1.ui.data.datasource.preferences.SessionDataStore
//import dagger.hilt.android.lifecycle.HiltViewModel
//import dagger.hilt.android.scopes.ViewModelScoped
//import kotlinx.coroutines.flow.first
//import javax.inject.Inject
//
//@HiltViewModel
//class RootViewModel @Inject constructor(
//    private val session: SessionDataStore
//) : ViewModel() {
//
//    var startDestination by mutableStateOf<NavRoutes?>(null)
//        private set
//
//    init {
//        checkSession()
//    }
//
//    private fun checkSession() {
//        viewModelScope.launch {
//            val token = session.getToken.first()
//
//            startDestination = if (token != null) {
//                NavRoutes.Main
//            } else {
//                NavRoutes.Login
//            }
//        }
//    }
//}