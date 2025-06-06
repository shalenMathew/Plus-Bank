package com.example.bankinguiapp


import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.OptIn
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import androidx.media3.common.MediaItem
import androidx.media3.common.Player
import androidx.media3.common.util.UnstableApi
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.bankinguiapp.bottomNav.BottomNavigationBar
import com.example.bankinguiapp.bottomNavScreens.Account
import com.example.bankinguiapp.bottomNavScreens.HomeScreen
import com.example.bankinguiapp.bottomNavScreens.Notification
import com.example.bankinguiapp.bottomNavScreens.Screens
import com.example.bankinguiapp.bottomNavScreens.WalletScreen
import com.example.bankinguiapp.ui.theme.BankingUiAppTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BankingUiAppTheme {

                SetBarColor(color = Color.Black)

                BottomNavSetUp()
            }
        }
    }

    // changing status bar color
    @Composable
    fun SetBarColor(color: Color){
        val systemUiController = rememberSystemUiController()
        SideEffect {
            systemUiController.setSystemBarsColor(
                color = color
            )
        }
    }


    fun getVideoUri(): Uri {
        val rawId = resources.getIdentifier("back","raw",packageName)
        val videoUri = "android.resource://$packageName/$rawId"
        return Uri.parse(videoUri)
    }

    private fun Context.buildExoPlayer(uri: Uri) = ExoPlayer.Builder(this).build().apply {
        setMediaItem(MediaItem.fromUri(uri))
        repeatMode= Player.REPEAT_MODE_ALL
        playWhenReady=true
        prepare()
    }

    @OptIn(UnstableApi::class)
    private fun Context.buildPlayerView(exoPlayer: ExoPlayer) =
        PlayerView(this).apply {
            player = exoPlayer
            layoutParams = FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
            useController = false
            resizeMode = androidx.media3.ui.AspectRatioFrameLayout.RESIZE_MODE_ZOOM
        }


    @Preview
    @Composable
    fun BottomNavBar() {

        val navController = rememberNavController()


        Scaffold(
            bottomBar = {
                BottomNavigationBar(navController)
            },
            containerColor = Color.Transparent
        ) { padding ->

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
                    .background(Color.Transparent)
            ) {

                NavHost(navController = navController,
                    startDestination = Screens.Home.route){
                    composable(Screens.Home.route){ HomeScreen() }
                    composable(Screens.Wallet.route){ WalletScreen() }
                    composable(Screens.Notification.route){ Notification() }
                    composable(Screens.Account.route){ Account() }
                }
            }

        }
    }

    @Preview
    @Composable
    fun BottomNavSetUp(){

        Surface(modifier = Modifier.fillMaxSize(),
            color = Color.Black) {

            val context = LocalContext.current
            val exoPlayer = remember {
                context.buildExoPlayer(getVideoUri())
            }

            DisposableEffect(
                AndroidView(factory = {it.buildPlayerView(exoPlayer)},modifier= Modifier.fillMaxSize())
            ) {
                onDispose {
                    exoPlayer.release()
                }
            }
            BottomNavBar()
        }
    }


}

