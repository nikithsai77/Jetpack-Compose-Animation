package com.android.animation.animation

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.animateInt
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun TransitionAnimation() {
    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        var isVisible by remember {
            mutableStateOf(value = false)
        }
        Button(onClick = { isVisible = !isVisible }) {
            Text(text = "Toggle")
        }
        val transition = updateTransition(targetState = isVisible, label = null)
        val borderRadius by transition.animateInt(
            transitionSpec = { tween(durationMillis = 2000) },
            label = "borderRadius",
            targetValueByState = {
                if (it) 100 else 0
            }
        )
        val color by transition.animateColor(
            transitionSpec = { tween(durationMillis = 2000) },
            label = "Color",
            targetValueByState = {
                if (it) Color.Green else Color.Red
            }
        )
        Box(modifier = Modifier.size(100.dp).clip(RoundedCornerShape(borderRadius)).background(color))
    }
}