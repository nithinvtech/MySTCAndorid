package com.example.mystcandorid.ui.login


import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

private val LineNumberRegex = Regex("""^\d{8}$""")

class LoginViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(LoginUiState())
    val uiState = _uiState.asStateFlow()

    fun onLineNumberChange(value: String) {
        _uiState.update {
            it.copy(lineNumber = value, lineNumberError = null)
        }
    }

    fun onPasswordChange(value: String) {
        _uiState.update {
            it.copy(password = value, passwordError = null)
        }
    }


    fun submit(onLogin: (line: String, password: String) -> Unit) {
        val state = _uiState.value
        if (state.isLoading) return

        val line = state.lineNumber.trim()
        val lineError = when {
            line.isEmpty() -> LoginFieldError.Required
            !line.matches(LineNumberRegex) ->
                LoginFieldError.InvalidLineNumber
            else -> null
        }
        val passwordError =
            if (state.password.isBlank()) LoginFieldError.Required else null

        _uiState.update {
            it.copy(
                lineNumber = line,
                lineNumberError = lineError,
                passwordError = passwordError,
            )
        }

        if (lineError == null && passwordError == null) {
            onLogin(line, state.password)
        }
    }

    fun setLoading(loading: Boolean) {
        _uiState.update { it.copy(isLoading = loading) }
    }
}
