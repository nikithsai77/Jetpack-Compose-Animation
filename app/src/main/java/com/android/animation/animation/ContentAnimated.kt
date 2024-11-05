@file:OptIn(ExperimentalAnimationApi::class)

package com.android.animation.animation

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.with
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ContentAnimated() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        var isVisible by remember {
            mutableStateOf(value = false)
        }
        Button(onClick = { isVisible = !isVisible }) {
            Text(text = "Toggle")
        }
        AnimatedContent(
            targetState = isVisible,
            modifier = Modifier.fillMaxWidth().weight(1f),
            content = {
                if (it) Box(modifier = Modifier.background(Color.Green))
                else Box(modifier = Modifier.background(Color.Red))
            },
            transitionSpec = {
                slideInHorizontally(initialOffsetX = {
                    if (isVisible) it else -it
                }) with slideOutHorizontally(targetOffsetX = {
                    if (isVisible) -it else it
                })
            },
            label = ""
        )
    }
}

@Preview
@Composable
fun Review() {
    ContentAnimated()
}