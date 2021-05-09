package com.saifil.io.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import com.saifil.io.aboutme.databinding.ActivityMainBinding
import com.saifil.io.aboutme.model.MeDataView

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val meDataView = MeDataView(name = "Saifil Momin")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.meDataView = meDataView

        setupNickname()
    }

    private fun setupNickname() = with(binding) {
        save.setOnClickListener {
            meDataView?.nickname = nicknameEdit.text.toString()

            // invalidate all binding expressions so
            // that they get created with the correct data
            invalidateAll()
            nicknameText.visibility = View.VISIBLE
            save.visibility = View.GONE
            nicknameEdit.visibility = View.GONE

            // hide the keyboard
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(save.windowToken, 0)
        }

        nicknameText.setOnClickListener {
            save.visibility = View.VISIBLE
            nicknameEdit.visibility = View.VISIBLE
        }
    }
}
