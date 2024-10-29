package com.example.hw9

import com.example.hw9.R

class Model {

    companion object{
        val items = arrayListOf<Item>().apply {
            add(Item("Starry Messenger","Starry Messenger by Neil deGrasse Tyson challenges our perspectives on science, culture, and the cosmos.", R.drawable.book1))
            add(Item("Death by Black Hole","Death by Black Hole by Neil deGrasse Tyson delves into cosmic phenomena and the mysteries of astrophysics.",R.drawable.book2 ))
            add(Item("Astrophysics for People in a Hurry","Astrophysics for People in a Hurry by Neil deGrasse Tyson offers a quick, accessible guide to the universe's biggest questions.",R.drawable.book3))
            add(Item("To Infinity and Beyond", "To Infinity and Beyond by Eli Maor explores the concept of infinity, its history, and its impact on mathematics and science.",R.drawable.book4))
            add(Item("Everything You Ever Need to Know About Space Travel, Sci-Fi, the Human Race, the Universe, and Beyond", "Everything You Ever Need to Know About Space Travel, Sci-Fi, the Human Race, the Universe, and Beyond by Adam Frost and Jim Kynvin is a fun, fact-packed guide to space, science fiction, and humanity’s place in the cosmos.",R.drawable.book5 ))
            add(Item("The Pluto Files","*The Pluto Files* by Neil deGrasse Tyson traces the story of Pluto's controversial reclassification from planet to dwarf planet and its cultural impact.",R.drawable.book6))
        }

        val cart = arrayListOf<Item>()


        /*
        init {
            items.add((Item()))
        }
        */
    }
}