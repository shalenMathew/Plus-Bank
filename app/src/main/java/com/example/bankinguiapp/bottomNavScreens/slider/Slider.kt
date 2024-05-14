package com.example.bankinguiapp.bottomNavScreens.slider

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowForward
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.wear.compose.material.ExperimentalWearMaterialApi
import androidx.wear.compose.material.FractionalThreshold
import androidx.wear.compose.material.rememberSwipeableState
import androidx.wear.compose.material.swipeable
import com.example.bankinguiapp.ui.theme.GreenStart
import com.example.bankinguiapp.ui.theme.YellowStart
import kotlin.math.roundToInt

@Composable
private fun DraggableControl(
    modifier: Modifier,
    progress: Float
) {
    Box(
        modifier = modifier
            .padding(4.dp)
            .shadow(
                elevation = 2.dp,
                CircleShape,
                clip = false
            )
            .background(Color.Black, CircleShape),
        contentAlignment = Alignment.Center
    ) {
        val isConfirmed = derivedStateOf { progress >= 0.8f }

        Crossfade(targetState = isConfirmed.value) {
            if (it) {
                Icon(
                    imageVector = Icons.Filled.Done,
                    contentDescription = "Confirm Icon",
                    tint = Color.White
                )
            } else {
                Icon(
                    imageVector = Icons.AutoMirrored.Rounded.ArrowForward,
                    contentDescription = "Forward Icon",
                    tint = Color.White
                )
            }
        }
    }
}



@OptIn(ExperimentalWearMaterialApi::class)
@Composable
fun ConfirmationButton(
    modifier: Modifier = Modifier
) {
    val width = 350.dp
    val dragSize = 50.dp
    val swipeableState = rememberSwipeableState(initialValue = ConfirmationState.DEFAULT)
    val sizePx = with(LocalDensity.current) {
        (width - dragSize).toPx()
    }
    val anchors = mapOf(0f to ConfirmationState.DEFAULT, sizePx to ConfirmationState.CONFIRMED)
    val progress = derivedStateOf {
        if (swipeableState.offset.value == 0f) 0f else swipeableState.offset.value / sizePx
    }

    Box(
        modifier = modifier
            .width(width)
            .swipeable(
                state = swipeableState,
                anchors = anchors,
                thresholds = { _, _ -> FractionalThreshold(0.5f) },
                orientation = Orientation.Horizontal
            )
            .background(Color.Yellow, RoundedCornerShape(dragSize))
    ) {
        Column(
            Modifier
                .align(Alignment.Center)
                .alpha(1f - progress.value),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Send Money",
                color = Color.Black,
                fontSize = 18.sp
            )
            Text(
                text = "Swipe to Confirm",
                color = Color.Black,
                fontSize = 12.sp
            )
        }

        DraggableControl(
            modifier = Modifier
                .offset {
                    IntOffset(swipeableState.offset.value.roundToInt(), 0)
                }
                .size(dragSize),
            progress = progress.value
        )
    }
}