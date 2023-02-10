package com.jgomwal111.listadedeseos.model.dataObject

import android.widget.DatePicker

class Item {
    private var id:Long = 0
    private lateinit var name:String
    private lateinit var description:String
    private lateinit var date:DatePicker
    private val age = IntArray(100) {i -> i+1}

    constructor(name: String, description: String, date: DatePicker) {
        this.name = name
        this.description = description
        this.date = date
    }
    constructor()

    fun getId():Long{
        return this.id
    }
    fun getName():String{
        return this.name
    }
    fun getDescription():String{
        return this.description
    }

    override fun toString(): String {
        return "Item(name='$name', description='$description', date=$date, age=${age.contentToString()})"
    }
}