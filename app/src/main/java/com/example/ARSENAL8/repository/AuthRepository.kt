package com.example.ARSENAL8.repository


import com.google.firebase.auth.FirebaseAuth
import java.util.Calendar.getInstance


class AuthRepository {
    private var auth:FirebaseAuth= FirebaseAuth. getInstance()

    fun register(email: String,password: String,
                 onResult: (Boolean)-> Unit){
        auth.createUserWithEmailAndPassword(email,password)
            .addOnCompleteListener {task ->
                onResult(task.isSuccessful)

            }

    }


}