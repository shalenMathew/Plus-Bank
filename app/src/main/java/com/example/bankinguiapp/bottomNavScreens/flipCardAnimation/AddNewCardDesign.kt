package com.example.bankinguiapp.bottomNavScreens.flipCardAnimation

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.bankinguiapp.R



@Composable
fun AddCardFront(
    flipController: FlippableController
) {
    Box(modifier = Modifier
        .clip(RoundedCornerShape(20.dp))
        .width(330.dp)
        .height(200.dp)
        .clickable {flipController.flip()},
    ) {

        Image(painter = painterResource(id = R.drawable.grad1) ,
            contentDescription ="image",
            contentScale = ContentScale.Crop)

                ConstraintLayout(
                    modifier = Modifier.fillMaxSize()
                        .padding(vertical = 10.dp,
                            horizontal = 15.dp),
                ) {
                    val (visaLogo, cardTitle, cardBalance,cardNo,chipImg) = createRefs()

                    Image(painter = painterResource(id = R.drawable.ic_visa),
                        contentDescription = "cardType",
                        modifier=Modifier.width(60.dp)
                            .constrainAs(visaLogo){
                                   start.linkTo(parent.start)
                                    top.linkTo(parent.top)
                            })


                    Text(text = "xxxx xxxx xxxx xxxx",
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp,
                        modifier = Modifier
                            .constrainAs(cardNo){
                                start.linkTo(parent.start)
                                bottom.linkTo(parent.bottom)
                            })

                    Text(text = "₹ 00.00",
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        modifier = Modifier.constrainAs(cardBalance){
                            start.linkTo(parent.start)
                            bottom.linkTo(cardNo.top)
                        }.padding(bottom = 15.dp))

                    Text(text = "Click to add a new card",
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 15.sp,
                        modifier = Modifier.constrainAs(cardTitle){
                            start.linkTo(parent.start)
                            bottom.linkTo(cardBalance.top)
                        }.padding(bottom = 10.dp))

                }


        }
}


@Composable
fun AddCardBack(
    flipController: FlippableController
) {
    Box(
        modifier = Modifier
    ) {
        Surface(
            modifier = Modifier
                .padding(start=15.dp,end=15.dp,top=10.dp,bottom=5.dp)
                .fillMaxWidth()
                .height(220.dp),
            shape = RoundedCornerShape(20.dp),
            color = Color.White,
        ) {
            Box(
                modifier = Modifier.fillMaxSize()
            ) {
                ConstraintLayout(
                    modifier = Modifier.fillMaxSize()
                ) {
                    val (cardName,cardNo,expDate,addCard) = createRefs()

                    val text1 = remember { mutableStateOf("") }
                    val text2 = remember { mutableStateOf("") }
                    val text3 = remember { mutableStateOf("") }

                    TextField(
                        value = text1.value,
                        onValueChange = { text1.value = it },
                        label = { Text("Card Name") },
                        colors = TextFieldDefaults.colors(
                            focusedContainerColor = Color.White,
                            unfocusedContainerColor = Color.White,
                            disabledContainerColor = Color.White,
                            focusedTextColor = Color.Black,
                            unfocusedTextColor = Color.Black,
                            focusedLabelColor = Color.Black,
                            unfocusedLabelColor = Color.Black
                        ),
                        modifier = Modifier
                            .constrainAs(cardName){
                                start.linkTo(parent.start)
                                top.linkTo(parent.top)
                            }.padding(start=12.dp)
                    )

                    TextField(
                        
                        value = text2.value,
                        onValueChange = { text2.value = it },
                        label = { Text("Card Number", style = TextStyle(fontSize = 15.sp))},
                        colors = TextFieldDefaults.colors(
                            focusedContainerColor = Color.White,
                            unfocusedContainerColor = Color.White,
                            disabledContainerColor = Color.White,
                            focusedTextColor = Color.Black,
                            unfocusedTextColor = Color.Black,
                            focusedLabelColor = Color.Black,
                            unfocusedLabelColor = Color.Black
                        ),
                        modifier = Modifier
                            .constrainAs(cardNo){
                                start.linkTo(parent.start)
                                top.linkTo(cardName.bottom)
                            }.padding(start=12.dp))



                    TextField(
                        value = text3.value,
                        onValueChange = { text3.value = it },
                        label = { Text("Card Validity", style = TextStyle(fontSize = 15.sp))},
                        colors = TextFieldDefaults.colors(
                            focusedContainerColor = Color.White,
                            unfocusedContainerColor = Color.White,
                            disabledContainerColor = Color.White,
                            focusedTextColor = Color.Black,
                            unfocusedTextColor = Color.Black,
                            focusedLabelColor = Color.Black,
                            unfocusedLabelColor = Color.Black
                        ),
                        modifier = Modifier
                            .constrainAs(expDate){
                                start.linkTo(parent.start)
                                top.linkTo(cardNo.bottom)
                            }.padding(start=12.dp))


                    Text(fontSize = 16.sp,
                        text = "ADD CARD!",
                        style = MaterialTheme.typography.labelSmall,
                        color = Color(0xFF3588C7),
                        maxLines = 1,
                        modifier = Modifier
                            .constrainAs(addCard) {
                                end.linkTo(parent.end)
                                bottom.linkTo(parent.bottom)
                            }
                            .padding(bottom = 12.dp, end = 16.dp)
                            .clickable(
                                indication = rememberRipple(color = MaterialTheme.colorScheme.primary),
                                interactionSource = remember { MutableInteractionSource() },
                            ) {
                                flipController.flip()
                            }
                    )
                }
            }
        }
    }
}




















