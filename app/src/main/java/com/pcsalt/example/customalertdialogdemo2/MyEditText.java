package com.pcsalt.example.customalertdialogdemo2;

import android.content.Context;
import android.support.v7.widget.AppCompatEditText;
import android.view.ViewGroup.LayoutParams;
import android.view.inputmethod.EditorInfo;
import android.widget.LinearLayout;

/**
 * Created by Navkrishna on 12 October, 2017
 */

public class MyEditText extends AppCompatEditText {

    public MyEditText(Context context) {
        super(context);
        this.setSingleLine();
        this.setImeOptions(EditorInfo.IME_ACTION_DONE);
        this.setImeActionLabel("Done", EditorInfo.IME_ACTION_DONE);
        this.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
    }
}
