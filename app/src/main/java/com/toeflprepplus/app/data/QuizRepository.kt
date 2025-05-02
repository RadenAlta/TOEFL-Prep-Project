package com.toeflprepplus.app.data

import com.toeflprepplus.app.model.QuizQuestion
import com.toeflprepplus.app.model.SectionType
import com.toeflprepplus.app.R

// Repository to handle TOEFL quiz questions
object QuizRepository {

    // Function to get questions based on the section (Listening, Structure, or Reading)
    fun getQuestionsBySection(section: SectionType): List<QuizQuestion> {
        return when (section) {
            SectionType.LISTENING -> listeningQuestions
            SectionType.STRUCTURE -> structureQuestions
            SectionType.READING -> readingQuestions
        }
    }

    // List of questions for the Listening section
    private val listeningQuestions = listOf(
        QuizQuestion(
            id = 1,
            section = SectionType.LISTENING,
            text = "What is the main idea of the audio?",
            options = listOf("Option 1", "Option 2", "Option 3", "Option 4"),
            correctAnswer = "Option 2",
            audioResId = R.raw.sample_audio  // ID for the audio file
        ),
        QuizQuestion(
            id = 2,
            section = SectionType.LISTENING,
            text = "What is the speaker talking about?",
            options = listOf("Option A", "Option B", "Option C", "Option D"),
            correctAnswer = "Option C",
            audioResId = R.raw.sample_audio
        ),
        // Add more listening questions here as required
    )

    // List of questions for the Structure section
    private val structureQuestions = listOf(
        QuizQuestion(
            id = 51,
            section = SectionType.STRUCTURE,
            text = "The students ___ to school this morning.",
            options = listOf("Come early", "Comes fast", "Comes lately", "Comes slowly"),
            correctAnswer = "Come early"
        ),
        QuizQuestion(
            id = 52,
            section = SectionType.STRUCTURE,
            text = "She ___ to the market every Sunday.",
            options = listOf("Go", "Goes", "Going", "Gone"),
            correctAnswer = "Goes"
        ),
        // Add more structure questions here as required
    )

    // List of questions for the Reading section
    private val readingQuestions = listOf(
        QuizQuestion(
            id = 91,
            section = SectionType.READING,
            text = "What does the word 'Dakota' mean?",
            options = listOf("Fighters", "Allies", "Tribes", "Enemies"),
            correctAnswer = "Allies"
        ),
        QuizQuestion(
            id = 92,
            section = SectionType.READING,
            text = "What was the purpose of the article?",
            options = listOf("To explain", "To inform", "To entertain", "To persuade"),
            correctAnswer = "To inform"
        ),
        // Add more reading questions here as required
    )
}
