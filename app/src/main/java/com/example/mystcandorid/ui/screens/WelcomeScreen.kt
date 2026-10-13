package com.example.mystcandorid.ui.screens


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mystcandorid.R
import com.example.mystcandorid.ui.components.AppTopBar
import com.example.mystcandorid.ui.components.PrimaryButton

@Composable
fun WelcomeScreen(onLogin: () -> Unit) {
    Column(modifier = Modifier.fillMaxSize()) {
        AppTopBar(
            title = stringResource(R.string.get_started),
            rightText = stringResource(R.string.language_label),
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp, vertical = 20.dp),
            verticalArrangement = Arrangement.SpaceBetween,
        ) {
            Column {
                Image(
                    painter = painterResource(R.drawable.stc_logo),
                    contentDescription = stringResource(R.string.stc_logo_description),
                    modifier = Modifier
                        .fillMaxWidth(0.22f)
                        .height(52.dp),
                    contentScale = ContentScale.Fit,
                )

                Spacer(Modifier.height(14.dp))

                Image(
                    painter = painterResource(R.drawable.welcome_illustration),
                    contentDescription = stringResource(R.string.welcome_illustration_description),
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(1.04f),
                    contentScale = ContentScale.Fit,
                )

                Spacer(Modifier.height(20.dp))
                Text(stringResource(R.string.welcome_title), fontSize = 20.sp)
                Spacer(Modifier.height(8.dp))
                Text(
                    stringResource(R.string.welcome_subtitle),
                    fontSize = 14.sp,
                    color = Color.Gray,
                )
            }

            PrimaryButton(
                title = stringResource(R.string.log_in),
                onClick = onLogin,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
            )
        }
    }
}
