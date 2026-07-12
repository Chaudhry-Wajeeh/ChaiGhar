package com.chaighar.presentation.uiscreens.signup_screens

import android.media.Image
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Password
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.chaighar.R
import com.chaighar.backend.viewmodel.AuthViewModel
import com.chaighar.presentation.navigation.Routes
import com.chaighar.presentation.theme.BlueLight
import com.chaighar.presentation.theme.LightBrown

@Composable
fun LoginScreen(navController: NavController, viewModel: AuthViewModel = viewModel()) {

    val context = LocalContext.current
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.bg_image_signup_screen),
            contentDescription = "BG_Image",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )

        Column(
            modifier = Modifier.fillMaxSize().background(color = Color.Black.copy(alpha = 0.3f)),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(120.dp))

            Text(
                text = "Log into your Account", color = Color.White,
                style = MaterialTheme.typography.titleLarge.copy(
                    fontFamily = FontFamily.Serif, fontSize = 30.sp, fontWeight = FontWeight.SemiBold
                )
            )
            Spacer(modifier = Modifier.height(40.dp))

            TextField(
                value = email, onValueChange = {email = it},
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Email, contentDescription = "Email_Icon", tint = LightBrown,
                        modifier = Modifier.size(30.dp)
                    )
                },
                placeholder = { Text(text = "yourmail@email.com", fontSize = 20.sp) },
                singleLine = true, shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),
                modifier = Modifier.fillMaxWidth(.82f).height(60.dp),
                colors = TextFieldDefaults.colors(
                    unfocusedIndicatorColor = Color.Transparent, focusedIndicatorColor = Color.Transparent,
                    unfocusedContainerColor = Color.White, focusedContainerColor = Color.White,
                    unfocusedTextColor = Color.Black, focusedTextColor = Color.Black,
                    cursorColor = Color.LightGray
                )
            )
            Spacer(modifier = Modifier.height(10.dp))

            TextField(
                value = password, onValueChange = {password = it},
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Password, contentDescription = "Password_Icon",
                        tint = LightBrown, modifier = Modifier.size(30.dp)
                    )
                },
                placeholder = { Text(text = "Password", fontSize = 20.sp) },
                singleLine = true, shape = RoundedCornerShape(bottomStart = 16.dp, bottomEnd = 16.dp),
                modifier = Modifier.fillMaxWidth(.82f).height(60.dp),
                colors = TextFieldDefaults.colors(
                    unfocusedIndicatorColor = Color.Transparent, focusedIndicatorColor = Color.Transparent,
                    unfocusedContainerColor = Color.White, focusedContainerColor = Color.White,
                    unfocusedTextColor = Color.Black, focusedTextColor = Color.Black,
                    cursorColor = Color.LightGray
                )
            )
            Spacer(modifier = Modifier.height(26.dp))

            Button(
                onClick = {
                    if (email.isNotEmpty() && password.isNotEmpty()) {
                        viewModel.login(email = email, password = password) { success ->
                            if (success) {
                                navController.navigate(Routes.HomeScreen) {
                                    popUpTo(navController.graph.startDestinationId) {inclusive = true}
                                }
                            }else {
                                Toast.makeText(context, "Login Failed! Invalid credentials or account doesn't exist", Toast.LENGTH_SHORT).show()
                            }
                        }
                    } else {
                        Toast.makeText(context, "Email or Password field are empty", Toast.LENGTH_SHORT).show()
                    }
                },
                modifier = Modifier.fillMaxWidth(.8f).height(53.dp),
                colors = ButtonDefaults.buttonColors(LightBrown)
            ) {
                Text(text = "Login", color = Color.White, fontSize = 22.sp, fontWeight = FontWeight.SemiBold)
            }
            Spacer(modifier = Modifier.height(36.dp))

            Text(
                text = "Or", color = Color.White,
                style = MaterialTheme.typography.titleMedium.copy(
                    fontFamily = FontFamily.Serif, fontSize = 36.sp, fontWeight = FontWeight.Medium
                )
            )
            Spacer(modifier = Modifier.height(140.dp))

            IconButton(
                onClick = {}, modifier = Modifier.size(60.dp).clip(shape = CircleShape),
                colors = IconButtonDefaults.iconButtonColors(Color.White)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.g_logo), contentDescription = "G_SignUp_IconButton",
                    modifier = Modifier.padding(8.dp).fillMaxSize(), tint = Color.Unspecified
                )
            }
            Spacer(modifier = Modifier.height(18.dp))

            Row(
                modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Don't have an account yet?", color = Color.White, fontSize = 18.sp
                )
                Text(
                    text = " SignUp", color = BlueLight,
                    modifier = Modifier.clickable(onClick = { navController.navigate(Routes.SignUpScreen) }),
                    fontSize = 18.sp, fontWeight = FontWeight.Medium
                )
            }
        }
    }
}