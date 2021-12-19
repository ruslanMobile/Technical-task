package com.example.technicaltask.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.lifecycle.ViewModelProvider
import com.example.data.network.NetworkGetInfoImpl
import com.example.data.repository.InfoRepositoryImpl
import com.example.domain.models.SearchModel
import com.example.domain.usecase.GetInfoUseCase
import com.example.technicaltask.R
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel:MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        val textInputEditText = findViewById<TextInputEditText>(R.id.textInputEditText)
        val buttonSearch = findViewById<Button>(R.id.buttonSearch)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.resultLiveData.observe(this,{
            for (el in it) {
                Log.d("MyLog", "MainActivity " + el.word + el.phonetic + el.meanings[0].definition)
            }
        })


        buttonSearch.setOnClickListener {
            //Search info
            viewModel.getInfo(textInputEditText.text.toString())
        }
    }
}