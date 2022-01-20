package br.com.example.currencyconverter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import br.com.example.currencyconverter.databinding.ActivityMainBinding
import java.text.NumberFormat


class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    var currencySelected : Double = 0.0
    var calculation : Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        Toast.makeText(this, "Welcome", Toast.LENGTH_LONG).show()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //inicia objeto binding
        binding = ActivityMainBinding.inflate(layoutInflater)


        findViewById<Button>(R.id.calculate_button).setOnClickListener {
            Toast.makeText(this, "Vc clicou", Toast.LENGTH_SHORT).show()
            calculateCurrency()

        }

    }


    private fun calculateCurrency() {
        //take the typed number
        val stringInTextField = binding.currencyValue.text.toString()
        val currencyTyped = stringInTextField.toDouble()

        //take the currency option
        val selectedId  = binding.currencyOptions.checkedRadioButtonId

        defineCurrencySelected(selectedId)
        calculateCurrencyConversion(currencyTyped)

        val formattedCurrency = NumberFormat.getCurrencyInstance().format(calculation)

        binding.currencyConverted.text = "aa"
    }



    private fun calculateCurrencyConversion(currencyTyped: Double) {
        calculation = currencySelected * currencyTyped
    }


    //function what returns a double
    private fun defineCurrencySelected(selectedId: Int):Double {
        if(selectedId == R.id.option_dollar){
            currencySelected = 6.0
        }
        else{
            currencySelected = 7.0
        }
        return currencySelected
    }

}




