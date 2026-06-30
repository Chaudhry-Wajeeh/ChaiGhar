package com.chaighar.presentation.uiscreens.welcomeS

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.chaighar.R
import com.chaighar.presentation.navigation.Routes
import com.chaighar.presentation.theme.LightBrown


@Composable
fun WelcomeScreen(navController: NavController) {
    Column(modifier = Modifier.fillMaxSize().background(Color.Black)) {
        Image(
            painter = painterResource(id = R.drawable.chaicupintro),
            contentDescription = "Chai Cup Scree",
            modifier = Modifier.weight(0.71f).fillMaxWidth(),
            contentScale = ContentScale.FillBounds
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.29f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Fall in Love with Chai with every Sip you take",
                fontSize = 24.sp, color = Color.White, fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(horizontal = 10.dp),
                textAlign = TextAlign.Center, lineHeight = 23.sp
            )
            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Welcome to Chai Ghar, where every cup is delightful", color = Color.LightGray,
                textAlign = TextAlign.Center,fontSize = 12.sp
            )
            Spacer(modifier = Modifier.height(30.dp))

            Button(
                onClick = { navController.navigate(Routes.HomeScreen) },
                colors = ButtonDefaults.buttonColors(LightBrown),
                modifier = Modifier.fillMaxWidth().padding(horizontal = 15.5.dp).height(50.dp),
                shape = RoundedCornerShape(10.dp)
            ) {
                Text(
                    text = "Get Started", color = Color.White,
                    fontSize = 18.sp, modifier = Modifier.padding(horizontal = 15.dp)
                )
            }
        }
    }
}