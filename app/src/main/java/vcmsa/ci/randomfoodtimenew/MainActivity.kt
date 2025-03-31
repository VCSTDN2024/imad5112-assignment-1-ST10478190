package vcmsa.ci.randomfoodtimenew

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var btncheckfood: Button
    private lateinit var textView: TextView
    private lateinit var btnclear: Button
    private lateinit var foodInput: EditText
    private lateinit var btnexit : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.textView)
        btncheckfood = findViewById(R.id.btncheckfood)
        btnclear = findViewById(R.id.btnclear)
        foodInput = findViewById(R.id.Foodinput)
        btnexit = findViewById(R.id.btnexit)

        btncheckfood.setOnClickListener {
            checkFood()
        }

        btnclear.setOnClickListener {
            clear()
        }
        btnexit.setOnClickListener {
            exit ()
        }
    }
//is not empty function 
    private fun isNotEmpty(): Boolean {
        val input = foodInput.text.toString().trim()
        return if (input.isEmpty()) {
            foodInput.error = "REQUIRED!"
            textView.text = "REQUIRED!"
            false
        } else {
            true
        }
    }

    private fun checkFood() {

        if (isNotEmpty()) {
//code for food time
            val time = foodInput.text.toString().trim().lowercase()
            textView.text = when (time) {
                "morning" -> "Breakfast: Eggs with avo\n oats with a banana\n  muesli and yoghurt"
                "mid morning" -> "mid morning snack: jungle oats bar\n packet of nuts "
                "afternoon" -> "Lunch: chicken and rice\n steak and rice\n mince and pasta "
                "mid afternoon" -> "afternoon snack: 1 serving oats\n fruit salad  "
                "evening" -> "Dinner: Grilled chicken with rice\n mince and rice\n chicken pasta salad"
                "night" -> "Evening Snack: protein shake"
                "mid night" -> "mid night snack: GO TO SLEEP!!"
                else -> "Invalid Time! Please enter Morning, Afternoon, Evening, or Night."
            }
        }
    }

    private fun clear() {
        foodInput.text.clear()
        textView.text = ""
    }

    private fun exit(){
        finishAndRemoveTask()
    }
}

