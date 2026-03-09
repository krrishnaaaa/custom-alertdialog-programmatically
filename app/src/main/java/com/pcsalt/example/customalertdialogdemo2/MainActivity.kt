package com.pcsalt.example.customalertdialogdemo2

import android.os.Bundle
import android.text.InputType
import android.text.method.PasswordTransformationMethod
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.pcsalt.example.customalertdialogdemo2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

  private lateinit var binding: ActivityMainBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityMainBinding.inflate(layoutInflater)
    setContentView(binding.root)
    binding.btnShowDialog.setOnClickListener { showCustomDialog() }
  }

  private fun showCustomDialog() {
    val layout = LinearLayout(this).apply {
      orientation = LinearLayout.VERTICAL
      setPadding(48, 32, 48, 16)
    }

    val etUsername = EditText(this).apply {
      hint = "Username"
      inputType = InputType.TYPE_CLASS_TEXT
      isSingleLine = true
    }

    val etPassword = EditText(this).apply {
      hint = "Password"
      inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
      transformationMethod = PasswordTransformationMethod.getInstance()
      isSingleLine = true
    }

    layout.addView(etUsername)
    layout.addView(etPassword)

    AlertDialog.Builder(this)
      .setTitle("Login")
      .setView(layout)
      .setCancelable(false)
      .setPositiveButton("Login") { _, _ ->
        val user = etUsername.text.toString()
        val pass = etPassword.text.toString()
        Toast.makeText(this, "User: $user Password: $pass", Toast.LENGTH_SHORT).show()
      }
      .setNegativeButton("Cancel") { dialog, _ -> dialog.dismiss() }
      .show()
  }
}
