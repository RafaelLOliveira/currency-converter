package br.com.example.currencyconverter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        Toast.makeText(this, "Welcome", Toast.LENGTH_LONG).show()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.calculate_button).setOnClickListener {
            Toast.makeText(this, "Currency Converted", Toast.LENGTH_SHORT).show()

            val currencyTyped = defineCurrencyTyped(findViewById(R.id.currency_value))

            val result: Double = currencyConversion(currencyTyped)

            val currencyConverted : TextView = findViewById(R.id.currency_converted_field)
            currencyConverted.text = "Currency Converted: $result"
        }

    }

    private fun currencyConversion(currencyTyped: Double) : Double{
        val checkedCurrencyInRadioGroup: Int = defineCheckedCurrency()
        var currencyForCalculation : Double = 0.0
        if(checkedCurrencyInRadioGroup == R.id.option_dollar){
            currencyForCalculation = 5.42
        }
        else{
            currencyForCalculation = 6.14
        }
        return currencyForCalculation * currencyTyped
    }

    private fun defineCheckedCurrency(): Int {
        val radioGroup: RadioGroup = findViewById(R.id.currency_options)
        val checkedCurrency: Int = radioGroup.checkedRadioButtonId
        return checkedCurrency
    }

    private fun defineCurrencyTyped(editTextField: EditText): Double {
        val temp: String = editTextField.text.toString()
        return temp.toDouble()
    }

}




