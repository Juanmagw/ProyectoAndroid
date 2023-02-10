package com.jgomwal111.listadedeseos

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ExpandableListView.OnChildClickListener
import androidx.recyclerview.widget.RecyclerView
import com.jgomwal111.listadedeseos.model.dataObject.Item

class ItemAdapter(private val onUserClickListener: OnChildClickListener):RecyclerView.Adapter<ItemViewHolder>() {

    private var items: ArrayList<Item> = ArrayList()
    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val layoutInflater:LayoutInflater = LayoutInflater.from(parent.context)
        return ListViewHolder(layoutInflater.inflate(R.layout.list_itemview, parent, false))
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val item = items.get(position)
        holder.render(item, context)
    }

    override fun getItemCount(): Int {
        return items.size
    }


}