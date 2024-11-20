package com.example.mvvm.ui.insert

import android.annotation.SuppressLint
import android.net.Uri
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.example.mvvm.navigation.ROUTE_HOME
import com.example.mvvm.navigation.ROUTE_INSERT
import com.example.mvvm.navigation.ROUTE_SHOPPAGE
import com.example.mvvm.navigation.ROUTE_VIEWPRODUCTS
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun InsertProductsScreen(navController: NavController) {
    var productName by remember { mutableStateOf("") }
    var productPrice by remember { mutableStateOf("") }
    var productDescription by remember { mutableStateOf("") }
    var productImageUri by remember { mutableStateOf<Uri?>(null) }
    var uploading by remember { mutableStateOf(false) }

    val firestore = FirebaseFirestore.getInstance()
    val storage = FirebaseStorage.getInstance().reference
    val context = LocalContext.current

    val imagePickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        productImageUri = uri
    }



    Scaffold(
        topBar = {  },
                    content = {

                        Spacer(modifier = Modifier.height(50.dp))
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(16.dp),
                            verticalArrangement = Arrangement.Top,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {

                            Spacer(modifier = Modifier.height(50.dp))

                            Text("Insert Product", fontSize = 24.sp, color = Color.Black)

                            OutlinedTextField(
                                value = productName,
                                onValueChange = { productName = it },
                                label = { Text("Product Name") },
                                modifier = Modifier.fillMaxWidth()
                            )

                            Spacer(modifier = Modifier.height(8.dp))

                            OutlinedTextField(
                                value = productPrice,
                                onValueChange = { productPrice = it },
                                label = { Text("Product Price") },
                                modifier = Modifier.fillMaxWidth(),
                            )

                            Spacer(modifier = Modifier.height(8.dp))

                            OutlinedTextField(
                                value = productDescription,
                                onValueChange = { productDescription = it },
                                label = { Text("Description") },
                                modifier = Modifier.fillMaxWidth()
                                    .height(100.dp)
                            )

                            Spacer(modifier = Modifier.height(8.dp))

                            Button(onClick = { imagePickerLauncher.launch("image/*") })  {
                                Text("Select Product Image")
                            }

                            productImageUri?.let {
                                Spacer(modifier = Modifier.height(8.dp))
                                Image(
                                    painter = rememberImagePainter(it),
                                    contentDescription = "Save Product Image",
                                    modifier = Modifier
                                        .size(150.dp)
                                        .padding(8.dp)
                                )
                            }

                            Spacer(modifier = Modifier.height(16.dp))

                            Button(
                                onClick = {
                                    if (productName.isNotEmpty() && productPrice.isNotEmpty() && productDescription.isNotEmpty() && productImageUri != null) {
                                        uploading = true
                                        uploadProduct(
                                            productName, productPrice, productDescription,
                                            productImageUri!!, storage, firestore, context, navController
                                        ) { success ->
                                            uploading = false
                                            if (success) {
                                                Toast.makeText(
                                                    context,
                                                    "Product added successfully!",
                                                    Toast.LENGTH_SHORT
                                                ).show()
                                            } else {
                                                Toast.makeText(
                                                    context,
                                                    "Failed to add product",
                                                    Toast.LENGTH_SHORT
                                                ).show()
                                            }
                                        }
                                    }
                                },
                                enabled = !uploading,
                                modifier = Modifier.fillMaxWidth(),
                                colors = ButtonDefaults.buttonColors(Color(0xFF4CAF50))
                            ) {
                                if (uploading) {
                                    CircularProgressIndicator(color = Color.Cyan)
                                } else {
                                    Text("Save Product")
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
                    Icon(imageVector = Icons.Default.Person,"", tint = Color.White)
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

fun uploadProduct(
    name: String,
    price: String,
    description: String,
    imageUri: Uri,
    storageReference: StorageReference,
    firestore: FirebaseFirestore,
    context: android.content.Context,
    navController: NavController,
    onComplete: (Boolean) -> Unit
) {
    val storageRef = storageReference.child("products/${imageUri.lastPathSegment}")
    val uploadTask = storageRef.putFile(imageUri)

    uploadTask.continueWithTask { task ->
        if (!task.isSuccessful) {
            task.exception?.let {
                throw it
            }
        }
        storageRef.downloadUrl
    }.addOnCompleteListener { task ->
        if (task.isSuccessful) {
            val downloadUri = task.result
            val product = hashMapOf(
                "name" to name,
                "price" to price,
                "description" to description,
                "image" to downloadUri.toString()
            )

            firestore.collection("products").add(product)
                .addOnSuccessListener {
                    onComplete(true)
                    navController.navigate(ROUTE_HOME)
                }
                .addOnFailureListener {
                    onComplete(false)
                }
        } else {
            onComplete(false)
        }
    }
}