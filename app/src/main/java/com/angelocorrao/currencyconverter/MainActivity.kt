package com.angelocorrao.currencyconverter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.angelocorrao.currencyconverter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private var money = "0"
    private var moneyValue = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.convert.setOnClickListener {
            convertCurrency()
        }
    }

    private fun convertCurrency() {
        money = binding.editText.text.toString().trim()
        if(money.isNotEmpty())
            moneyValue = money.toDouble()
        else
            moneyValue = 0.0

        when(binding.currencySpinner.selectedItem.toString()){
            "EUR" -> {
                var usd1 = moneyValue * 1.13
                var gbp1 = moneyValue * 0.84

                binding.eurValue.text = moneyValue.toString()
                binding.usdValue.text = usd1.toString()
                binding.gbpValue.text = gbp1.toString()
            }
            "USD" -> {
                var eur1 = moneyValue * 0.88
                var gbp2 = moneyValue * 0.74

                binding.eurValue.text = eur1.toString()
                binding.usdValue.text = moneyValue.toString()
                binding.gbpValue.text = gbp2.toString()
            }
            "GBP" -> {
                var eur2 = moneyValue * 1.19
                var usd2 = moneyValue * 1.35

                binding.eurValue.text = eur2.toString()
                binding.usdValue.text = usd2.toString()
                binding.gbpValue.text = moneyValue.toString()
            }
        }
    }
}