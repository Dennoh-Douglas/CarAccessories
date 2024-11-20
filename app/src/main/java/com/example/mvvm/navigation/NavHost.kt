package com.example.mvvm.navigation

import android.provider.ContactsContract
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mvvm.ui.buy.Buy
import com.example.mvvm.ui.home.Home
import com.example.mvvm.ui.insert.DetailsScreen
import com.example.mvvm.ui.insert.InsertProducts
import com.example.mvvm.ui.insert.InsertProductsScreen
import com.example.mvvm.ui.insert.ViewProductsScreen
import com.example.mvvm.ui.shoppage

@Composable
fun AppNavHost(

    navController: NavHostController = rememberNavController(),
    startDestination: String = ROUTE_SHOPPAGE

){




    NavHost(

        navController = navController,
        startDestination = startDestination


    ) {
        composable (ROUTE_HOME){


            Home(navController)


        }
        composable(ROUTE_INSERT) { InsertProductsScreen(navController) }



        composable(ROUTE_VIEWPRODUCTS) { ViewProductsScreen(navController) }


        composable(ROUTE_SHOPPAGE) {shoppage(navController) }


        composable(ROUTE_BUY) { Buy(navController) }

        composable(ROUTE_INSERTPRODUCT2){ InsertProducts(navController)  }

        composable("details/{productId}") { backStackEntry ->
            val productId = backStackEntry.arguments?.getString("productId")
            productId?.let {
                DetailsScreen(productId, navController)
            }
        }






























    }












}

fun insert(navController: NavHostController) {

}
