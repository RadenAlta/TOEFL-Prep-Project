package com.toeflprepplus.app.model

import android.util.Patterns

data class User(
    val userId: String = "",
    val email: String = "",
    val fullName: String = "",
    val profilePictureUrl: String? = null,
    val isEmailVerified: Boolean = false,
    val signUpDate: Long = System.currentTimeMillis()
) {
    // Fungsi untuk memvalidasi email format
    fun isValidEmail(): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    // Fungsi untuk memperbarui nama lengkap pengguna
    fun updateFullName(newFullName: String): User {
        return this.copy(fullName = newFullName)
    }

    // Fungsi untuk memperbarui gambar profil pengguna
    fun updateProfilePicture(newProfilePictureUrl: String?): User {
        return this.copy(profilePictureUrl = newProfilePictureUrl)
    }

    // Fungsi untuk mengubah status verifikasi email
    fun updateEmailVerificationStatus(isVerified: Boolean): User {
        return this.copy(isEmailVerified = isVerified)
    }

    // Fungsi untuk memeriksa apakah profil lengkap
    fun isProfileComplete(): Boolean {
        return fullName.isNotEmpty() && email.isNotEmpty() && profilePictureUrl != null
    }

    // Fungsi untuk menghitung lama waktu dari pendaftaran (dalam hari)
    fun getDaysSinceSignUp(): Long {
        val currentTime = System.currentTimeMillis()
        val timeDifference = currentTime - signUpDate
        return timeDifference / (1000 * 60 * 60 * 24) // Convert to days
    }
}
