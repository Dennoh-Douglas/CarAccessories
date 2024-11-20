package com.example.mvvm.ui.buy

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.mvvm.navigation.ROUTE_BUY

@Composable
fun Buy(navController: NavController){

    LazyColumn (modifier = Modifier.fillMaxSize()) {







        item {
            Column {


            Spacer(modifier = Modifier.height(100.dp))



           Row {  Column() {

               OutlinedCard {
                   AsyncImage(
                       model = "https://m.media-amazon.com/images/I/71uh7PsjERL._AC_SL1500_.jpg",
                       contentDescription = null,
                       modifier = Modifier
                           .size(200.dp)


                   )


               }

               Text("AUDI")


           }

               Spacer(modifier = Modifier.width(10.dp))

               Column {

                   OutlinedCard() {
                       AsyncImage(
                           model = "https://ind-distribution.com/cdn/shop/products/20880386375_335888aaa8_b_bec891e5-726f-4b7f-927c-e28bb7c85406.jpg",
                           contentDescription = null,
                           modifier = Modifier
                               .size(200.dp)



                       )


                   }

                   Text("BMW")


               } }

            Spacer(modifier = Modifier.height(20.dp))


            Row { Column {

                OutlinedCard() {
                    AsyncImage(
                        model = "https://i.etsystatic.com/35474370/r/il/a5ac3e/3841530058/il_fullxfull.3841530058_1ekh.jpg",
                        contentDescription = null,
                        modifier = Modifier
                            .size(200.dp)


                    )


                }

                Text("MERCEDES")


            }

                Spacer(modifier = Modifier.width(10.dp))


                Column {

                    OutlinedCard() {
                        AsyncImage(
                            model = "https://cdn.webshopapp.com/shops/73499/files/356731499/tbu-car-car-key-cover-compatible-with-mazda-silico.jpg",
                            contentDescription = null,
                            modifier = Modifier
                                .size(200.dp)


                        )


                    }

                    Text("MAZDA")


                } }




                Spacer(modifier = Modifier.height(10.dp))

                Column {

                    Text("Classy Key Covers",
                        modifier = Modifier,
                        fontWeight = FontWeight.SemiBold

                    )
                    Text("Price:Kshs.1000 ",

                        modifier = Modifier,
                        fontWeight = FontWeight.SemiBold

                    )

                    Spacer(modifier = Modifier.height(10.dp))
























                } }




















        }








    }










































}