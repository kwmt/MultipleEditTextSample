package com.example.multipleedittextsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val editText1 = findViewById<EditText>(R.id.editText1)
        val editText2 = findViewById<EditText>(R.id.editText2)
        val editText3 = findViewById<EditText>(R.id.editText3)
        val editText4 = findViewById<EditText>(R.id.editText4)

        setupEditText(editText1, editText2)
        setupEditText(editText2, editText3)
        setupEditText(editText3, editText4)
        setupEditText(editText4, null)
    }

    private fun setupEditText(current: EditText, next: EditText?) {
        current.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
                val input = p0?.toString() ?: return
                if (input.length == 1) {
                    current.clearFocus()
                    next?.run {
                        requestFocus()
                        isCursorVisible = true
                    }
                }

            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
        })
    }
}
