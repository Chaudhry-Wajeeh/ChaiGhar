package com.chaighar.presentation.uiscreens.profile_screen.detailed_screen

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.chaighar.backend.viewmodel.AuthViewModel
import com.chaighar.presentation.navigation.Routes
import com.chaighar.presentation.theme.IvoryWhite
import com.chaighar.presentation.theme.LightBrown

@Composable
fun DeleteAccount(navController: NavController) {

    val authViewModel: AuthViewModel = viewModel()
    val context = LocalContext.current
    var isLoading by remember { mutableStateOf(false) }


    Scaffold(
        topBar = { TBarProfileDScreens(navController = navController, "Delete Account") }
    ) { innerPadding ->
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(innerPadding)
                .padding(horizontal = 16.dp, vertical = 20.dp),
            elevation = CardDefaults.elevatedCardElevation(10.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Are you sure you want to delete this account?",
                    style = MaterialTheme.typography.titleLarge.copy(
                        fontSize = 24.sp,
                        color = Color.Black
                    ),
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "This action is permanent and will wipe all your data",
                    style = MaterialTheme.typography.bodyMedium.copy(color = Color.Gray),
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(24.dp))

                if (isLoading) {
                    CircularProgressIndicator(color = LightBrown)
                } else {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        Button(
                            onClick = {
                                isLoading = true
                                authViewModel.deleteAccount { success, error ->
                                    isLoading = false
                                    if (success) {
                                        Toast.makeText(context, "Account deleted successfully", Toast.LENGTH_SHORT).show()
                                        navController.navigate(Routes.LoginScreen) {
                                            popUpTo(0) { inclusive = true }
                                        }
                                    } else {
                                        if (error?.contains("recent-login", ignoreCase = true) == true) {
                                            Toast.makeText(context, "For security, please log out and log back in before deleting.", Toast.LENGTH_LONG).show()
                                        } else {
                                            Toast.makeText(context, "Error: $error", Toast.LENGTH_LONG).show()
                                        }
                                    }
                                }
                            },
                            colors = ButtonDefaults.buttonColors(LightBrown),
                            modifier = Modifier.height(50.dp).weight(1f).padding(horizontal = 8.dp),
                            shape = RoundedCornerShape(10.dp)
                        ) {
                            Text(text = "Yes", color = IvoryWhite, fontSize = 18.sp)
                        }

                        Button(
                            onClick = { navController.navigateUp() },
                            colors = ButtonDefaults.buttonColors(LightBrown),
                            modifier = Modifier.height(50.dp).weight(1f).padding(horizontal = 8.dp),
                            shape = RoundedCornerShape(10.dp)
                        ) {
                            Text(text = "No", color = IvoryWhite, fontSize = 18.sp)
                        }
                    }
                }
            }
        }
    }
}