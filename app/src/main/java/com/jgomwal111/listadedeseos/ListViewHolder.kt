package com.jgomwal111.listadedeseos

import android.content.Context
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jgomwal111.listadedeseos.model.dataObject.Item

class ListViewHolder (view:View):RecyclerView.ViewHolder(view){

    private val tvName:TextView = view.findViewById(R.id.tvName) as TextView
    private val tvDescription:TextView = view.findViewById(R.id.tvDescription) as TextView

    fun render(item: Item, context: Context){
        tvName.text = item.getName()
        tvDescription.text = item.getDescription()
    }
}