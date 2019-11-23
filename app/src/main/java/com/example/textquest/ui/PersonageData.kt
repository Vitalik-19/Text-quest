package com.example.textquest.ui

data class Personage(
        val id: Int,
        val firsName: String,
        val description: String
)

var idPersonage: Int = 0

data class PersonageData(
        val personageData: List<Personage> = listOf(
                Personage(0, "Веста", "жгучая девушка"),
                Personage(1, "Шрам", "потрепаный парень"),
                Personage(2, "Стрелок", "всегда меткий"),
                Personage(3, "Сталкер", "искатель аномалий на жопу"),
                Personage(4, "Волк", "проходи мимо сталкер...")

        )
)