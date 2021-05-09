package com.saifil.io.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.saifil.io.diceroller.databinding.DiceRollerViewBinding

private const val DICE_NUM_NUM = 1
private const val NUM_DEICE_SIDES = 6

class MainActivity : AppCompatActivity() {

    private lateinit var binding: DiceRollerViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DiceRollerViewBinding.inflate(layoutInflater).also {
            setContentView(it.root)
        }

        setupDiceView()
    }

    private fun setupDiceView() = with(binding) {
        rollButton.text = getString(R.string.roll)
        rollDice()
        rollButton.setOnClickListener {
            rollDice()
        }
    }

    private fun rollDice() {
        (DICE_NUM_NUM..NUM_DEICE_SIDES).random().let { randomNum ->
            val diceImageResId = when(randomNum) {
                1 -> R.drawable.dice_1
                2 -> R.drawable.dice_2
                3 -> R.drawable.dice_3
                4 -> R.drawable.dice_4
                5 -> R.drawable.dice_5
                else -> R.drawable.dice_6
            }
            binding.diceImage.setImageResource(diceImageResId)
        }
    }

}
