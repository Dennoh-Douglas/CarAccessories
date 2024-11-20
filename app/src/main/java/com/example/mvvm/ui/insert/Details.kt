package com.example.mvvm.ui.insert



import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.example.mvvm.navigation.ROUTE_INSERT
import com.example.mvvm.navigation.ROUTE_SHOPPAGE
import com.example.mvvm.navigation.ROUTE_VIEWPRODUCTS
import com.google.firebase.firestore.FirebaseFirestore

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun DetailsScreen(productId: String, navController: NavController) {
    var product by remember { mutableStateOf<Product?>(null) }
    var isLoading by remember { mutableStateOf(true) }

    val firestore = FirebaseFirestore.getInstance()

    // Fetch product details from Firestore using product ID
    LaunchedEffect(productId) {
        firestore.collection("products").document(productId)
            .get()
            .addOnSuccessListener { documentSnapshot ->
                product = documentSnapshot.toObject(Product::class.java)
                isLoading = false
            }
            .addOnFailureListener {
                isLoading = false
            }
    }


    Scaffold(
        topBar = {   },
        content = {
            Column(
                modifier = Modifier
                    .windowInsetsPadding(WindowInsets.systemBars)
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                if (isLoading) {
                    CircularProgressIndicator()
                } else if (product == null) {
                    Text(text = "Product not found", fontSize = 20.sp, color = Color.Gray)
                } else {
                    ProductDetails(product!!)
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
                    androidx.compose.material3.Icon(
                        imageVector = Icons.Default.Home, "",
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
                    androidx.compose.material3.Icon(
                        imageVector = Icons.Default.Menu,
                        "",
                        tint = Color.White
                    )
                },
                    label = { Text(text = "Shop", color = Color.White ) },
                    selected = (selectedIndex.value == 1),
                    onClick = {
                        navController.navigate(ROUTE_VIEWPRODUCTS)
                        selectedIndex.value = 1
                    })

                BottomNavigationItem(icon = {
                    androidx.compose.material3.Icon(
                        imageVector = Icons.Default.Create,
                        "",
                        tint = Color.White
                    )
                },
                    label = { Text(text = "Insert", color = Color.White ) },
                    selected = (selectedIndex.value == 2),
                    onClick = {
                        navController.navigate(ROUTE_INSERT)
                        selectedIndex.value = 2
                    })

                BottomNavigationItem(icon = {
                    androidx.compose.material3.Icon(imageVector = Icons.Default.Person, "", tint = Color.White)
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


@Composable
fun ProductDetails(product: Product) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .background(Color(0xFF515a5a  ), RoundedCornerShape(12.dp))
            .padding(16.dp), // Inner padding for content
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        Box(
            modifier = Modifier
                .height(200.dp)
                .fillMaxWidth()
                .background(Color(0xFFF1F1F1), RoundedCornerShape(12.dp))
        ) {
            product.image?.let {
                Image(
                    painter = rememberImagePainter(it),
                    contentDescription = "Product Image",
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(RoundedCornerShape(12.dp)),
                    contentScale = ContentScale.Crop
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = product.name,
            fontSize = 24.sp,
            color = Color.White,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Price: ${product.price}",
            fontSize = 20.sp,
            color = Color(0xFFF2e86c1),
            fontWeight = FontWeight.Medium
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = product.description,
            fontSize = 16.sp,
            color = Color.Red,
            lineHeight = 20.sp
        )
    }
}