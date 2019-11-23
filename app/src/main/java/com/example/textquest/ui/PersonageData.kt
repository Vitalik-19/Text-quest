package com.example.textquest.ui

data class Personage(
        val firsName: String,
        val description: String
)

var idPersonage: Int = 0

data class PersonageData(
        val personageData: List<Personage> = listOf(
                Personage( "Веста", "жгучая девушка"),
                Personage( "Шрам", "потрепаный парень"),
                Personage( "Стрелок", "всегда меткий"),
                Personage( "Сталкер", "искатель аномалий на жопу"),
                Personage( "Волк", "проходи мимо сталкер..."),
                Personage( "Веста2", "жгучая девушка"),
                Personage( "Шрам2", "потрепаный парень"),
                Personage( "Стрелок2", "всегда меткий"),
                Personage( "Сталкер2", "искатель аномалий на жопу"),
                Personage( "Волк2", "проходи мимо сталкер...")
        )
)