package com.example.textquest.ui

data class Personage(
        val firsName: String,
        val description: String,
        val questionData: List<Question>
)

var idPersonage: Int = 0
var idQuestion: Int = 0

data class PersonageData(
        val personageData: List<Personage> = listOf(
                Personage(
                        "Веста",
                        "Преимущества : имеет лидерские способности, неплохо развита интуиция, по восприятию кинестетик, хорошо развиты слух и зрение, в руках удержать может огнестрельное оружие на малые и средние дистанции. Хорошие способности к точному метанию чего угодно : ножи, копья, топоры, тарелки, булыжники, слова. С ней в снежки играть опасно.Доверчивая и принимающая близко к сердцу девушка. Полно надежды в окружающий мир, верит, что с каждым можно подружиться, даже с наибольшей злюкой-букой мутантом.Имеет потерю памяти. Часто погружается в самоанализ, что плохо сказывается на её настроении, а в худшем случае и привести к депрессии. Чует Выброс, и в итоге может потерять обморок в его время и начать видеть галлюцинации. Приятная как для общения персона, поэтому если надо заключить какую сделку - парится не о чем. Переубедит. Упрямая. Всегда поможет, если надо. Везде находит позитив.",
                        questionVesta
                ),
                Personage(
                        "Шрам",
                        "потрепаный парень",
                        questionShram
                ),
                Personage(
                        "Стрелок",
                        "всегда меткий",
                        questionStrelok
                ),
                Personage(
                        "Сталкер",
                        "искатель аномалий на жопу",
                        questionStalker
                ),
                Personage(
                        "Волк",
                        "проходи мимо сталкер...",
                        questionVolk
                )
        )
)

// QuestionData
val questionVesta: List<Question> = listOf(
        Question("Question1 Vesta", listOf(
                AnswerButtonData("answer1", 2),
                AnswerButtonData("answer2", 3),
                AnswerButtonData("answer3", 1)
        )),
        Question("Question2 Vesta", listOf(AnswerButtonData("answer1", 3))),
        Question("Question3 Vesta", listOf(AnswerButtonData("answer1", 1)))
)
val questionShram: List<Question> = listOf(
        Question("Question1 Shram", listOf(
                AnswerButtonData("answer1", 2),
                AnswerButtonData("answer2", 3),
                AnswerButtonData("answer3", 1)
        )),
        Question("Question2 Shram", listOf(AnswerButtonData("answer1", 3))),
        Question("Question3 Shram", listOf(AnswerButtonData("answer1", 1)))
)
val questionStrelok: List<Question> = listOf(
        Question("Question1 Strelok", listOf(
                AnswerButtonData("answer1", 2),
                AnswerButtonData("answer2", 3),
                AnswerButtonData("answer3", 1)
        )),
        Question("Question2 Strelok", listOf(AnswerButtonData("answer1", 3))),
        Question("Question3 Strelok", listOf(AnswerButtonData("answer1", 1)))
)
val questionStalker: List<Question> = listOf(
        Question("Question1 Stalker", listOf(
                AnswerButtonData("answer1", 2),
                AnswerButtonData("answer2", 3),
                AnswerButtonData("answer3", 1)
        )),
        Question("Question2 Stalker", listOf(AnswerButtonData("answer1", 3))),
        Question("Question3 Stalker", listOf(AnswerButtonData("answer1", 1)))
)
val questionVolk: List<Question> = listOf(
        Question("Question1 Volk", listOf(
                AnswerButtonData("answer1", 2),
                AnswerButtonData("answer2", 3),
                AnswerButtonData("answer3", 1)
        )),
        Question("Question2 Volk", listOf(AnswerButtonData("answer1", 3))),
        Question("Question3 Volk", listOf(AnswerButtonData("answer1", 1)))
)

data class Question(
        val questionText: String,
        val answerButtonData: List<AnswerButtonData>
//        val answerButton: ArrayList<Button>
)

data class AnswerButtonData(
        val answerText: String,
        val questionId: Int
)