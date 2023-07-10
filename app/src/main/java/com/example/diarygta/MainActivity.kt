package com.example.diarygta

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.diarygta.screen.ScreenListOfStudents
import com.example.diarygta.screen.ScreenLogin
import com.example.diarygta.ui.theme.DiaryGTATheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DiaryGTATheme {
                AppDiary()
            }
        }
    }
}

@Composable
fun AppDiary(){

    val navigationControl = rememberNavController()

    NavHost(
        navController = navigationControl,
        startDestination = "Login"){

        composable(
            route = "Login"
        ){
            ScreenLogin(navigationControl)
        }

        composable(
            route = "ListOfStudents"
        ) {
            ScreenListOfStudents(navigationControl)
        }
    }
}