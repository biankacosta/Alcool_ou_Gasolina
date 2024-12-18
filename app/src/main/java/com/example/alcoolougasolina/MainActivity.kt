package com.example.alcoolougasolina

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.alcoolougasolina.ui.theme.AlcoolOuGasolinaTheme
import com.example.alcoolougasolina.ui.theme.LightGray
import com.example.alcoolougasolina.ui.theme.LightGreen
import com.example.alcoolougasolina.ui.theme.LightPink
import com.example.alcoolougasolina.ui.theme.TruePink
import com.example.alcoolougasolina.ui.theme.patuaFont

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AlcoolOuGasolinaTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Screen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Screen(modifier: Modifier = Modifier) {
    val secondaryColor = MaterialTheme.colorScheme.secondary
    val tertiaryColor = MaterialTheme.colorScheme.tertiary

    var gasolinePrice by remember { mutableStateOf("") }
    var alcoholPrice by remember { mutableStateOf("") }
    var checked by remember { mutableStateOf(true) }

    Column (
        modifier = Modifier.fillMaxWidth().fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().fillMaxHeight(0.13f),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.Bottom
        ) {
            Image(
                painter = painterResource(id = R.drawable.bomba_de_combustivel),
                contentDescription = "Bomba de Gasolina",
                modifier = Modifier
                    .size(70.dp)
                    .padding(bottom = 8.dp),
                contentScale = ContentScale.Crop

            )
            Column(
                modifier = Modifier.padding(7.dp)
            ) {
                Text(
                    text = "ÁLCOOL",
                    style = MaterialTheme.typography.titleLarge.copy(
                        brush = Brush.linearGradient(
                            colors = listOf(TruePink, LightPink)
                        )
                    )
                )

                Text(
                    text = "ou gasolina",
                    style = MaterialTheme.typography.titleLarge.copy(
                        brush = Brush.linearGradient(
                            colors = listOf(TruePink, LightPink)
                        ),
                        fontSize = 24.sp
                    )
                )
            }

        }
        Column(
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .fillMaxHeight(0.75f)
                .padding(16.dp)
                .clip(RoundedCornerShape(16.dp))  // Borda arredondada
                .background(secondaryColor)      // Cor de fundo
                .padding(16.dp),
             verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                text = "Preço da Gasolina:",
                style = MaterialTheme.typography.bodyLarge,
                color = tertiaryColor
            )

            TextField(
                value = gasolinePrice,
                onValueChange = { newText -> gasolinePrice = newText },
                label = { Text("$") },
                modifier = Modifier.fillMaxWidth().border(1.dp, tertiaryColor, RoundedCornerShape(8.dp)),
                singleLine = true,
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = LightGreen, // Cor da borda quando o campo estiver focado
                    unfocusedContainerColor = LightGray, // Cor da borda quando o campo não estiver focad
                )
            )

            Text(
                text = "Preço do Álcool:",
                style = MaterialTheme.typography.bodyLarge,
                color = tertiaryColor
            )

            TextField(
                value = alcoholPrice,
                onValueChange = { newText -> alcoholPrice = newText },
                label = { Text("$") },
                modifier = Modifier.fillMaxWidth().border(1.dp, tertiaryColor, RoundedCornerShape(8.dp)),
                singleLine = true,
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = LightGreen,
                    unfocusedContainerColor = LightGray
                )
            )

            Text(
                text = "Rendimento do carro",
                style = MaterialTheme.typography.labelSmall,
                color = tertiaryColor
            )

            Switch(
                checked = checked,
                onCheckedChange = {
                    checked = it
                },
                colors = SwitchDefaults.colors(
                    checkedThumbColor = TruePink,
                    checkedTrackColor = Pink80,
                    uncheckedThumbColor = Pink80,
                    uncheckedTrackColor = TruePink,
                )
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ScreenPreview() {
    AlcoolOuGasolinaTheme {
        Screen()
    }
}