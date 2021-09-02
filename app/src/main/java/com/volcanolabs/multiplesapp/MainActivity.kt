package com.volcanolabs.multiplesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.volcanolabs.multiplesapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import java.lang.Exception
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var multiples: Multiples
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: MultiplesListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        adapter = MultiplesListAdapter()
        binding.rvMultiplesList.adapter = adapter
        binding.btnGenerate.setOnClickListener {
            val numberText = binding.etNumber.text.toString()

            try {
                val number = numberText.toInt()
                if (numberText.isNotEmpty() && number > 0) {
                    val multiples = multiples.calculateMultiples(number)
                    adapter.setData(multiples)
                } else {
                    displayError()
                }
            } catch (exception: Exception) {
                displayError()
            }

        }
        setContentView(binding.root)
    }

    private fun displayError() {
        Toast.makeText(this, getString(R.string.invalid_number), Toast.LENGTH_SHORT)
            .show()
    }
}