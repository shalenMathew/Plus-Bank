package com.example.bankinguiapp.homeDesign

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.wear.compose.material.Text
import com.example.bankinguiapp.R
import com.example.bankinguiapp.homeDesign.dataClass.Card


val cards:List<Card> = listOf(
    Card(cardType = "VISA",
        cardName = "Business Card",
        cardNo = "3664 7865 3786 3976",
        balance = "₹ 27.90",
        cardBack = R.drawable.grad3),

    Card(cardType = "MASTER CARD",
        cardName = "Savings",
        cardNo = "234 7583 7899 2223",
        balance = "₹ 100.00",
        cardBack = R.drawable.grad4),

    Card(cardType = "VISA",
        cardName = "School",
        cardNo = "0078 3467 3446 7899",
        balance = "₹ 200.00",
        cardBack = R.drawable.grad5),

    Card(cardType = "MASTER CARD",
        cardName = "Trips",
        cardNo = "3567 7865 3786 3976",
        balance = "₹ 10.00",
        cardBack = R.drawable.grad2)

)

@Preview
@Composable
fun CardSection(){

    LazyRow {
        items(cards.size){index->
CardItem(index = index)
        }
    }
}


@Composable
fun  CardItem(index:Int){

    val currCard = cards[index]

    Box(modifier = Modifier
        .padding(12.dp, 0.dp, 15.dp, 0.dp)
        .clip(RoundedCornerShape(20.dp))
        .width(290.dp)
        .height(190.dp)
        ) {

        val cardLogo:Int?

        if (currCard.cardType=="VISA"){
            cardLogo=R.drawable.ic_visa
        }else{
            cardLogo=R.drawable.ic_mastercard
        }

        Image(painter = painterResource(id = currCard.cardBack) ,
            contentDescription ="image",
            contentScale = ContentScale.Crop)

        Column (modifier= Modifier
            .clickable {}
            .padding(vertical = 10.dp, horizontal = 15.dp)
            .fillMaxSize(),
            verticalArrangement = Arrangement.SpaceAround){

            Image(painter = painterResource(id = cardLogo),
                contentDescription = currCard.cardType,
                modifier=Modifier.width(60.dp))

            Spacer(modifier = Modifier.height(10.dp))

Text(text = currCard.cardName,
    color = Color.White,
    fontWeight = FontWeight.Bold,
    fontSize = 15.sp)

            Text(text = currCard.balance,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp)

            Text(text = currCard.cardNo,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp)

        }

}
}

