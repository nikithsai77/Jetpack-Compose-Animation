package com.android.animation.animation

import androidx.compose.animation.core.animateIntAsState
import androidx.compose.animation.core.tween
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.animation.ui.theme.AnimationTheme

@Composable
fun AnimationVisibility() {
    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        var isVisible by remember {
            mutableStateOf(value = false)
        }
        Button(onClick = { isVisible = !isVisible }) {
            Text(text = "Toggle")
        }
        val animateInt by animateIntAsState(
            targetValue = if(isVisible) 0 else 100, label = "",
            animationSpec = tween()
        )
        Box(modifier = Modifier
            .size(100.dp)
            .clip(RoundedCornerShape(animateInt))
            .background(Color.Red)
        )
//        AnimatedVisibility(visible = isVisible,
//             enter = slideInHorizontally() + fadeIn(),
//            ) {
//            Box(modifier = Modifier
//                .fillMaxSize()
//                .background(Color.Red))
//        }
    }
}

@Preview
@Composable
fun Preview() {
    AnimationTheme {
        AnimationVisibility()
    }
}