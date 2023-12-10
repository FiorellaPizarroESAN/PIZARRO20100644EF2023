package com.example.pizarro20100644ef2023

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        var auth = FirebaseAuth.getInstance();
        // val db = FirebaseFirestore.getInstance()
        // val usersCollection = db.collection("users")


        val txtEmail: EditText = findViewById(R.id.etEmailLogin)
        val txtPassword: EditText = findViewById(R.id.etPasswordLogin)
        val btnLogin: Button = findViewById(R.id.btnLogin)

        btnLogin.setOnClickListener {
            val correo = txtEmail.text.toString();
            val clave = txtPassword.text.toString();
            if(correo.isNotEmpty() && clave.isNotEmpty()){
                auth.signInWithEmailAndPassword(correo,clave)
                    .addOnCompleteListener(this){task->
                        if(task.isSuccessful){

                            Snackbar.make(findViewById(android.R.id.content),"Ingreso satisfactorio",
                                Snackbar.LENGTH_LONG).show()

                        }else{
                            Snackbar.make(findViewById(android.R.id.content),"Las credenciales son inválidas",
                                Snackbar.LENGTH_LONG).show()
                        }
                    }
            }else{
                Snackbar.make(findViewById(android.R.id.content),"Ingrese correo y contraseña.",
                    Snackbar.LENGTH_LONG).show()


            }
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }





    }
}