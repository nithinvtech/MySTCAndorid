package com.example.mystcandorid.ui.welcome


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mystcandorid.R
import com.example.mystcandorid.ui.components.AppTopBar
import com.example.mystcandorid.ui.components.PrimaryButton
import com.example.mystcandorid.ui.theme.MystcTheme

@Composable
fun WelcomeScreen(
    onLogin: () -> Unit,
    onLanguageClick: () -> Unit,
) {
    Scaffold(
        topBar = {
            AppTopBar(
                title = stringResource(R.string.get_started),
                rightText = stringResource(R.string.language_label),
                onRightClick = onLanguageClick,
            )
        },
        containerColor = MaterialTheme.colorScheme.background,
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(horizontal = 16.dp, vertical = 20.dp),
            verticalArrangement = Arrangement.SpaceBetween,
        ) {
            Column {
                Image(
                    painter = painterResource(R.drawable.stc_logo),
                    contentDescription = stringResource(R.string.stc_logo_description),
                    modifier = Modifier.height(52.dp),
                    contentScale = ContentScale.Fit,
                )
                Spacer(Modifier.height(14.dp))
                Image(
                    painter = painterResource(R.drawable.welcome_illustration),
                    contentDescription = stringResource(
                        R.string.welcome_illustration_description
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f, fill = false),
                    contentScale = ContentScale.Fit,
                )
                Spacer(Modifier.height(20.dp))
                Text(
                    text = stringResource(R.string.welcome_title),
                    style = MaterialTheme.typography.titleMedium,
                )
                Spacer(Modifier.height(8.dp))
                Text(
                    text = stringResource(R.string.welcome_subtitle),
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                )
            }

            PrimaryButton(
                title = stringResource(R.string.log_in),
                onClick = onLogin,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun WelcomeScreenPreview() {
    MystcTheme {
        WelcomeScreen(
            onLogin = {},
            onLanguageClick = {},
        )
    }
}
