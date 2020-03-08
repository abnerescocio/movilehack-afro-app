package com.movilehackafro.app.ui.content.get

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.movilehackafro.app.R
import kotlinx.android.synthetic.main.activity_content_get.*

class ContentGetActivity : AppCompatActivity() {

    private lateinit var subAreaName: String
    private lateinit var subAreaDescription: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content_get)

        subAreaName = intent?.getStringExtra(ARG_SUB_AREA_NAME)!!
        subAreaDescription = intent?.getStringExtra(ARG_SUB_AREA_DESCRIPTION)!!

        configureViews()
    }

    private fun configureViews() {
        imageView_sub_area_get_close.setOnClickListener {
            finish()
        }

        textView_sub_area_get_title.text = subAreaName
        textView_sub_area_get_description.text = subAreaDescription
    }

    companion object {
        const val ARG_SUB_AREA_NAME = "argSubAreaName"
        const val ARG_SUB_AREA_DESCRIPTION = "argSubAreaDescription"
    }
}
