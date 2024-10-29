package com.example.hw9

import kotlin.random.Random

class Item(var name : String? = null,var description : String? = null,var ImageReasourceID : Int) {

    override fun toString(): String {//hw5 for the win
        return name?:""
    }


}
