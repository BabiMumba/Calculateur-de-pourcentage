package cd.bmfundacademia.calculateurpourcentage

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import cd.bmfundacademia.calculateurpourcentage.ui.theme.CalculateurPourcentageTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // enableEdgeToEdge()
        setContent {
            CalculateurPourcentageTheme {
                PercentageCalculator()
            }
        }
    }
}

@Composable
fun PercentageCalculator() {
    var number by remember { mutableStateOf("") }
    var percentage by remember { mutableStateOf("") }
    var result by remember(number, percentage) { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        OutlinedTextField(
            value = number,
            textStyle = TextStyle(
                color = Color.Black
            ),
            onValueChange = { number = it },
            label = { Text("Nombre") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = percentage,
            textStyle = TextStyle(
                color = Color.Black
            ),
            onValueChange = { percentage = it },
            label = { Text("Pourcentage") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            if (number.isNotBlank() && percentage.isNotBlank()) {
                val num = number.toDouble()
                val per = percentage.toDouble()
                val res = (num * per) / 100
                result = res.toString()
            }
        }) {
            Text("Calculer")
        }

        Spacer(modifier = Modifier.height(16.dp))

        if (result.isNotEmpty()) {
            Text("Résultat: $result %")
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    CalculateurPourcentageTheme {
        PercentageCalculator()
    }
}