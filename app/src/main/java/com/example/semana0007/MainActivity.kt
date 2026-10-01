package com.example.semana0007

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.semana0007.ui.theme.Semana0007Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Semana0007Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CounterScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

// 1. ViewModel que gestiona un número entero (Int)
class CounterViewModel : ViewModel() {
    var count by mutableIntStateOf(0)
        private set

    fun incrementar() {
        count++
    }
}

// 2. Composable CounterScreen que obtiene la instancia del ViewModel
@Composable
fun CounterScreen(modifier: Modifier = Modifier, viewModel: CounterViewModel = viewModel()) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Text que muestra el valor actual del contador iniciado en 0
        Text(
            text = "Contador: ${viewModel.count}",
            fontSize = 32.sp
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Button con el texto "Incrementar" que incrementa el valor en uno al presionarlo
        Button(onClick = { viewModel.incrementar() }) {
            Text(text = "Incrementar", fontSize = 18.sp)
        }
    }
}

@androidx.compose.ui.tooling.preview.Preview(showBackground = true)
@Composable
fun CounterScreenPreview() {
    Semana0007Theme {
        CounterScreen()
    }
}
