package com.example.bankinguiapp.homeDesign

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Analytics
import androidx.compose.material.icons.rounded.MonetizationOn
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material.icons.rounded.Wallet
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.wear.compose.material.Icon
import androidx.wear.compose.material.Text
import com.example.bankinguiapp.homeDesign.dataClass.Finance
import com.example.bankinguiapp.ui.theme.BlueStart
import com.example.bankinguiapp.ui.theme.GreenStart
import com.example.bankinguiapp.ui.theme.OrangeStart
import com.example.bankinguiapp.ui.theme.PurpleGrey40
import com.example.bankinguiapp.ui.theme.PurpleStart

val financeList:List<Finance> = listOf(
    Finance(icon = Icons.Rounded.Star,
        name = "My\nFavourites",
        backColor = OrangeStart ),
    Finance(icon = Icons.Rounded.Wallet,
        name = "My\nWallet",
        backColor = BlueStart ),
    Finance(icon = Icons.Rounded.MonetizationOn,
        name = "My\nTransaction",
        backColor = GreenStart ),
    Finance(icon = Icons.Rounded.Analytics,
        name = "Finance\nAnalytics",
        backColor = PurpleStart )

    )


@Preview
@Composable
fun FinanceSection(){


    Column(modifier=Modifier.padding(end = 12.dp)) {

        Text(text = "Finance",
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 25.sp,
            modifier = Modifier.padding(15.dp,0.dp,0.dp,12.dp)
            )

        LazyRow {
            items(financeList.size){index->
                FinanceItem(index = index)
            }
        }


    }



//    FinanceItem()
}


@Composable
fun FinanceItem(index:Int){

    val financeItem = financeList[index]

    Box(modifier = Modifier
        .padding(12.dp, 0.dp, 0.dp, 12.dp)
        .clip(RoundedCornerShape(20.dp))
        .width(140.dp)
        .height(100.dp)
        .background(PurpleGrey40)
        .clickable {}
        ){

        Column(modifier= Modifier
            .fillMaxSize()
            .padding(vertical = 8.dp, horizontal = 12.dp),
            verticalArrangement = Arrangement.SpaceBetween) {


            Box(modifier= Modifier
                .clip(RoundedCornerShape(20.dp))
                .background(financeItem.backColor)
                .padding(2.dp)){

                Icon(imageVector = financeItem.icon,
                    contentDescription ="icon",
                    tint = Color.White,
                    modifier=Modifier.size(25.dp))
            }

            Text(text = financeItem.name,
                color= Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold
                )


        }
    }

}