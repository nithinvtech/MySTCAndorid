package com.example.mystcandorid.ui.screens


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mystcandorid.R
import com.example.mystcandorid.ui.components.AppTopBar
import com.example.mystcandorid.ui.components.PrimaryButton

@Composable
fun LoginScreen(onBack: () -> Unit) {
    var lineNumber by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var showPassword by rememberSaveable { mutableStateOf(false) }

    Column(modifier = Modifier.fillMaxSize()) {
        AppTopBar(title = stringResource(R.string.log_in), onBack = onBack)

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
        ) {
            Spacer(Modifier.height(12.dp))
            Text(stringResource(R.string.login_heading), fontSize = 28.sp)
            Spacer(Modifier.height(36.dp))

            OutlinedTextField(
                value = lineNumber,
                onValueChange = { lineNumber = it },
                label = { Text(stringResource(R.string.line_number)) },
                placeholder = { Text(stringResource(R.string.line_number_placeholder)) },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                singleLine = true,
                modifier = Modifier.fillMaxWidth(),
            )

            Spacer(Modifier.height(25.dp))

            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text(stringResource(R.string.password)) },
                placeholder = { Text(stringResource(R.string.password_placeholder)) },
                visualTransformation = if (showPassword) {
                    VisualTransformation.None
                } else {
                    PasswordVisualTransformation()
                },
                trailingIcon = {
                    Text(
                        text = stringResource(
                            if (showPassword) R.string.hide_password else R.string.show_password
                        ),
                        modifier = Modifier
                            .clickable { showPassword = !showPassword }
                            .padding(8.dp),
                    )
                },
                singleLine = true,
                modifier = Modifier.fillMaxWidth(),
            )

            Spacer(Modifier.height(38.dp))

            PrimaryButton(
                title = stringResource(R.string.log_in),
                onClick = { /* Add authentication here */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
            )

            Spacer(Modifier.height(22.dp))

            Text(
                text = stringResource(R.string.forgot_password),
                color = Color(0xFFF54268),
                fontSize = 16.sp,
                modifier = Modifier.align(Alignment.CenterHorizontally),
            )
        }
    }
}
