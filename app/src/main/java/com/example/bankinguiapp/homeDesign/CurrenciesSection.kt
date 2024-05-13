package com.example.bankinguiapp.homeDesign

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AttachMoney
import androidx.compose.material.icons.rounded.CurrencyYen
import androidx.compose.material.icons.rounded.Euro
import androidx.compose.material.icons.rounded.KeyboardArrowDown
import androidx.compose.material.icons.rounded.KeyboardArrowUp
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.wear.compose.material.Icon
import androidx.wear.compose.material.Text
import com.example.bankinguiapp.homeDesign.dataClass.Currency
import com.example.bankinguiapp.ui.theme.GreenStart
import com.example.bankinguiapp.ui.theme.PurpleGrey40

val currencies = listOf(
    Currency(
        name = "USD",
        buy = 23.35f,
        sell = 23.25f,
        icon = Icons.Rounded.AttachMoney
    ),

    Currency(
        name = "EUR",
        buy = 13.35f,
        sell = 13.25f,
        icon = Icons.Rounded.Euro
    ),

    Currency(
        name = "YEN",
        buy = 26.35f,
        sell = 26.35f,
        icon = Icons.Rounded.CurrencyYen
    ),

    Currency(
        name = "USD",
        buy = 23.35f,
        sell = 23.25f,
        icon = Icons.Rounded.AttachMoney
    ),

    Currency(
        name = "EUR",
        buy = 63.35f,
        sell = 73.25f,
        icon = Icons.Rounded.Euro
    ),

    Currency(
        name = "YEN",
        buy = 16.35f,
        sell = 16.35f,
        icon = Icons.Rounded.CurrencyYen
    ),
)


@Preview
@Composable
fun CurrenciesSection(){

    var isVisible by remember {
        mutableStateOf(false)
    }

    var iconState by remember{
        mutableStateOf(Icons.Rounded.KeyboardArrowUp)
    }

Box(modifier = Modifier
    .fillMaxSize(),
    contentAlignment = Alignment.BottomCenter,
    ){


    Column(modifier= Modifier
        .clip(RoundedCornerShape(topStart = 25.dp, topEnd = 25.dp))
        .background(PurpleGrey40)
        .animateContentSize()) {

        Row(modifier = Modifier
            .padding(12.dp)
            .fillMaxWidth()
            .animateContentSize(),
            verticalAlignment = Alignment.CenterVertically) {

            Box(modifier = Modifier
                .clip(RoundedCornerShape(25.dp))
                .size(25.dp)
                .background(Color.White)
                .clickable {
                    isVisible = !isVisible
                    iconState = if (isVisible) {
                        Icons.Rounded.KeyboardArrowDown
                    } else {
                        Icons.Rounded.KeyboardArrowUp
                    }
                },
                contentAlignment = Alignment.Center
               ){

                Icon(imageVector = iconState,
                    tint = Color.Black,
                    contentDescription = "",
                    modifier = Modifier.size(25.dp))
            }

            Text(text = "Currencies",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = 18.dp),
                fontSize = 23.sp)
        }

        if(isVisible){

            BoxWithConstraints(modifier= Modifier
                .fillMaxSize()
                .padding(horizontal = 15.dp)) {

                val boxWithConstraintsScope =this
                val width=boxWithConstraintsScope.maxWidth/3

                Column(modifier= Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(topStart = 25.dp, topEnd = 25.dp))
                    .background(Color.Black)
                    .padding(horizontal = 18.dp)) {

                    Row(modifier= Modifier
                        .fillMaxWidth()
                        .padding(top = 12.dp)) {
                        Text(modifier = Modifier.width(width),
                            text = "Currency",
                            fontWeight = FontWeight.SemiBold,
                            color = Color.White,
                            fontSize = 15.sp)

                        Text(modifier = Modifier.width(width),
                            text = "Buy",
                            fontWeight = FontWeight.SemiBold,
                            color = Color.White,
                            fontSize = 15.sp,
                            textAlign = TextAlign.End)

                        Text(modifier = Modifier.width(width),
                            text = "Sell",
                            fontWeight = FontWeight.SemiBold,
                            color = Color.White,
                            fontSize = 15.sp,
                            textAlign = TextAlign.End)
                    }

                    Spacer(modifier = Modifier.height(2.dp))

                    LazyColumn {
                        items(currencies.size){
                            CurrencyItem(it,width)
                        }
                    }


                }

            }
        }


    }

}

}

@Composable
fun CurrencyItem(index:Int,width: Dp){

    val curr = currencies[index]

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Row(
            modifier = Modifier.width(width),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(8.dp))
                    .background(GreenStart)
                    .size(23.dp),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    modifier = Modifier.size(15.dp),
                    imageVector = curr.icon,
                    contentDescription = curr.name,
                    tint = Color.White
                )
            }

            Text(
                modifier = Modifier
                    .padding(start = 10.dp),
                text = curr.name,
                fontWeight = FontWeight.Bold,
                fontSize = 15.sp,
                color = Color.White,
            )
        }

        Text(
            modifier = Modifier
                .width(width)
                .padding(start = 10.dp),
            text = "$ ${curr.buy}",
            fontWeight = FontWeight.Bold,
            fontSize = 15.sp,
            color = Color.White,
            textAlign = TextAlign.End
        )

       Text(
            modifier = Modifier
                .width(width)
                .padding(start = 10.dp),
            text = "$ ${curr.sell}",
            fontWeight = FontWeight.Bold,
            fontSize = 15.sp,
            color = Color.White,
            textAlign = TextAlign.End
        )

    }

}
