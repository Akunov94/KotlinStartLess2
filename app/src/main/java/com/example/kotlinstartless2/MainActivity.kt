package com.example.kotlinstartless2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.inputmethod.EditorInfo
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private val UrlArr = mutableListOf<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addUrl()
        setUrl()
        btn_random.setOnClickListener {
            val url: String = UrlArr.random()
            img_load.loadImage(this, url)
        }
    }

    private fun setUrl() {
        input_tx_collection.setOnEditorActionListener(object : TextView.OnEditorActionListener {
            override fun onEditorAction(v: TextView?, actionId: Int, event: KeyEvent?): Boolean {
                if (actionId == EditorInfo.IME_ACTION_SEND) {
                    UrlArr.add(input_tx_collection.text.toString())
                    return true
                }
                return false
            }
        })
    }

    private fun addUrl() {
        UrlArr.add("https://i.pinimg.com/originals/94/1a/16/941a1638848c06d3d83139f2ba267c9d.jpg")
        UrlArr.add("https://i.pinimg.com/originals/70/d0/08/70d008276b56a41793ae51bff0f70e9c.jpg")
        UrlArr.add("https://99px.ru/sstorage/53/2018/02/mid_218938_357945.jpg")
        UrlArr.add("https://i.pinimg.com/originals/f4/d2/96/f4d2961b652880be432fb9580891ed62.png")
        UrlArr.add("https://image.winudf.com/v2/image1/Y29tLmN1dGVraXR0ZW5zLndhbGxwYXBlcl9zY3JlZW5fM18xNTczOTE2MDk0XzAxOA/screen-3.jpg?fakeurl=1&type=.jpg")
    }
}