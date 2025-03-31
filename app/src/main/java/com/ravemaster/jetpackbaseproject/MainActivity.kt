package com.ravemaster.jetpackbaseproject

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ravemaster.jetpackbaseproject.ui.theme.JetpackBaseProjectTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackBaseProjectTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ShowButton(
                        modifier = Modifier.padding(innerPadding),
                        applicationContext
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Composable
fun ShowButton(modifier: Modifier = Modifier, context: Context) {
    Box(
        modifier = modifier.fillMaxSize(),
    ){
        Button (
            onClick = {
                Toast.makeText(context,"Button pressed",Toast.LENGTH_LONG).show()},
            modifier = modifier
                .padding(10.dp)
                .align(Alignment.Center),
        ) {
            Text("Press me")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetpackBaseProjectTheme {
        Greeting("Android")
    }
}