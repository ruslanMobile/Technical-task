package com.example.technicaltask.presentation

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.models.MeaningModel
import com.example.domain.models.ResultModel
import com.example.technicaltask.R

class ListAdapter(private var dataSet: List<MeaningModel>) :
    RecyclerView.Adapter<ListAdapter.ViewHolder>() {

    fun changeList(list: List<MeaningModel>){
        dataSet = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_result,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val obj = dataSet[position]
        holder.textEditPartOfSpeech.text = obj.partOfSpeech
        holder.textEditDefinition.text = obj.definitions[0].definition
        Log.d("MyLog","definition" + obj.definitions[0].definition)
    }

    override fun getItemCount() = dataSet.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textEditPartOfSpeech: TextView
        val textEditDefinition: TextView
        init {
            textEditPartOfSpeech = view.findViewById(R.id.textEditPartOfSpeech)
            textEditDefinition = view.findViewById(R.id.textEditDefinition)
        }
    }
}