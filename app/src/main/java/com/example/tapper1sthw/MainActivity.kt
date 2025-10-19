package com.example.tapper1sthw

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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Tapper()
        }
    }

}
object AppTexts {
    val clickTexts = listOf("клик", "клак", "клок")
}

@Composable
fun Tapper(
) {
    var currentIndex by rememberSaveable  { mutableIntStateOf(0) }
    var clickCount by rememberSaveable { mutableIntStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = {
            clickCount++
            currentIndex = (currentIndex + 1) % AppTexts.clickTexts.size
        }) {
            Text("тык")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = AppTexts.clickTexts[currentIndex])

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "тыкнул раз: ${clickCount}")
    }

}

