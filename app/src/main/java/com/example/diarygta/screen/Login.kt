package com.example.diarygta.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.diarygta.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun ScreenLogin(navigationControl: NavHostController) {

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = (Color.White)
    ) {

        var user by remember { mutableStateOf("") }
        var password by remember { mutableStateOf(" ") }

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = stringResource(id = R.string.login),
                textAlign = TextAlign.Center,
                fontSize = 20.sp,
                color = Color(0, 0, 0),
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Normal,
                modifier = Modifier
                    .padding(horizontal = 40.dp)
            )

            Spacer(modifier = Modifier.size(10.dp))


            Card(
                shape = RoundedCornerShape(10.dp),
                colors = CardDefaults.cardColors(Color(255, 255, 255)),
                elevation = CardDefaults.cardElevation(5.dp),
                border = BorderStroke(5.dp, Color(255, 255, 255)),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 40.dp)
                    .padding(vertical = 20.dp)
            ) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .padding(horizontal = 20.dp)
                ) {

                    Image(
                        painter = painterResource(id = R.drawable.perfil),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        alignment = Alignment.Center,
                        modifier = Modifier
                            .size(120.dp)
                            .shadow(
                                elevation = (5.dp),
                                CircleShape
                            )
                            .padding(vertical = 10.dp)
                    )

                    OutlinedTextField(
                        value = user,
                        onValueChange = { user = it },
                        label = { Text(text = stringResource(id = R.string.userfield)) }
                    )

                    Spacer(modifier = Modifier.size(20.dp))


                    OutlinedTextField(
                        value = password,
                        onValueChange = { password = it },
                        label = { Text(text = stringResource(id = R.string.passwordfield)) },
                    )

                    Button(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 40.dp)
                            .padding(vertical = 10.dp),
                        onClick = {},
                        colors = ButtonDefaults.buttonColors(Color.Black),
                        shape = RoundedCornerShape(10.dp)
                    ) {
                        Text(
                            text = stringResource(id = R.string.sign),
                            textAlign = TextAlign.Center,
                            fontSize = 15.sp,
                            color = Color(255, 255, 255),
                            fontFamily = FontFamily.SansSerif,
                            fontWeight = FontWeight.Normal
                        )
                    }
                }

            }

            Spacer(modifier = Modifier.size(15.dp))

            Text(
                text = stringResource(id = R.string.terms),
                textAlign = TextAlign.Center,
                fontSize = 12.sp,
                color = Color(0, 0, 0),
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Normal,
                modifier = Modifier
                    .padding(horizontal = 40.dp)
            )
        }
    }
}