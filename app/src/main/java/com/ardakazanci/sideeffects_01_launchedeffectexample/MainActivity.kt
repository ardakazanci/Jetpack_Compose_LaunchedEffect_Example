package com.ardakazanci.sideeffects_01_launchedeffectexample

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.ardakazanci.sideeffects_01_launchedeffectexample.ui.theme.SideEffects01LaunchedEffectExampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SideEffects01LaunchedEffectExampleTheme {
                Header()
            }
        }
    }
}

@Composable
fun Header() {

    var state by remember { mutableStateOf(true) }

    var context = LocalContext.current.applicationContext

    LaunchedEffect(key1 = Unit){
        Toast.makeText(context,"Hello World",Toast.LENGTH_LONG).show()
    }
    
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text = "Hello World $state", modifier = Modifier.clickable { state = false }, fontSize = 32.sp)
    }
}

