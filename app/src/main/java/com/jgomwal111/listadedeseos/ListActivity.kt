package com.jgomwal111.listadedeseos

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jgomwal111.listadedeseos.model.dataObject.Item

class ListActivity : AppCompatActivity() {

    private lateinit var tbHeader: Toolbar
    private lateinit var btnGoForm: Button

    /*private var db:DataBaseConfig?=null
    private var list:MutableList<User> = ArrayList()*/

    private lateinit var rvItems: RecyclerView
    private lateinit var adapter: ItemAdapter

    private var items = mutableListOf <Item>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.list_view)
        initUi()
        btnGoForm.setOnClickListener {
            val go = Intent(this, FormActivity::class.java)
            startActivity(go)
        }
    }

    private fun initUi(){
        initView()
        initRecyclerView()
    }

    private fun initView(){
        tbHeader = findViewById(R.id.tbHeader)
        rvItems = findViewById(R.id.rvItems)
        btnGoForm = findViewById(R.id.btnGoForm)
        rvItems = findViewById<RecyclerView>(R.id.rvItems)
    }

    private fun initRecyclerView(){
        rvItems.layoutManager = LinearLayoutManager(this)
        adapter = ItemAdapter(items)
        rvItems.adapter = adapter
    }

    private fun addItem(){
        val item:Item = Item()
        items.add(item)
        adapter.notifyDataSetChanged()
    }
}