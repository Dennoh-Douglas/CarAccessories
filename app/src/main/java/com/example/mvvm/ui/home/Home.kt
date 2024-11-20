package com.example.mvvm.ui.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.mvvm.navigation.ROUTE_INSERT
import com.example.mvvm.navigation.ROUTE_INSERTPRODUCT2
import com.example.mvvm.navigation.ROUTE_SHOPPAGE
import com.example.mvvm.navigation.ROUTE_VIEWPRODUCTS
import com.example.mvvm.navigation.insert


@Composable
fun Home(

    navController: NavController

) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .fillMaxHeight()
            .fillMaxWidth(),


        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround


    ) {


//        Text("Home Screen")




        Spacer(
            modifier = Modifier
                .padding(20.dp)
        )

        AsyncImage(
            model = "https://www.carpockets.co.ke/cdn/shop/files/Carpockets_Logo-Registered-01_31503d73-b73f-4b1b-924c-75629927e2cf.png",
            contentDescription = null,
            modifier = Modifier


        )



        Spacer(modifier = Modifier.padding(20.dp))
//
        Button(onClick = { navController.navigate(ROUTE_INSERTPRODUCT2) }) {

            Text("INSERT")


        }


//
//
//        Button(onClick = { navController.navigate(ROUTE_VIEWPRODUCTS) }) {
//
//            Text("VIEW")
//
//
//        }

        Button(onClick = { navController.navigate(ROUTE_SHOPPAGE) }) {

            Text("SHOP")


        }





    }

}





















