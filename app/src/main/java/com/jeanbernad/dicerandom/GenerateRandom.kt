package com.jeanbernad.dicerandom

interface GenerateRandom<in T, out B> {

    fun fromRange(min: T, max: T): B

    class Base : GenerateRandom<Int, Int> {

        override fun fromRange(min: Int, max: Int) = (min..max).random()
    }
}