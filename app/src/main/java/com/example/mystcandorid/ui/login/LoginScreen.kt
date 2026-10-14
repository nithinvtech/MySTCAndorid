package com.example.mystcandorid.ui.login


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.minimumInteractiveComponentSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mystcandorid.R
import com.example.mystcandorid.ui.components.AppTopBar
import com.example.mystcandorid.ui.components.PrimaryButton
import com.example.mystcandorid.ui.theme.MystcTheme

@Composable
fun LoginRoute(
    onBack: () -> Unit,
    onForgotPassword: () -> Unit,
    onLogin: (line: String, password: String) -> Unit,
    viewModel: LoginViewModel = viewModel(),
) {
    val state by viewModel.uiState.collectAsStateWithLifecycle()

    LoginScreen(
        state = state,
        onLineNumberChange = viewModel::onLineNumberChange,
        onPasswordChange = viewModel::onPasswordChange,
        onSubmit = { viewModel.submit(onLogin) },
        onBack = onBack,
        onForgotPassword = onForgotPassword,
    )
}

@Composable
fun LoginScreen(
    state: LoginUiState,
    onLineNumberChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onSubmit: () -> Unit,
    onBack: () -> Unit,
    onForgotPassword: () -> Unit,
) {
    var showPassword by rememberSaveable { mutableStateOf(false) }
    val focusManager = LocalFocusManager.current

    Scaffold(
        topBar = {
            AppTopBar(
                title = stringResource(R.string.log_in),
                onBack = onBack,
            )
        },
        containerColor = MaterialTheme.colorScheme.background,
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .imePadding()
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 16.dp),
        ) {
            Spacer(Modifier.height(12.dp))
            Text(
                text = stringResource(R.string.login_heading),
                style = MaterialTheme.typography.headlineMedium,
            )
            Spacer(Modifier.height(36.dp))

            OutlinedTextField(
                value = state.lineNumber,
                onValueChange = onLineNumberChange,
                modifier = Modifier.fillMaxWidth(),
                label = { Text(stringResource(R.string.line_number)) },
                placeholder = {
                    Text(stringResource(R.string.line_number_placeholder))
                },
                isError = state.lineNumberError != null,
                supportingText = {
                    when (state.lineNumberError) {
                        LoginFieldError.Required ->
                            Text(stringResource(R.string.line_number_required))
                        LoginFieldError.InvalidLineNumber ->
                            Text(stringResource(R.string.line_number_invalid))
                        null -> Unit
                    }
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Phone,
                    imeAction = ImeAction.Next,
                ),
                keyboardActions = KeyboardActions(
                    onNext = { focusManager.moveFocus(FocusDirection.Down) },
                ),
                singleLine = true,
            )

            Spacer(Modifier.height(16.dp))

            OutlinedTextField(
                value = state.password,
                onValueChange = onPasswordChange,
                modifier = Modifier.fillMaxWidth(),
                label = { Text(stringResource(R.string.password)) },
                placeholder = {
                    Text(stringResource(R.string.password_placeholder))
                },
                visualTransformation = if (showPassword) {
                    VisualTransformation.None
                } else {
                    PasswordVisualTransformation()
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password,
                    imeAction = ImeAction.Done,
                ),
                keyboardActions = KeyboardActions(
                    onDone = {
                        focusManager.clearFocus()
                        onSubmit()
                    },
                ),
                isError = state.passwordError != null,
                supportingText = {
                    if (state.passwordError != null) {
                        Text(stringResource(R.string.password_required))
                    }
                },
                trailingIcon = {
                    IconButton(
                        onClick = { showPassword = !showPassword },
                    ) {
                        Icon(
                            imageVector = if (showPassword) {
                                Icons.Filled.VisibilityOff
                            } else {
                                Icons.Filled.Visibility
                            },
                            contentDescription = stringResource(
                                if (showPassword) {
                                    R.string.hide_password
                                } else {
                                    R.string.show_password
                                },
                            ),
                        )
                    }
                },
                singleLine = true,
            )

            Spacer(Modifier.height(25.dp))

            PrimaryButton(
                title = stringResource(R.string.log_in),
                onClick = onSubmit,
                enabled = state.isLoginEnabled,
                isLoading = state.isLoading,
            )

            Spacer(Modifier.height(16.dp))

            Text(
                text = stringResource(R.string.forgot_password),
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .minimumInteractiveComponentSize()
                    .clickable(onClick = onForgotPassword)
                    .padding(8.dp),
                color = MaterialTheme.colorScheme.primary,
                style = MaterialTheme.typography.bodyMedium,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun LoginScreenPreview() {
    MystcTheme {
        LoginScreen(
            state = LoginUiState(lineNumber = "33123456"),
            onLineNumberChange = {},
            onPasswordChange = {},
            onSubmit = {},
            onBack = {},
            onForgotPassword = {},
        )
    }
}
