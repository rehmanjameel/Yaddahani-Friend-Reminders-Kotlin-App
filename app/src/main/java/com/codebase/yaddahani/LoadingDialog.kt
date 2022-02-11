package com.codebase.yaddahani

import android.app.Activity
import android.app.AlertDialog

class LoadingDialog(val mActivity: Activity) {

    private lateinit var isDialog: AlertDialog

    fun startDialog() {
        val inflater = mActivity.layoutInflater
        val dialogView = inflater.inflate(R.layout.progress_layout, null)
        val dialogBuilder = AlertDialog.Builder(mActivity)

        dialogBuilder.setView(dialogView)
        dialogBuilder.setCancelable(false)
        isDialog = dialogBuilder.create()
        isDialog.show()
    }

    fun dismissDialog() {
        isDialog.dismiss()
    }
}