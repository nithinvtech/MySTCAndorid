package com.example.mystcandorid.ui.components


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mystcandorid.R
import com.example.mystcandorid.ui.theme.MystcTheme

@Composable
fun AppTopBar(
    title: String,
    onBack: (() -> Unit)? = null,
    rightText: String? = null,
    onRightClick: (() -> Unit)? = null,
) {
    Column(
        modifier = Modifier.statusBarsPadding(),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(52.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Box(
                modifier = Modifier.width(80.dp),
                contentAlignment = Alignment.CenterStart,
            ) {
                if (onBack != null) {
                    IconButton(onClick = onBack, modifier = Modifier.size(48.dp)) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = stringResource(R.string.go_back),
                        )
                    }
                }
            }

            Text(
                text = title,
                modifier = Modifier.weight(1f),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.titleSmall,
            )

            Box(
                modifier = Modifier.width(80.dp),
                contentAlignment = Alignment.CenterEnd,
            ) {
                if (rightText != null && onRightClick != null) {
                    TextButton(onClick = onRightClick) {
                        Text(
                            text = rightText,
                            style = MaterialTheme.typography.labelSmall,
                        )
                    }
                }
            }
        }

        HorizontalDivider(color = MaterialTheme.colorScheme.outline)
    }
}

@Preview(showBackground = true)
@Composable
private fun AppTopBarPreview() {
    MystcTheme {
        AppTopBar(
            title = "log in",
            onBack = {},
            rightText = "العربية",
            onRightClick = {},
        )
    }
}
