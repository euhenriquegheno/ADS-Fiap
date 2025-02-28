package br.com.fiap.basiccomponents

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.basiccomponents.ui.theme.BasicComponentsTheme
import br.com.fiap.basiccomponents.ui.theme.Righteous

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BasicComponentsTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BasicComponentsScreen()
                }
            }
        }
    }
}

@Composable
fun BasicComponentsScreen() {
    var textFieldValue = remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Black)
    )
    {
        Text(
            text = "FIAP",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFFED145B), //0x = Hexadecimal necessita desse prefixo / FF = representa a transparencia de uma cor
            fontFamily = FontFamily.Serif,
            modifier = Modifier
                .background(Color.Yellow)
                .fillMaxWidth(),
            textAlign = TextAlign.End
        )
        Text(
            text = "Desenvolvendo aplicações Android",
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.White,
            fontFamily = Righteous,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        TextField(
            value = textFieldValue.value,
            onValueChange = { novoValor ->
                textFieldValue.value = novoValor
            },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(capitalization = KeyboardCapitalization.Words),
            label = {Text(text = "Nome e sobrenome")},
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "",
                    tint = Color(237, 20, 91)
                )
            }
        )

        var quantidade = remember {
            mutableStateOf("")
        }

        TextField(
            value = "${quantidade.value}",
            onValueChange = { novoValor ->
                quantidade.value = novoValor
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            placeholder = {Text(text = "Qual a quantidade?")},
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.White,
                unfocusedTextColor = Color.Green,
                unfocusedPlaceholderColor = Color.Magenta
            )
        )

        Spacer(modifier = Modifier.height(32.dp))
        var cidade = remember {
            mutableStateOf("")
        }

        OutlinedTextField(
            value = cidade.value,
            onValueChange = {
                cidade.value = it
            },
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            textStyle = TextStyle(color = Color.White),
            shape = RoundedCornerShape(16.dp),
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedBorderColor = Color.Yellow,
                focusedBorderColor = Color.Cyan
            )
        )

        Spacer(modifier = Modifier.height(32.dp))

        var kotlin = remember {
            mutableStateOf(true)
        }

        var java = remember {
            mutableStateOf(false)
        }

        var cSharp = remember {
            mutableStateOf(false)
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Checkbox(
                checked = kotlin.value,
                onCheckedChange = {kotlin.value = it },
                colors = CheckboxDefaults.colors(
                    checkedColor = Color.White,
                    uncheckedColor = Color(0xFFED145B)
                )
            )
            Text(
                text = "Kotlin",
                color = Color.White
            )
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Checkbox(
                checked = java.value,
                onCheckedChange = {java.value = it },
                colors = CheckboxDefaults.colors(
                    checkedColor = Color.White,
                    uncheckedColor = Color(0xFFED145B)
                )
            )
            Text(
                text = "Java",
                color = Color.White
            )
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Checkbox(
                checked = cSharp.value,
                onCheckedChange = { cSharp.value = it },
                colors = CheckboxDefaults.colors(
                    checkedColor = Color.White,
                    uncheckedColor = Color(0xFFED145B)
                )
            )
            Text(
                text = "C#",
                color = Color.White
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Spacer(modifier = Modifier.height(16.dp))

        var selecionado = remember {
            mutableStateOf(0)
        }

        Row(modifier = Modifier.fillMaxWidth()) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                RadioButton(
                    selected = selecionado.value == 0,
                    onClick = { selecionado.value = 0 },
                    colors = RadioButtonDefaults.colors(
                        selectedColor = Color.White,
                        unselectedColor = Color(0xffed145b)
                    )
                )
                Text(text = "MacOS", color = Color.White)
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                RadioButton(
                    selected = selecionado.value == 1,
                    onClick = { selecionado.value = 1 },
                    colors = RadioButtonDefaults.colors(
                        selectedColor = Color.White,
                        unselectedColor = Color(0xffed145b)
                    )
                )
                Text(text = "GNU/Linux", color = Color.White)
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                RadioButton(
                    selected = selecionado.value == 2,
                    onClick = { selecionado.value = 2 },
                    colors = RadioButtonDefaults.colors(
                        selectedColor = Color.White,
                        unselectedColor = Color(0xffed145b)
                    )
                )
                Text(text = "Windows 11", color = Color.White)
            }
        }

        Button(
            onClick = {
                cidade.value = "Unidade Paulista"
            },
            modifier = Modifier.size(width = 200.dp, height = 60.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Magenta),
            border = BorderStroke(width = 3.dp, color = Color.White)
        ) {
            Text(text = "Clique aqui!")
        }
        OutlinedButton(onClick = {
            cidade.value = ""
        }) {
            Text(text = "Outro botão")
        }
    }
}