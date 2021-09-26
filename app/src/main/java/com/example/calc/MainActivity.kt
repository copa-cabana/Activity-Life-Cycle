package com.example.calc

import android.content.ActivityNotFoundException
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.content.Intent
import android.net.Uri
import com.example.calc.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding

    private var total = 0
    private var totalTwo = 0

    companion object{
        const val TAG = "Main Activity"
        const val CALC_TOTAL = "total_calc"
        const val SUM_TOTAL = "sum_calc"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.d(TAG, "onCreate Called")




        if(savedInstanceState != null) {
            total = savedInstanceState.getInt(CALC_TOTAL, 0)
            totalTwo = savedInstanceState.getInt(SUM_TOTAL,0)
        }


        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)


        val link = findViewById(R.id.btn_share) as Button

        val num1 = findViewById(R.id.input_one) as EditText

        val num2 = findViewById(R.id.input_two) as EditText

        val total = findViewById(R.id.total_display) as TextView

        val btn1 = findViewById(R.id.btn_add) as Button

        val btn2 = findViewById(R.id.btn_minus) as Button

        val btn3 = findViewById(R.id.btn_multiply) as Button

        val btn4 = findViewById(R.id.btn_divide) as Button

        val btn5 = findViewById(R.id.btn_cancel) as Button


        link.setOnClickListener {

            val intent = Intent(Intent.ACTION_SEND)

            // Always use string resources for UI text.
            // This says something like "Share this photo with"
            val title = resources.getString(R.string.Open_link_with)
            // Create intent to show chooser
            val chooser = Intent.createChooser(intent, "www.google.com")

            // Try to invoke the intent.
            try {
                startActivity(chooser)
            } catch (e: ActivityNotFoundException) {
                // Define what your app should do if no activity can handle the intent.
            }
        }



        btn1.setOnClickListener {

            val input1 = num1.text.toString().toIntOrNull()
            val input2 = num2.text.toString().toIntOrNull()

            val result = input1?.plus(input2!!)


            total.setText(result.toString())

            num1.setText("")
            num2.setText("")

        }

        btn2.setOnClickListener {

            val input1 = num1.text.toString().toIntOrNull()
            val input2 = num2.text.toString().toIntOrNull()

//            val result = input1?.plus(input2!!)

            val result = input1?.minus(input2!!)

            total.setText(result.toString())

            num1.setText("")
            num2.setText("")

        }

        btn3.setOnClickListener {

            val input1 = num1.text.toString().toIntOrNull()
            val input2 = num2.text.toString().toIntOrNull()

//            val result = input1?.plus(input2!!)
            val result = input1?.times(input2!!)

            total.setText(result.toString())

            num1.setText("")
            num2.setText("")

        }

        btn4.setOnClickListener {

            val input1 = num1.text.toString().toIntOrNull()
            val input2 = num2.text.toString().toIntOrNull()

//            val result = input1?.plus(input2!!)

            val result = input1?.div(input2!!)

            total.setText(result.toString())

            num1.setText("")
            num2.setText("")

        }

        btn5.setOnClickListener {

            total.setText("")
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart Called")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume Called")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause Called")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop Called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy Called")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart Called")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(CALC_TOTAL, total )
        outState.putInt(CALC_TOTAL, totalTwo )


        Log.d(TAG, "onSaveInstance Called")
    }
}