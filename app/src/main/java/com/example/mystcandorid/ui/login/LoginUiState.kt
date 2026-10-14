package com.example.mystcandorid.ui.login


data class LoginUiState(
    val lineNumber: String = "",
    val password: String = "",
    val lineNumberError: LoginFieldError? = null,
    val passwordError: LoginFieldError? = null,
    val isLoading: Boolean = false,
) {
    val isLoginEnabled: Boolean
        get() = !isLoading &&
                lineNumber.isNotBlank() &&
                password.isNotBlank()
}

enum class LoginFieldError {
    Required,
    InvalidLineNumber,
}
