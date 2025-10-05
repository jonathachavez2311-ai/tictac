package com.example.tictactoe

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Ajustar paddings con los insets del sistema
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    // 👇 Ahora sí queda como función de la clase (fuera de onCreate)
    fun nextScreen(v: View) {
        val player1 = findViewById<EditText>(R.id.etPlayer1)
        val player2 = findViewById<EditText>(R.id.etPlayer2)

        val intent = Intent(applicationContext, GameActivity::class.java)
        intent.putExtra("player1", player1.text.toString())
        intent.putExtra("player2", player2.text.toString())
        startActivity(intent)
    }
}
