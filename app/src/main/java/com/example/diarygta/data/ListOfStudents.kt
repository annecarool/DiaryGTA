package com.example.diarygta.data

import com.example.diarygta.model.Student

class ListOfStudents {

    fun loadListOfStudents():List<Student> {
        return listOf(
            Student("Carl Johnson", "Protagonist"),
            Student("Ryder", "Major Characters"),
            Student("Kendl Johnson","Major Characters"),
            Student("Big Smoke", "Major Characters"),
            Student("Sweet", "Major Characters")
        )

    }
}