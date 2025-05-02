package com.toeflprepplus.app.data.firestore

import com.google.firebase.firestore.FirebaseFirestore
import com.toeflprepplus.app.model.QuizQuestion
import com.toeflprepplus.app.model.User
import com.google.firebase.auth.FirebaseAuth
import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.QuerySnapshot

class FirestoreHelper {

    private val db = FirebaseFirestore.getInstance()
    private val auth = FirebaseAuth.getInstance()

    // Function to add a new user to Firestore
    fun addUserToFirestore(user: User): Task<Void> {
        val userRef = db.collection("users").document(user.userId)
        return userRef.set(user)
    }

    // Function to get a user from Firestore
    fun getUserFromFirestore(userId: String, onComplete: (User?) -> Unit) {
        val userRef = db.collection("users").document(userId)
        userRef.get()
            .addOnSuccessListener { document ->
                if (document.exists()) {
                    val user = document.toObject(User::class.java)
                    onComplete(user)
                } else {
                    onComplete(null)
                }
            }
            .addOnFailureListener { exception ->
                onComplete(null)
            }
    }

    // Function to update a user in Firestore
    fun updateUserInFirestore(userId: String, updatedUser: User): Task<Void> {
        val userRef = db.collection("users").document(userId)
        return userRef.set(updatedUser)
    }

    // Function to get all users from Firestore
    fun getAllUsers(onComplete: (List<User>) -> Unit) {
        val usersRef = db.collection("users")
        usersRef.get()
            .addOnSuccessListener { result ->
                val userList = mutableListOf<User>()
                for (document in result) {
                    val user = document.toObject(User::class.java)
                    userList.add(user)
                }
                onComplete(userList)
            }
            .addOnFailureListener { exception ->
                onComplete(emptyList())
            }
    }

    // Function to delete a user from Firestore
    fun deleteUserFromFirestore(userId: String): Task<Void> {
        val userRef = db.collection("users").document(userId)
        return userRef.delete()
    }

    // Function to get the current user
    fun getCurrentUser(): User? {
        val firebaseUser = auth.currentUser
        return firebaseUser?.let {
            User(
                userId = it.uid,
                email = it.email ?: "",
                fullName = "",
                isEmailVerified = it.isEmailVerified
            )
        }
    }

    // Function to add a new quiz question to Firestore
    fun addQuizQuestionToFirestore(quizQuestion: QuizQuestion): Task<Void> {
        val quizRef = db.collection("quizQuestions").document()
        return quizRef.set(quizQuestion)
    }

    // Function to get all quiz questions from Firestore
    fun getQuizQuestions(onComplete: (List<QuizQuestion>) -> Unit) {
        val quizRef = db.collection("quizQuestions")
        quizRef.get()
            .addOnSuccessListener { result ->
                val quizList = mutableListOf<QuizQuestion>()
                for (document in result) {
                    val quiz = document.toObject(QuizQuestion::class.java)
                    quizList.add(quiz)
                }
                onComplete(quizList)
            }
            .addOnFailureListener { exception ->
                onComplete(emptyList())
            }
    }

    // Function to get a single quiz question from Firestore by questionId
    fun getQuizQuestionById(questionId: String, onComplete: (QuizQuestion?) -> Unit) {
        val quizRef = db.collection("quizQuestions").document(questionId)
        quizRef.get()
            .addOnSuccessListener { document ->
                if (document.exists()) {
                    val quiz = document.toObject(QuizQuestion::class.java)
                    onComplete(quiz)
                } else {
                    onComplete(null)
                }
            }
            .addOnFailureListener { exception ->
                onComplete(null)
            }
    }

    // Function to update a quiz question in Firestore
    fun updateQuizQuestionInFirestore(questionId: String, updatedQuiz: QuizQuestion): Task<Void> {
        val quizRef = db.collection("quizQuestions").document(questionId)
        return quizRef.set(updatedQuiz)
    }

    // Function to delete a quiz question from Firestore
    fun deleteQuizQuestionFromFirestore(questionId: String): Task<Void> {
        val quizRef = db.collection("quizQuestions").document(questionId)
        return quizRef.delete()
    }
}
