package com.example.login.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun Sobre() {

    Column(modifier = Modifier.fillMaxSize()) {

        Text(
            text = "Sobre o Dev",
            textAlign = TextAlign.Center,
            fontSize = 24.sp,
            modifier = Modifier.fillMaxWidth().padding( bottom = 40.dp, top = 10.dp)
        )

        Text(
            text = "Desenvolvedor: Bruno Renan Pich",
            textAlign = TextAlign.Center,
            fontSize = 20.sp
        )

        Text(
            text = "Idade: 20 anos",
            textAlign = TextAlign.Center,
            fontSize = 20.sp
        )

        Text(
            text = "Cidade natal: Blumenau - SC",
            textAlign = TextAlign.Center,
            fontSize = 20.sp
        )
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewSobre() {
    Sobre()
}