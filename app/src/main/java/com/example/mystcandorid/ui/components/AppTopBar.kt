package com.example.mystcandorid.ui.components



import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mystcandorid.R

@Composable
fun AppTopBar(
    title: String,
    onBack: (() -> Unit)? = null,
    rightText: String? = null,
    onRightClick: (() -> Unit)? = null,
) {
    androidx.compose.foundation.layout.Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(52.dp)
                .padding(horizontal = 12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Box(modifier = Modifier.width(72.dp)) {
                if (onBack != null) {
                    Text(
                        text = "‹",
                        fontSize = 34.sp,
                        color = Color(0xFF263238),
                        modifier = Modifier.clickable(onClick = onBack),
                    )
                }
            }

            Text(
                text = title,
                fontSize = 14.sp,
                color = Color(0xFF222222),
            )

            Box(
                modifier = Modifier.width(72.dp),
                contentAlignment = Alignment.CenterEnd,
            ) {
                if (rightText != null) {
                    Text(
                        text = rightText,
                        fontSize = 13.sp,
                        color = Color(0xFFF52B58),
                        modifier = if (onRightClick != null) {
                            Modifier.clickable(onClick = onRightClick)
                        } else {
                            Modifier
                        },
                    )
                }
            }
        }
        HorizontalDivider(color = Color(0xFFE5E5E5))
    }
}
