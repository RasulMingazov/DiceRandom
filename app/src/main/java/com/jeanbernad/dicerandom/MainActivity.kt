package com.jeanbernad.dicerandom

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.jeanbernad.dicerandom.ui.theme.DiceRandomTheme

class MainActivity : ComponentActivity() {

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = (application as DiceApp).mainViewModel
        setContent {
            DiceRandomTheme {
                DiceWithButtonAndImage()
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun DiceRandomApp() {
        DiceWithButtonAndImage()
    }

    @Preview(showBackground = true)
    @Composable
    fun DiceWithButtonAndImage(
        modifier: Modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
    ) {
        val image = viewModel.state().collectAsState()
        Column(
            modifier = modifier,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = image.value.second),
                contentDescription = image.value.first.toString()
            )
            Button(onClick = { viewModel.changePicture() }) {
                Text(text = stringResource(id = R.string.roll))
            }

        }
    }
}