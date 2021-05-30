package com.pcsalt.example.customalertdialogdemo2

import android.content.Context
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.LinearLayout
import androidx.appcompat.widget.AppCompatEditText

/**
 * Created by Navkrishna on 12 October, 2017
 */
class MyEditText(context: Context?) : AppCompatEditText(context!!) {
    init {
        this.setSingleLine()
        this.imeOptions = EditorInfo.IME_ACTION_DONE
        setImeActionLabel("Done", EditorInfo.IME_ACTION_DONE)
        this.layoutParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
    }
}