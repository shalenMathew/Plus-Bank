package com.example.bankinguiapp.bottomNavScreens.flipCardAnimation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow

class FlippableController internal constructor() {
    private val _flipRequests = MutableSharedFlow<FlippableState>(extraBufferCapacity = 1)
    internal val flipRequests = _flipRequests.asSharedFlow()
    private var _currentSide: FlippableState = FlippableState.FRONT
    private var _flipEnabled: Boolean = true

    fun flipToFront() {
        flip(FlippableState.FRONT)
    }

    fun flipToBack() {
        flip(FlippableState.BACK)
    }

    fun flip(front: FlippableState) {
        if (_flipEnabled.not())
            return

        _currentSide = front
        _flipRequests.tryEmit(front)
    }

    fun flip() {
        if (_currentSide == FlippableState.FRONT)
            flipToBack()
        else
            flipToFront()
    }

    internal fun setConfig(
        flipEnabled: Boolean = true
    ) {
        _flipEnabled = flipEnabled
    }
}

@Composable
fun rememberFlipController(): FlippableController {
    return remember {
        FlippableController()
    }
}











