package com.example.multipleedittextsample

import android.content.DialogInterface
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.KeyEvent
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

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
                Log.d("a", "$p0")
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                Log.d("a", "$p0")
            }
        })

        next?.setOnKeyListener { v, keyCode, event -> //You can identify which key pressed buy checking keyCode value with KeyEvent.KEYCODE_
            if (keyCode == KeyEvent.KEYCODE_DEL) {
                next.clearFocus()
                current.requestFocus()
                current.setText("")
            }
            false
        }
    }

}
