package com.example.login


import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AlertDialog
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.login.ui.theme.LoginTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BoaViagem(this) // Passando o contexto para a função BoaViagem
                }
            }
        }
    }
}

@Composable
fun BoaViagem(context: Context) {
    var usuario = remember {
        mutableStateOf("")
    }

    var senha = remember {
        mutableStateOf("")
    }

    var senhaVisivel = remember {
        mutableStateOf(false)
    }

    Column (modifier = Modifier.padding(16.dp))  {
        Image(painter = painterResource(id = R.drawable.login), contentDescription = "imagem login",
            modifier = Modifier
                .size(360.dp))

        Text(text = "Boa Viagem",
            textAlign = TextAlign.Center,
            fontSize = 30.sp,
            color = Color.DarkGray,
            modifier = Modifier
                .background(Color.White)
                .fillMaxWidth()
        )

        Text(text = "Usuário",
            textAlign = TextAlign.Center,
            fontSize = 20.sp
        )

        OutlinedTextField(
            value = usuario.value,
            onValueChange = { usuario.value = it },
            label = {
                Text(text = "Usuário")
            }
        )

        Text(text = "Senha",
            textAlign = TextAlign.Center,
            fontSize = 20.sp
        )

        OutlinedTextField(
            value = senha.value,
            onValueChange = { senha.value = it },
            label = {
                Text(text = "Senha")
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password
            ),
            visualTransformation =
            if (senhaVisivel.value)
                VisualTransformation.None
            else
                PasswordVisualTransformation(),
            trailingIcon = {
                IconButton(onClick = {
                    senhaVisivel.value = !senhaVisivel.value
                }) {
                    if (senhaVisivel.value)
                        Icon(
                            painterResource(id = R.drawable.visivel), "")
                    else
                        Icon(
                            painterResource(id = R.drawable.olho), "")
                }
            }
        )

        Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
            Button(onClick = {
                if (usuario.value == "alexia" && senha.value == "1234") {
                    val intent = Intent(context, SegundaAtividade::class.java)
                    intent.putExtra("username", usuario.value)
                    context.startActivity(intent)
                } else {
                    context.toast("Usuário ou senha incorreto")
                }
            }) {
                Text(text = "Entrar",
                    fontSize = 18.sp)
            }
        }

        Text(
            text = "Novo usuário | Esqueci minha senha",
            textAlign = TextAlign.Center,
            fontSize = 15.sp,
            modifier = Modifier
                .background(Color.White)
                .fillMaxWidth()
        )
    }
}

    fun Context.toast(message: CharSequence) =
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()




@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LoginTheme {
        Greeting("Android")
    }
}