package com.works.days21

import android.os.Bundle
import android.util.Log
import android.widget.EditText
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.works.days21.ui.theme.Days21Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val name =
            Days21Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Column(modifier = Modifier.padding(24.dp)) {
                        Greeting("Android")
                        Greeting(name = "Kotlin")
                    }
                    OutlinedButton(
                        onClick = {Log.d("Click","This line Call")},
                        modifier = Modifier.padding(10.dp))
                    {
                        Text(text = "Save")
                        
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}



@Composable
fun name() : MutableState<String>{
    return remember {
        mutableStateOf("")
    }
}


@Composable
fun userName(name : MutableState<String>){
    TextField(
        value = name.value,
        onValueChange = {
            name.value = it
            Log.d("String", name.value)
        },
        modifier = Modifier.absoluteOffset(10.dp,10.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Days21Theme {
        Column(modifier = Modifier.padding(24.dp)) {
            Greeting("Android")
            Greeting(name = "Kotlin")
            userName(name)
        }
    }
}