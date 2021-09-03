package com.volcanolabs.multiplesapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.volcanolabs.multiplesapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: MultiplesListAdapter
    val viewModel: MultiplesViewModel by viewModels()

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
                    viewModel.calculateMultiples(number)
                } else {
                    displayError()
                }
            } catch (exception: Exception) {
                displayError()
            }

        }

        viewModel.multiplesObs.observe(this, {
            adapter.setData(it)
        })
        setContentView(binding.root)
    }

    private fun displayError() {
        Toast.makeText(this, getString(R.string.invalid_number), Toast.LENGTH_SHORT)
            .show()
    }
}