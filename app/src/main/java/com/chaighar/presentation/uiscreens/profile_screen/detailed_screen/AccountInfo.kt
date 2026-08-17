package com.chaighar.presentation.uiscreens.profile_screen.detailed_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.chaighar.presentation.theme.ChaiBrown
import com.chaighar.presentation.theme.IvoryWhite
import com.google.firebase.auth.FirebaseAuth
import androidx.compose.ui.platform.LocalUriHandler

@Composable
fun AccountInfo(navController: NavController) {

    val currentUser = FirebaseAuth.getInstance().currentUser
    val userEmail = currentUser?.email ?: "myapp@gmail.com"
    val uriHandler = LocalUriHandler.current
    val privacyPolicy = "https://sites.google.com/view/chaighar-privacy-policy/"

    Scaffold(
        topBar = { TBarProfileDScreens(navController = navController, "Account Info") }
    ) { innerPadding ->

        Card(modifier = Modifier.padding(innerPadding)) {
            Card(
                modifier = Modifier.padding(16.dp).fillMaxWidth(),
                elevation = CardDefaults.elevatedCardElevation(10.dp)
            ) {
                Column(
                    modifier = Modifier,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Box(
                        modifier = Modifier.fillMaxWidth().height(50.dp)
                            .background(color = ChaiBrown), contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "Email", style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.SemiBold, color = IvoryWhite
                        )
                    }

                    Text(
                        text = userEmail, style = MaterialTheme.typography.bodyMedium,
                        color = Color.DarkGray, modifier = Modifier.padding(vertical = 14.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Card(
                modifier = Modifier.padding(16.dp).fillMaxWidth(),
                elevation = CardDefaults.elevatedCardElevation(10.dp)
            ) {
                Column(
                    modifier = Modifier,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Box(
                        modifier = Modifier.fillMaxWidth().height(50.dp)
                            .background(color = ChaiBrown), contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "Privacy Policy", style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.SemiBold, color = IvoryWhite
                        )
                    }

                    Text(
                        text = "Privacy Policy",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.primary,
                        textDecoration = TextDecoration.Underline,
                        modifier = Modifier
                            .padding(vertical = 14.dp)
                            .clickable {
                                uriHandler.openUri(privacyPolicy)
                            }
                    )
                }
            }
        }
    }
}