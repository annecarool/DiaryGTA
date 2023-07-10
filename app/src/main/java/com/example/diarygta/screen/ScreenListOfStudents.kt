package com.example.diarygta.screen

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.diarygta.R
import com.example.diarygta.data.ListOfStudents
import com.example.diarygta.model.Student

@Composable
fun ScreenListOfStudents(navigationControl: NavHostController) {
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        LazyColumn {
            items(ListOfStudents().loadListOfStudents()) {

                    Student -> ClassDiaryStructure(Student = Student)

            }
        }
    }
}
@Composable
fun ClassDiaryStructure(
    Student : Student
) {

    var expand by remember { mutableStateOf(false) }

    Card(
        shape = RoundedCornerShape(10.dp),
        colors = CardDefaults.cardColors(Color(255, 255, 255)),
        elevation = CardDefaults.cardElevation(4.dp),
        border = BorderStroke(2.dp, Color(255, 255, 255)),
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioNoBouncy,
                        stiffness = Spring.StiffnessMedium

                    )
                )
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
                    .animateContentSize(
                        animationSpec = spring(
                            dampingRatio = Spring.DampingRatioNoBouncy,
                            stiffness = Spring.StiffnessMedium
                        )
                    )){
                Image(
                    painter = painterResource(id = Student.photo),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(120.dp)
                        .border(
                            width = (1.dp),
                            color = Color(255, 255, 255),
                            CircleShape
                        )
                        .clip(CircleShape)
                )
                Column(
                    verticalArrangement = Arrangement.SpaceBetween,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                ) {
                    Text(
                        text = Student.name,
                        modifier = Modifier
                            .clickable { expand = !expand }
                            .padding(bottom = 10.dp),
                        textAlign = TextAlign.Center,
                        fontSize = 20.sp,
                        color = Color(0, 0, 0),
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.Normal
                    )

                    Text(
                        text = Student.course,
                        modifier = Modifier
                            .clickable { expand = !expand },
                        textAlign = TextAlign.Center,
                        fontSize = 15.sp,
                        color = Color(0, 0, 0),
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.Normal
                    )
                }
                Icon(
                    imageVector =
                    if (expand)
                        Icons.Filled.KeyboardArrowUp
                    else
                        Icons.Filled.KeyboardArrowDown,
                    contentDescription = null,
                    tint = Color(0, 0, 0),
                    modifier = Modifier
                        .clickable {expand = !expand}
                )
            }

            if (expand) {

                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Text(
                        text = stringResource(id = R.string.student_grades) + Student.grades,
                        modifier = Modifier
                            .padding(20.dp),
                        textAlign = TextAlign.Center,
                        fontSize = 15.sp,
                        color = Color(0, 0, 0),
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.Normal
                    )

                    Text(
                        text = stringResource(id = R.string.student_absences) + Student.absences,
                        modifier = Modifier
                            .padding(20.dp),
                        textAlign = TextAlign.Center,
                        fontSize = 15.sp,
                        color = Color(0, 0, 0),
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.Normal
                    )

                }
            }
        }

    }

}