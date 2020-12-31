package com.example.politicsagora.viewSource

import android.app.Dialog
import android.content.Context
import android.view.Window
import com.example.politicsagora.R

class LoadingDialog(context : Context) : Dialog(context) {

    init {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.loading_dialog);
        setCancelable(false)
    }
}