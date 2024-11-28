package com.noureldin.eshopping

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.noureldin.eshopping.model.UiProductModel
import com.noureldin.eshopping.navigation.CartScreen
import com.noureldin.eshopping.navigation.CartSummaryScreen
import com.noureldin.eshopping.navigation.HomeScreen
import com.noureldin.eshopping.navigation.OrdersScreen
import com.noureldin.eshopping.navigation.ProductDetails
import com.noureldin.eshopping.navigation.ProfileScreen
import com.noureldin.eshopping.navigation.UserAddressRoute
import com.noureldin.eshopping.navigation.UserAddressRouteWrapper
import com.noureldin.eshopping.navigation.productNavType
import com.noureldin.eshopping.navigation.userAddressNavType
import com.noureldin.eshopping.ui.feature.cart.CartScreen
import com.noureldin.eshopping.ui.feature.home.HomeScreen
import com.noureldin.eshopping.ui.feature.product_details.ProductDetailsScreen
import com.noureldin.eshopping.ui.feature.summary.CartSummaryScreen
import com.noureldin.eshopping.ui.feature.orders.OrdersScreen
import com.noureldin.eshopping.ui.feature.user_address.UserAddressScreen
import com.noureldin.eshopping.ui.theme.EShoppingTheme
import kotlin.reflect.typeOf

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EShoppingTheme {
                val shouldShowBottomNav = remember {
                    mutableStateOf(true)
                }
                val navController = rememberNavController()
                Scaffold (
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = {
                        AnimatedVisibility(visible = shouldShowBottomNav.value, enter = fadeIn()) {
                            BottomNavigationBar(navController)
                        }

                    }
                ){
                    Surface (
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(it)
                    ){
                        NavHost(navController = navController, startDestination =HomeScreen ) {
                            composable<HomeScreen> {
                                HomeScreen(navController)
                                shouldShowBottomNav.value = true
                            }
                            composable<CartScreen>{
                                shouldShowBottomNav.value = true
                                Box(modifier = Modifier.fillMaxSize()) {
                                    CartScreen(navController= navController)
                                }
                            }
                            composable<ProfileScreen>{
                                shouldShowBottomNav.value = true
                                Box(modifier = Modifier.fillMaxSize()){

                                }
                            }
                            composable<OrdersScreen> {
                                shouldShowBottomNav.value = true
                                OrdersScreen()
                            }
                            composable<CartSummaryScreen>{
                                shouldShowBottomNav.value = false
                                CartSummaryScreen(navController = navController)
                            }
                            composable<ProductDetails>(
                                typeMap = mapOf(typeOf<UiProductModel>() to productNavType)
                            ){
                                shouldShowBottomNav.value = false
                                val productRoute = it.toRoute<ProductDetails>()
                                ProductDetailsScreen(navController, productRoute.product)
                            }
                            composable<UserAddressRoute>(
                                typeMap = mapOf(typeOf<UserAddressRouteWrapper>() to userAddressNavType)
                            ) {
                                val userAddressRoute = it.toRoute<UserAddressRoute>()
                                UserAddressScreen(
                                    navController = navController,
                                     userAddress = userAddressRoute.userAddressWrapper.userAddress
                                )
                            }

                        }
                    }

                }
            }
        }
    }
}

@Composable
fun BottomNavigationBar(navController: NavController) {
    NavigationBar {
        //current route
        val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route
        val items = listOf(
            BottomNavItems.Home,
            BottomNavItems.Cart,
            BottomNavItems.Profile
        )
        items.forEach{ item ->
            val isSelected = currentRoute?.substringBefore("?") == item.route::class.qualifiedName
            NavigationBarItem(
                selected = isSelected,
                onClick = {
                    navController.navigate(item.route){
                        navController.graph.startDestinationRoute?.let { startRoute->
                            popUpTo(startRoute){
                                saveState= true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                label = {Text(text = item.title)},
                icon = {
                    Image(
                        painter = painterResource(id = item.icon),
                        contentDescription = null,
                        colorFilter = ColorFilter.tint(if(isSelected) MaterialTheme.colorScheme.primary else Color.Gray)
                    )
                },
                colors = NavigationBarItemDefaults.colors().copy(
                    selectedIconColor = MaterialTheme.colorScheme.primary,
                    selectedTextColor = MaterialTheme.colorScheme.primary,
                    unselectedTextColor = Color.Gray,
                    unselectedIconColor = Color.Gray
                )
            )

        }
    }

}
sealed class BottomNavItems(val route: Any, val title: String, val icon: Int) {
    object Home : BottomNavItems(HomeScreen, "Home", icon = R.drawable.ic_home)
    object Cart : BottomNavItems(CartScreen, "Cart", icon = R.drawable.ic_orders)
    object Profile : BottomNavItems(ProfileScreen, "Profile", icon = R.drawable.ic_profile_bn)
}
