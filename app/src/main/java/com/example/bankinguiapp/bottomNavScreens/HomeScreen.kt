package com.example.bankinguiapp.bottomNavScreens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bankinguiapp.homeDesign.CardSection
import com.example.bankinguiapp.homeDesign.CurrenciesSection
import com.example.bankinguiapp.homeDesign.FinanceSection
import com.example.bankinguiapp.homeDesign.WalletSection


@Preview
@Composable
fun HomeScreen(){

    Column() {
        WalletSection()
        CardSection()
        Spacer(modifier = Modifier.height(15.dp))
        FinanceSection()
        CurrenciesSection()
    }
}