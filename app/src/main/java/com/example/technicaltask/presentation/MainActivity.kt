package com.example.technicaltask.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.data.network.NetworkGetInfoImpl
import com.example.data.repository.InfoRepositoryImpl
import com.example.domain.models.SearchModel
import com.example.domain.usecase.GetInfoUseCase
import com.example.technicaltask.R
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel:MainViewModel
    private lateinit var adapter: ListAdapter
    private lateinit var textInputEditText:TextInputEditText
    private lateinit var buttonSearch:Button
    private lateinit var recyclerView:RecyclerView
    private lateinit var textEditWord:TextView
    private lateinit var textEditPhonetic:TextView
    private lateinit var textWord:TextView
    private lateinit var textPhonetic:TextView
    private lateinit var progressBar:ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        //init
        textInputEditText = findViewById(R.id.textInputEditText)
        buttonSearch = findViewById(R.id.buttonSearch)
        recyclerView = findViewById(R.id.recyclerView)
        textEditWord = findViewById(R.id.textEditWord)
        textEditPhonetic = findViewById(R.id.textEditPhonetic)
        textWord = findViewById(R.id.textWord)
        textPhonetic = findViewById(R.id.textPhonetic)
        progressBar = findViewById(R.id.progressBar)
        //

        adapter = ListAdapter(listOf())
        recyclerView.adapter = adapter

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.resultLiveData.observe(this,{
            adapter.changeList(it[0].meanings)
            progressBar.visibility = View.GONE

            textEditWord.text = it[0].word
            textEditPhonetic.text = it[0].phonetic

            textWord.visibility = View.VISIBLE
            textPhonetic.visibility = View.VISIBLE
        })


        buttonSearch.setOnClickListener {
            //Search info
            viewModel.getInfo(textInputEditText.text.toString())
            progressBar.visibility = View.VISIBLE
        }
    }
}