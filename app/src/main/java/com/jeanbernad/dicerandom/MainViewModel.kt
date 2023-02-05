package com.jeanbernad.dicerandom

import androidx.lifecycle.ViewModel

class MainViewModel(
    private val communication: Communication<Pair<Int, Int>>,
    private val generateRandom: GenerateRandom<Int, Int>
) : ViewModel() {

    fun state() = communication.flow()

    fun changePicture() {
        val randomValue = generateRandom.fromRange(MIN_RANGE, MAX_RANGE)
        communication.map(
            randomValue to
            when (randomValue) {
                1 -> R.drawable.dice_1
                2 -> R.drawable.dice_2
                3 -> R.drawable.dice_3
                4 -> R.drawable.dice_4
                5 -> R.drawable.dice_5
                else -> R.drawable.dice_6
            }
        )
    }

    companion object {
        private const val MIN_RANGE = 1
        private const val MAX_RANGE = 6
    }
}

