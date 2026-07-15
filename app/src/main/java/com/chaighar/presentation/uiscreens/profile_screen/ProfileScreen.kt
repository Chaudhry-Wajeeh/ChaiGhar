package com.chaighar.presentation.uiscreens.profile_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.NoAccounts
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.chaighar.presentation.navigation.Routes
import com.chaighar.presentation.theme.BrownLight
import com.chaighar.presentation.theme.GrayLight
import com.chaighar.presentation.theme.IvoryWhite
import com.chaighar.presentation.theme.LightBrown
import com.chaighar.presentation.ui_components.BottomNavbar
import com.google.firebase.auth.FirebaseAuth

@Composable
fun ProfileScreen(navController: NavController) {

    val currentUser = FirebaseAuth.getInstance().currentUser
    val userName = currentUser?.displayName ?: "No Name"

    val cardDataList = listOf(
        ProfileCardModel(icon = Icons.Default.ShoppingCart, text = "Cart", onClick = { navController.navigate(Routes.CartScreen) }),
        ProfileCardModel(icon = Icons.Default.Favorite, text = "Favourites", onClick = { navController.navigate(Routes.FavoriteScreen) }),
        ProfileCardModel(icon = Icons.Default.Person, text = "Personal Info", onClick = { navController.navigate(Routes.PersonalInfo(userName = userName)) }),
        ProfileCardModel(icon = Icons.Default.AccountCircle, text = "Account Info", onClick = { navController.navigate(Routes.AccountInfo) }),
        ProfileCardModel(icon = Icons.Default.NoAccounts, text = "Delete Account", onClick = {navController.navigate(Routes.DeleteAccount)})
    )

    Scaffold(
        bottomBar = { BottomNavbar(navController = navController, "Profile") }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxWidth().height(140.dp)
                .clip(shape = RoundedCornerShape(bottomStart = 110.dp, bottomEnd = 110.dp))
                .background(color = IvoryWhite)
        )
        Column(
            modifier = Modifier.fillMaxSize().padding(16.dp)
        ) {
            Spacer(modifier = Modifier.height(70.dp))
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(
                    modifier = Modifier
                        .size(120.dp).clip(CircleShape)
                        .background(color = BrownLight.copy(alpha = 0.3f)),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.Person, contentDescription = "Profile Picture",
                        modifier = Modifier.size(70.dp),
                        tint = LightBrown
                    )
                }
            }
            Spacer(modifier = Modifier.height(60.dp))

            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(containerColor = GrayLight.copy(.7f))
            ) {
                Column(
                    modifier = Modifier.padding(20.dp)
                ) {
                    ProfileSCard(navController = navController, cardDataList[2])
                    ProfileCardDivider()
                    ProfileSCard(navController = navController, cardDataList[3])
                    ProfileCardDivider()
                    ProfileSCard(navController = navController)
                    ProfileCardDivider()
                    ProfileSCard(navController = navController, cardDataList[0])
                    ProfileCardDivider()
                    ProfileSCard(navController = navController, cardDataList[1])
                    ProfileCardDivider()
                    ProfileSCard(navController = navController, cardDataList[4])
                }
            }
        }
    }
}

data class ProfileCardModel(val icon: ImageVector, val text: String, val onClick: ()-> Unit)