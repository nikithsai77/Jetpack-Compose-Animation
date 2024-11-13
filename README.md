If Animation depends on a single state and that animation has a only single value then use animateIntAsState.
If you want to animate the animation with multiple values based on a single state then use updateTransition.

var isRound by remember {
   mutableStateOf(false)
}

  val animateInt by animateIntAsState(
            targetValue = if(isRound) 0 else 100, label = "",
            animationSpec = tween()
        )
        Box(modifier = Modifier
            .size(100.dp)
            .clip(RoundedCornerShape(animateInt))
            .background(Color.Red)
        )
        
animateIntAsState will animate the animation with a smooth transition for every recomposition of isRound state.
        
        val transition = updateTransition(targetState = isRound,label = null)

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

 In the above code, borderRadius, and color both depend on a single state called transition. if the transition updates then both values will get the updated values.









 
        
