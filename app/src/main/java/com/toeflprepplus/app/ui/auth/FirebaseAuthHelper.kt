package com.toeflprepplus.app.ui.auth

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.AuthResult
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

object FirebaseAuthHelper {

    private val auth: FirebaseAuth = Firebase.auth

    /** Ambil user yang sedang login */
    val currentUser: FirebaseUser?
        get() = auth.currentUser

    /** Registrasi user baru dengan email dan password */
    fun registerUser(
        email: String,
        password: String,
        onResult: (Boolean, String?) -> Unit
    ) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    sendEmailVerification { emailSent ->
                        onResult(emailSent, null)
                    }
                } else {
                    onResult(false, task.exception?.message)
                }
            }
    }

    /** Kirim email verifikasi ke user yang sedang login */
    private fun sendEmailVerification(onResult: (Boolean) -> Unit) {
        auth.currentUser?.sendEmailVerification()
            ?.addOnCompleteListener { task ->
                onResult(task.isSuccessful)
            }
    }

    /** Login dengan email dan password */
    fun loginUser(
        email: String,
        password: String,
        onResult: (Boolean, String?) -> Unit
    ) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    if (auth.currentUser?.isEmailVerified == true) {
                        onResult(true, null)
                    } else {
                        onResult(false, "Email belum diverifikasi.")
                    }
                } else {
                    onResult(false, task.exception?.message)
                }
            }
    }

    /** Kirim email untuk reset password */
    fun sendPasswordReset(
        email: String,
        onResult: (Boolean, String?) -> Unit
    ) {
        auth.sendPasswordResetEmail(email)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    onResult(true, null)
                } else {
                    onResult(false, task.exception?.message)
                }
            }
    }

    /** Logout dari aplikasi */
    fun logout() {
        auth.signOut()
    }

    /** Hapus akun user */
    fun deleteUser(onResult: (Boolean, String?) -> Unit) {
        auth.currentUser?.delete()
            ?.addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    onResult(true, null)
                } else {
                    onResult(false, task.exception?.message)
                }
            }
    }
}
