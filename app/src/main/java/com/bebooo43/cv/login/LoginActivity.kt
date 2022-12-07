package com.bebooo43.cv.login

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.bebooo43.cv.databinding.ActivityLoginBinding
import com.bebooo43.cv.login.model.User
import com.bebooo43.cv.main.MainActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.signInBtn.setOnClickListener {
            if (isInputsValid()) {
                val loginUser = User(binding.emailET.text.toString(), binding.passwordET.text.toString())
                val user = authenticate(loginUser)
                if (user != null)
                    openMainScreen()
                else
                    showRegisterPopup(loginUser)
            }
        }
    }

    private fun showRegisterPopup(loginUser: User) {
        AlertDialog.Builder(this)
            .setTitle("Account not exist")
            .setMessage("This account is not registered! Do you want to register it now ?")
            .setPositiveButton("Register") { _, _ ->
                LoginRepo(this).register(loginUser)
                openMainScreen()
            }.show()
    }

    private fun isInputsValid() =
        when {
            binding.emailET.text.isNullOrEmpty() -> {
                Toast.makeText(this, "Please enter your email!", Toast.LENGTH_SHORT).show()
                false
            }
            binding.passwordET.text.isNullOrEmpty() -> {
                Toast.makeText(this, "Please enter your password!", Toast.LENGTH_SHORT).show()
                false
            }
            binding.emailET.text.isNullOrEmpty() && binding.passwordET.text.isNullOrEmpty() -> {
                Toast.makeText(this, "Please enter your email & password!", Toast.LENGTH_SHORT)
                    .show()
                false
            }
            else -> true
        }

    private fun authenticate(user: User): User? =
        LoginRepo(this).login(user)

    private fun openMainScreen() {
        startActivity(Intent(this, MainActivity::class.java))
        Toast.makeText(this, "Logged In!", Toast.LENGTH_SHORT).show()
        finish()
    }
}