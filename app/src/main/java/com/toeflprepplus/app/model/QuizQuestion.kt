package com.toeflprepplus.app.model

enum class SectionType {
    LISTENING, STRUCTURE, READING
}

data class QuizQuestion(
    val id: Int = 0,
    val section: SectionType = SectionType.LISTENING,
    val text: String = "",
    val options: List<String> = listOf(),
    val correctAnswer: String = "",
    val audioResId: Int? = null
)
