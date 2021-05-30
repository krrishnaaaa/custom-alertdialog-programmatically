package com.pcsalt.example.customalertdialogdemo2

import android.os.Bundle
import android.text.method.PasswordTransformationMethod
import android.view.View
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<View>(R.id.btn_show_dialog).setOnClickListener { showCustomDialog() }
    }

    private fun showCustomDialog() {
        val llMainLayout = LinearLayout(this)
        llMainLayout.orientation = LinearLayout.VERTICAL
        llMainLayout.setPadding(60, 10, 40, 10)

        val llUserLayout = LinearLayout(this)
        llUserLayout.orientation = LinearLayout.HORIZONTAL
        llUserLayout.setPadding(10, 10, 10, 10)

        val llPasswordLayout = LinearLayout(this)
        llPasswordLayout.orientation = LinearLayout.HORIZONTAL
        llPasswordLayout.setPadding(10, 10, 10, 10)

        val etUsername: EditText = MyEditText(this)
        val tvUsername = TextView(this)
        tvUsername.text = getString(R.string.username)

        val etPassword: EditText = MyEditText(this)
        etPassword.transformationMethod = PasswordTransformationMethod.getInstance()
        val tvPassword = TextView(this)
        tvPassword.text = getString(R.string.password)

        llUserLayout.addView(tvUsername)
        llUserLayout.addView(etUsername)

        llPasswordLayout.addView(tvPassword)
        llPasswordLayout.addView(etPassword)

        llMainLayout.addView(llUserLayout)
        llMainLayout.addView(llPasswordLayout)

        val alert = AlertDialog.Builder(this)
        alert.setTitle("Custom Login")
        alert.setView(llMainLayout)
        alert.setCancelable(false)
        alert.setPositiveButton("Login") { _, _ ->
            val user = etUsername.text.toString()
            val pass = etPassword.text.toString()
            Toast.makeText(this@MainActivity, "User: $user Password: $pass", Toast.LENGTH_SHORT).show()
        }
        alert.setNegativeButton("Cancel") { dialog, _ -> dialog.dismiss() }
        val dialog = alert.create()
        dialog.show()
    }
}