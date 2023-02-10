package com.jgomwal111.listadedeseos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import com.jgomwal111.listadedeseos.model.dataObject.Item

class FormActivity : AppCompatActivity() {

    lateinit var tvName:TextView
    lateinit var etName:EditText
    lateinit var tvDescription:TextView
    lateinit var etDescription:EditText
    lateinit var tvDate:TextView
    lateinit var dpDate:DatePicker
    lateinit var tvAge:TextView
    lateinit var sAge:Spinner

    lateinit var ages: ArrayList<Int>

    lateinit var btnGoBack:Button
    lateinit var btnSave:Button

    lateinit var adapter:ItemAdapter

    lateinit var items:MutableList<Item>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.form_view)
        initView()
    }

    private fun goMain(view: View){
        val go = Intent(this, ListActivity::class.java)
        startActivity(go)
    }

    private fun addItem(){
        val itemToAdd:Item = Item()
        items.add(itemToAdd)
        adapter.notifyDataSetChanged();
    }

    private fun initView(){
        btnGoBack = findViewById(R.id.btnGoBack)
        btnSave = findViewById(R.id.btnSave)
        sAge = findViewById(R.id.sAge)
        tvName = findViewById(R.id.tvName)
        tvDescription = findViewById(R.id.tvDescription)
        tvDate = findViewById(R.id.tvDate)
        tvAge = findViewById(R.id.tvAge)
        etName = findViewById(R.id.etName)
        etDescription = findViewById(R.id.etDescription)
        dpDate.setOnClickListener { showDatePicker() }
        sAge = findViewById(R.id.sAge)
    }

    private fun ageSpinner(){
        ages = ArrayList<Int>(100)
        var num:Int = 0
        while(num < ages.size) {
            num++
            ages.add(num)
        }
        val size = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, array)
        sAge.adapter = size
    }

    private fun showDatePicker() {
        val datePicker = DatePickerFragment { day, month, year -> onDateSelected(day, month, year) }
        datePicker.show(supportFragmentManager, "datePicker")
    }
}