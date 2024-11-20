package com.example.mvvm.ui

import android.annotation.SuppressLint
import android.content.ClipData.Item
import android.graphics.ColorFilter
import android.graphics.drawable.Icon
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.mvvm.navigation.ROUTE_BUY
import com.example.mvvm.navigation.ROUTE_HOME
import com.example.mvvm.navigation.ROUTE_INSERT
import com.example.mvvm.navigation.ROUTE_SHOPPAGE
import com.example.mvvm.navigation.ROUTE_VIEWPRODUCTS


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun shoppage(navController: NavController){


    Scaffold(
        topBar = {   },
        content = {

            LazyColumn {
                item {


                    Column {

                        Spacer(modifier = Modifier.height(50.dp))

                        Row (Modifier.fillMaxSize()){





                            var text by remember { mutableStateOf(TextFieldValue("")) }
                            OutlinedTextField(
                                value = text,
                                leadingIcon = { Icon(imageVector = Icons.Default.Search, contentDescription = "searchIcon") },



                                onValueChange = {
                                    text = it
                                },
                                label = { Text(text = "Search") },
                                placeholder = { Text(text = "Search Product Here") },
                            )

                            Spacer(modifier = Modifier.width(70.dp))
                            AsyncImage(
                                model = "https://www.shutterstock.com/image-vector/shopping-cart-icon-flat-design-600nw-570153007.jpg",
                                contentDescription = null,
                                modifier = Modifier
                                    .size(75.dp)
                                    .clip(CircleShape)
//                            .border(2.dp, Color.Black, CircleShape)
                                    .background(color = Color.White)
                                    .clickable { navController.navigate(ROUTE_INSERT) }



                            )




                        }






                        Spacer(modifier = Modifier.height(50.dp))

                        Row (
                            modifier = Modifier
//                       .fillMaxWidth()
                                .fillMaxSize()


                        ){

                            Text(



                                "High-End Brands",

                                modifier = Modifier,
                                style = TextStyle(fontSize = 20.sp),
                                fontWeight = FontWeight.SemiBold





                            )


                        }






                        Spacer(modifier = Modifier.height(20.dp))
                        LazyRow (
                            modifier = Modifier
                                .fillMaxWidth()
                                .fillMaxSize()
                                .fillMaxHeight()
                        ) {


                            item {


                                Column(
                                    modifier = Modifier,

                                    verticalArrangement = Arrangement.Center,
                                    horizontalAlignment = Alignment.CenterHorizontally

                                ) {

                                    AsyncImage(
                                        model = "https://i.pinimg.com/originals/21/c2/fe/21c2fe7847dbc1b098500fbe58f5ecee.jpg",
                                        contentDescription = null,
                                        modifier = Modifier
                                            .size(100.dp)
                                            .clip(CircleShape)
                                            .border(2.dp, Color.Black, CircleShape)
                                            .background(color = Color.Black)
                                            .clickable { navController.navigate(ROUTE_VIEWPRODUCTS) }


                                    )
                                    Spacer(modifier = Modifier.height(5.dp))

                                    Text(
                                        "Mazda",
                                        modifier = Modifier,
                                        fontWeight = FontWeight.SemiBold

                                    )


                                }
                                Spacer(modifier = Modifier.width(4.dp))



                                Column(

                                    modifier = Modifier,

                                    verticalArrangement = Arrangement.Center,
                                    horizontalAlignment = Alignment.CenterHorizontally

                                ) {

                                    AsyncImage(
                                        model = "https://i.pinimg.com/originals/b9/2b/f1/b92bf19612e524ac1f9d5e998770eba7.jpg",
                                        contentDescription = null,
                                        modifier = Modifier
                                            .size(100.dp)
                                            .clip(CircleShape)
                                            .border(2.dp, Color.Black, CircleShape)
                                            .background(color = Color.Black)
                                            .clickable { navController.navigate(ROUTE_VIEWPRODUCTS) }


                                    )
                                    Spacer(modifier = Modifier.height(5.dp))

                                    Text(
                                        "Mercedes",
                                        modifier = Modifier,
                                        fontWeight = FontWeight.SemiBold


                                    )


                                }

                                Spacer(modifier = Modifier.width(4.dp))



                                Column(

                                    modifier = Modifier,

                                    verticalArrangement = Arrangement.Center,
                                    horizontalAlignment = Alignment.CenterHorizontally

                                ) {

                                    AsyncImage(
                                        model = "https://blog.logomaster.ai/hs-fs/hubfs/bmw-logo-1997.jpg?width=672&height=454&name=bmw-logo-1997.jpg",
                                        contentDescription = null,
                                        modifier = Modifier
                                            .size(100.dp)
                                            .clip(CircleShape)
                                            .border(2.dp, Color.Black, CircleShape)
                                            .clickable { navController.navigate(ROUTE_VIEWPRODUCTS) }


                                    )
                                    Spacer(modifier = Modifier.height(5.dp))

                                    Text(

                                        "BMW",
                                        modifier = Modifier,
                                        fontWeight = FontWeight.SemiBold

                                    )


                                }


                                Spacer(modifier = Modifier.width(4.dp))



                                Column(

                                    modifier = Modifier,

                                    verticalArrangement = Arrangement.Center,
                                    horizontalAlignment = Alignment.CenterHorizontally

                                ) {

                                    AsyncImage(
                                        model = "https://uploads.audi-mediacenter.com/system/production/media/1282/images/bde751ee18fe149036c6b47d7595f6784f8901f8/AL090142_web_2880.jpg",
                                        contentDescription = null,
                                        modifier = Modifier
                                            .size(100.dp)
                                            .clip(CircleShape)
                                            .border(2.dp, Color.Black, CircleShape)
                                            .clickable { navController.navigate(ROUTE_VIEWPRODUCTS) }


                                    )
                                    Spacer(modifier = Modifier.height(5.dp))

                                    Text(
                                        "Audi",
                                        modifier = Modifier,
                                        fontWeight = FontWeight.SemiBold

                                    )


                                }


                            }
                        }

                        Spacer(modifier = Modifier.height(10.dp))



                        Text(
                            "Best Products",
                            modifier = Modifier,
                            style = TextStyle(fontSize = 20.sp),
                            fontWeight = FontWeight.SemiBold



                        )

                        Spacer(modifier = Modifier.height(7.dp))

                        LazyRow(modifier = Modifier.fillMaxWidth()) {

                            item {

                                Column() {

                                    OutlinedCard {
                                        AsyncImage(
                                            model = "https://autojin.ae/cdn/shop/files/Car-Clock-Tissue-Box2.jpg?v=1716816438&width=1445.png",
                                            contentDescription = null,
                                            modifier = Modifier
                                                .size(100.dp)
                                                .clickable { navController.navigate(ROUTE_VIEWPRODUCTS ) }


                                        )


                                    }

                                    Text(
                                        "Classy Tissue Box",
                                        modifier = Modifier,
                                        fontWeight = FontWeight.SemiBold

                                    )


                                }

                                Spacer(modifier = Modifier.width(10.dp))

                                Column {

                                    OutlinedCard() {
                                        AsyncImage(
                                            model = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRcl1QNeOigJTq8__UGG7DbYQK3-cEjsSLp9iX9oFi55qOY2gQVbjXk5d-DdK2Itgeuxqo&usqp=CAU.png",
                                            contentDescription = null,
                                            modifier = Modifier
                                                .size(100.dp)
                                                .clickable { navController.navigate(
                                                    ROUTE_VIEWPRODUCTS) }



                                        )


                                    }

                                    Text(
                                        "Classy Perfume",
                                        modifier = Modifier,
                                        fontWeight = FontWeight.SemiBold
                                    )


                                }

                                Spacer(modifier = Modifier.width(10.dp))


                                Column {

                                    OutlinedCard() {
                                        AsyncImage(
                                            model = "https://i.etsystatic.com/35474370/r/il/a5ac3e/3841530058/il_fullxfull.3841530058_1ekh.jpg",
                                            contentDescription = null,
                                            modifier = Modifier
                                                .size(100.dp)
                                                .clickable { navController.navigate(ROUTE_VIEWPRODUCTS ) }


                                        )


                                    }

                                    Text(
                                        "Classy key cover",

                                        modifier = Modifier,
                                        fontWeight = FontWeight.SemiBold
                                    )


                                }

                                Spacer(modifier = Modifier.width(10.dp))


                                Column {

                                    OutlinedCard() {
                                        AsyncImage(
                                            model = "https://www.carpockets.co.ke/cdn/shop/products/bmw-carpocket-at-carpockets-nairobi-kenya-1.jpg?crop=center&height=720&v=1701801308&width=720.png",
                                            contentDescription = null,
                                            modifier = Modifier
                                                .size(100.dp)
                                                .clickable { navController.navigate(ROUTE_VIEWPRODUCTS ) }


                                        )


                                    }

                                    Text(

                                        "Insurance Pocket",

                                        modifier = Modifier,
                                        fontWeight = FontWeight.SemiBold

                                    )


                                }


















                            }
                        }




                        AsyncImage(
                            model = "https://images.unsplash.com/photo-1521410195597-69e2218fcee8?q=80&w=1374&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D.png",
                            contentDescription = null,
                            modifier = Modifier
                                .size(500.dp),






                            )








//








































































                    }


                }






















            }

        },
        bottomBar = {

            val selectedIndex = remember { mutableStateOf(0) }


            BottomNavigation(

                elevation = 10.dp,
                modifier = Modifier.windowInsetsPadding(WindowInsets.systemBars),
                backgroundColor = Color.DarkGray


            ) {

                BottomNavigationItem(icon = {
                    Icon(
                        imageVector = Icons.Default.Home,"",
                        tint = Color.White

                        )
                },
                    label = { Text(text = "Home", color = Color.White )},
                    selected = (selectedIndex.value == 0),
                    onClick = {
                        navController.navigate(ROUTE_SHOPPAGE)
                        selectedIndex.value = 0
                    })

                BottomNavigationItem(icon = {
                    Icon(imageVector = Icons.Default.Menu,"", tint = Color.White)
                },
                    label = { Text(text = "Shop", color = Color.White ) },
                    selected = (selectedIndex.value == 1),
                    onClick = {
                        navController.navigate(ROUTE_VIEWPRODUCTS)
                        selectedIndex.value = 1
                    })

                BottomNavigationItem(icon = {
                    Icon(imageVector = Icons.Default.Create,"", tint = Color.White)
                },
                    label = { Text(text = "Insert", color = Color.White ) },
                    selected = (selectedIndex.value == 2),
                    onClick = {
                        navController.navigate(ROUTE_INSERT)
                        selectedIndex.value = 2
                    })

                BottomNavigationItem(icon = {
                    Icon(imageVector = Icons.Default.Person,"",tint = Color.White)
                },
                    label = { Text(text = "Account", color = Color.White ) },
                    selected = (selectedIndex.value == 2),
                    onClick = {
                        selectedIndex.value = 2
                    })
            }


        }
    )












}