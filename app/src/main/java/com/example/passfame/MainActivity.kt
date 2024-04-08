package com.example.passfame
import android.widget.Button
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    data class FamousPerson(val name: String, val age: Int)
// Here we will define our list of historical figures
    private val famousPeople = listOf(
        FamousPerson("W.A. Mozart", 35),
        FamousPerson("Cleopatra", 39),
        FamousPerson("Napoleon", 52),
        FamousPerson("Columbus", 55),
        FamousPerson("Julius Cesar", 56),
        FamousPerson("Adolf Hitler", 56),
        FamousPerson("Martin Luther", 63),
        FamousPerson("Leonardo da Vinci", 67),
        FamousPerson("Mahatma Gandhi", 78),
        FamousPerson("Albert Einstein", 39),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       // Implementation of our UI navigation and inout/output
        val inputAge = findViewById<EditText>(R.id.inputAge)
        val submitButton = findViewById<Button>(R.id.submitButton)
        val clearButton = findViewById<Button>(R.id.clearButton)
        val resultText = findViewById<TextView>(R.id.resultText)

        // Error handling and logic implementation
        submitButton.setOnClickListener {
            val age = inputAge.text.toString().toIntOrNull()
            if (age == null || age !in 20..100) {
                Toast.makeText(this, "Please enter a valid age between 20 and 100", Toast.LENGTH_SHORT).show()
            } else {
                val famousPerson = famousPeople.find { it.age == age }
                if (famousPerson != null) {
                    resultText.text = "Famous person: ${famousPerson.name}"
                } else {
                    resultText.text = "No famous person found for age $age"
                }
            }
        }

        clearButton.setOnClickListener {
            inputAge.text.clear()
            resultText.text = ""
        }
    }
}