package com.jgomwal111.listadedeseos.model.dataObject

class User {

    private var name:String = ""
    private var id:Long = 0

    constructor(name: String) {
        this.name = name
    }

    fun getId():Long{
        return id
    }
    fun getName():String{
        return name
    }
}