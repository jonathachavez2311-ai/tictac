package com.example.tictactoe

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class GameActivity : AppCompatActivity() {

    lateinit var B1: Button
    lateinit var B2: Button
    lateinit var B3: Button
    lateinit var B4: Button
    lateinit var B5: Button
    lateinit var B6: Button
    lateinit var B7: Button
    lateinit var B8: Button
    lateinit var B9: Button
    lateinit var tvplayer1: TextView
    lateinit var tvplayer2: TextView
    lateinit var tvScorePlayer1: TextView
    lateinit var tvScorePlayer2: TextView

    var currentPlayer: Int = 1

    var scorePlayer1: Int = 0
    var scorePlayer2: Int = 0
    var gameFinished: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_game)

        initui()
    }

    private fun initui() {
        B1 = findViewById(R.id.B1)
        B2 = findViewById(R.id.B2)
        B3 = findViewById(R.id.B3)
        B4 = findViewById(R.id.B4)
        B5 = findViewById(R.id.B5)
        B6 = findViewById(R.id.B6)
        B7 = findViewById(R.id.B7)
        B8 = findViewById(R.id.B8)
        B9 = findViewById(R.id.B9)
        tvplayer1 = findViewById(R.id.tvplayer1)
        tvplayer2 = findViewById(R.id.tvplayer2)
        tvScorePlayer1 = findViewById(R.id.tvScorePlayer1)
        tvScorePlayer2 = findViewById(R.id.tvScorePlayer2)

        tvplayer1.text = intent?.extras?.getString("player1").toString()
        tvplayer2.text = intent?.extras?.getString("player2").toString()
        NuevaPartida(tvplayer1)
    }

    fun play(btn: View) {
        val myBtn: Button = btn as Button
        if (!gameFinished && myBtn.text.toString().isEmpty()) {
            if (currentPlayer == 1) {
                myBtn.text = "X"
                validateWinner(btn)
                currentPlayer = 2
                tvplayer1.setTextColor(Color.RED)
                tvplayer2.setTextColor(Color.BLACK)
            } else {
                myBtn.text = "O"
                validateWinner(btn)
                currentPlayer = 1
                tvplayer1.setTextColor(Color.BLACK)
                tvplayer2.setTextColor(Color.RED)
            }
        }
    }

    fun validateWinner(btn:View) {

        if (validatecard(btn)) {
            if (currentPlayer == 1) {
                scorePlayer1++
                tvScorePlayer1.text = "$scorePlayer1"

                Toast.makeText(applicationContext, "${tvplayer1.text} ¡¡Ganaste:)!!", Toast.LENGTH_LONG).show()
            } else {
                scorePlayer2++
                tvScorePlayer2.text = "$scorePlayer2"
                Toast.makeText(applicationContext, "${tvplayer2.text} ¡¡Ganaste :)!!", Toast.LENGTH_LONG).show()
            }

            gameFinished = true
        }else {
            // 👇 Aquí agregamos la validación de empate
            val allFilled = B1.text.isNotEmpty() && B2.text.isNotEmpty() && B3.text.isNotEmpty() &&
                    B4.text.isNotEmpty() && B5.text.isNotEmpty() && B6.text.isNotEmpty() &&
                    B7.text.isNotEmpty() && B8.text.isNotEmpty() && B9.text.isNotEmpty()

            if (allFilled) {
                Toast.makeText(applicationContext, "¡¡Empate!!", Toast.LENGTH_LONG).show()
                gameFinished = true
            }
        }
    }

    private fun validatecard(btn: View): Boolean {
        val B1val = B1.text.toString().trim()
        val B2val = B2.text.toString().trim()
        val B3val = B3.text.toString().trim()
        val B4val = B4.text.toString().trim()
        val B5val = B5.text.toString().trim()
        val B6val = B6.text.toString().trim()
        val B7val = B7.text.toString().trim()
        val B8val = B8.text.toString().trim()
        val B9val = B9.text.toString().trim()

        var winner = false

        when (btn.id) {
            B1.id -> {
                if (B1val !="" &&
                    (B1val == B2val && B1val == B3val)
                    ||
                    (B1val == B5val && B1val == B9val)
                    ||
                    (B1val == B4val && B1val == B7val)
                ) {
                    winner = true
                }
            }

            B2.id -> {
                if (B2val != "" &&
                    (B2val == B1val && B2val == B3val)
                    ||
                    (B2val == B5val && B2val ==B8val )
                ) {
                    winner = true
                }
            }

            B3.id -> {
                if (B3val !="" &&
                    (B3val ==B1val && B3val == B2val)
                    ||
                    (B3val == B6val && B3val == B9val)
                    ||
                    (B3val == B5val && B3val == B7val)
                ) {
                    winner = true
                }
            }

            B4.id -> {
                if (B4val !="" &&
                    (B4val == B1val && B4val == B7val)
                    ||
                    (B4val == B5val && B4val == B6val)
                ) {
                    winner = true
                }
            }

            B5.id -> {
                if (B5val !="" &&
                    (B5val == B2val && B5val == B7val)
                    ||
                    (B5val == B4val && B5val == B6val)
                    ||
                    (B5val == B3val && B5val == B7val)
                ) {
                    winner = true
                }
            }

            B6.id -> {
                if (B6val!="" &&
                    (B6val == B3val && B6val == B9val)
                    ||
                    (B6val == B4val && B6val == B5val)
                ) {
                    winner = true
                }
            }

            B7.id -> {
                if (B7val!="" &&
                    (B7val == B1val && B7val == B4val)
                    ||
                    (B7val == B8val && B7val == B9val)
                    ||
                    (B7val == B5val && B7val == B3val)
                ) {
                    winner = true
                }
            }

            B8.id -> {
                if (B8val!="" &&
                    (B8val == B2val && B8val == B5val)
                    ||
                    (B8val == B7val && B8val == B9val)
                ) {
                    winner = true
                }
            }
            B9.id -> {
                if (B9val!="" &&
                    (B9val == B1val && B9val == B5val)
                    ||
                    (B9val == B3val && B9val == B6val)
                    ||
                    (B9val == B7val && B9val == B8val)
                ) {
                    winner = true
                }
            }

            else -> {
                winner = false
            }

        }

        return winner
    }
    fun NuevaPartida(v: View){

        B1.text = ""
        B2.text = ""
        B3.text = ""
        B4.text = ""
        B5.text = ""
        B6.text = ""
        B7.text = ""
        B8.text = ""
        B9.text = ""
        gameFinished = false
        currentPlayer = if (currentPlayer == 1) 2 else 1
        currentPlayer = if (scorePlayer1 == 0 && scorePlayer2 == 0) 1 else currentPlayer

        tvplayer1.setTextColor(if (currentPlayer == 1) Color.BLACK else Color.RED)
        tvplayer2.setTextColor(if (currentPlayer == 2) Color.BLACK else Color.RED)
    }
}

