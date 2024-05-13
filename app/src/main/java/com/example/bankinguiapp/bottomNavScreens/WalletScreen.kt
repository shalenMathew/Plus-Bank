package com.example.bankinguiapp.bottomNavScreens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.bankinguiapp.R
import com.example.bankinguiapp.bottomNavScreens.flipCardAnimation.AddCardBack
import com.example.bankinguiapp.bottomNavScreens.flipCardAnimation.AddCardFront
import com.example.bankinguiapp.bottomNavScreens.flipCardAnimation.FlipAnimationType
import com.example.bankinguiapp.bottomNavScreens.flipCardAnimation.Flippable
import com.example.bankinguiapp.bottomNavScreens.flipCardAnimation.rememberFlipController
import com.example.bankinguiapp.bottomNavScreens.slider.ConfirmationButton

@Preview
@Composable
fun WalletScreen(){

    Box(modifier = Modifier.fillMaxSize()){

        Column(modifier = Modifier.fillMaxSize()) {

            val duration: Int by remember { mutableStateOf(400) }
            val flipOnTouchEnabled: Boolean by remember { mutableStateOf(true) }
            val flipEnabled: Boolean by remember { mutableStateOf(true) }
            val autoFlipEnabled: Boolean by remember { mutableStateOf(false) }
            val selectedAnimType: FlipAnimationType by remember { mutableStateOf(
                FlipAnimationType.VERTICAL_ANTI_CLOCKWISE
            ) }
            val flipController = rememberFlipController()

            Text(text = "Add a new card",
                color = Color.White,
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = 15.dp,top=12.dp))

            Flippable(
                frontSide = { AddCardFront(flipController = flipController) },
                backSide = { AddCardBack(flipController = flipController) },
                flipController = flipController,
                flipDurationMs = duration,
                flipOnTouch = flipOnTouchEnabled,
                flipEnabled = flipEnabled,
                autoFlip = autoFlipEnabled,
                autoFlipDurationMs = 2000,
                flipAnimationType = selectedAnimType
            )

            Box(modifier= Modifier
                .fillMaxSize(),
                contentAlignment = Alignment.BottomCenter
                ){

                Column {
                    Text(text ="Send Money",
                        color= Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 25.sp,
                        modifier = Modifier.padding(start = 12.dp, bottom = 12.dp))

                    Box(modifier= Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
                        .background(Color.Green)
                    ) {

                        Image(modifier = Modifier.fillMaxSize(),
                            painter = painterResource(id = R.drawable.grad6),
                            contentDescription = "back",
                            contentScale = ContentScale.Crop)


                        ConstraintLayout (modifier=Modifier.fillMaxSize()){

                            val (row,slider) = createRefs()

                            Row(modifier= Modifier
                                .fillMaxWidth()
                                .padding(top = 25.dp)
                                .constrainAs(row) {
                                    start.linkTo(parent.start)
                                    end.linkTo(parent.end)
                                    top.linkTo(parent.top)
                                }, horizontalArrangement = Arrangement.Center){


                                Box(modifier= Modifier
                                    .clip(RoundedCornerShape(30.dp))
                                    .width(130.dp)
                                    .height(60.dp)
                                    .background(Color.Black)
                                    .clickable {}
                                    ,
                                    contentAlignment = Alignment.Center
                                ){

                                    Text(text = "Request",
                                        color = Color.White)
                                }

                                Box(modifier= Modifier
                                    .padding(start = 12.dp)
                                    .clip(RoundedCornerShape(30.dp))
                                    .width(130.dp)
                                    .height(60.dp)
                                    .background(Color.White)
                                    .clickable {}
                                    ,
                                    contentAlignment = Alignment.Center
                                ){

                                    Text(text = "Send",
                                        color = Color.Black)
                                }

                            }

                            ConfirmationButton(modifier = Modifier
                                .constrainAs(slider){
                                    bottom.linkTo(parent.bottom)
                                    end.linkTo(parent.end)
                                    start.linkTo(parent.start)
                                }
                                .padding(bottom=20.dp))

                        }

                    }
                }

            }

        }

    }
}

