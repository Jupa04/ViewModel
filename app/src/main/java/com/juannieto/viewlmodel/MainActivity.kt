package com.juannieto.viewlmodel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel

class ContadorViewModel : ViewModel() {

    var contador by mutableIntStateOf(0)
        private set

    fun sumar() {
        contador++
    }

    fun reiniciar() {
        contador = 0
    }
}

class MainActivity : ComponentActivity() {

    private val viewModel: ContadorViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Pantalla(viewModel)
            }
        }
    }
}

@Composable
fun Pantalla(viewModel: ContadorViewModel) {
    var contadorLocal by remember { mutableIntStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Con ViewModel: ${viewModel.contador}", fontSize = 24.sp)
        Text("Sin ViewModel: $contadorLocal", fontSize = 24.sp)

        Spacer(Modifier.height(24.dp))

        Button(onClick = {
            viewModel.sumar()
            contadorLocal++
        }) {
            Text("Sumar")
        }

        Button(onClick = {
            viewModel.reiniciar()
            contadorLocal = 0
        }) {
            Text("Reiniciar")
        }

        Spacer(Modifier.height(24.dp))

        Text("Suma varias veces y gira el celular")
    }
}