package com.example.bankinguiapp.homeDesign

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview
@Composable
fun WalletSection(){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp,5.dp,15.dp,15.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Column {
            Text(text = "Wallet",
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold)

            Spacer(modifier = Modifier.height(10.dp))

            Text(text = "₹ 80.91",
                color= Color.White,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Box(modifier= Modifier
            .clip(RoundedCornerShape(15.dp))
            .size(40.dp)
            .background(Color.White)
            .clickable { }
            ,
            contentAlignment = Alignment.Center) {

            Icon(imageVector = Icons.Rounded.Search,
                contentDescription ="Search",
                tint = Color.Black,)
        }

    }
}
