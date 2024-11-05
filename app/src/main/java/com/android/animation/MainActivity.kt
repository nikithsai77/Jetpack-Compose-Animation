package com.android.animation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.android.animation.animation.ContentAnimated
import com.android.animation.ui.theme.AnimationTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AnimationTheme {
                ContentAnimated()
            }
        }
    }

}

@Preview
@Composable
fun GreetingPreview() {
    AnimationTheme {
        ContentAnimated()
    }
}