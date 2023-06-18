package com.works.vize3.extensions

import android.app.AlertDialog
import android.content.DialogInterface
import android.widget.Toast
import androidx.fragment.app.Fragment

class AlertTools {
    companion object AlertTools {
        fun Fragment.showToast(message: String) {
            Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
        }

        fun Fragment.showAlertDialog(
            title: String,
            message: String,
            positiveButtonText: String,
            negativeButtonText: String,
            positiveButtonListener: (DialogInterface, Int) -> Unit
        ) {
            AlertDialog.Builder(requireContext())
                .setTitle(title)
                .setMessage(message)
                .setCancelable(true)
                .setPositiveButton(positiveButtonText, positiveButtonListener)
                .setNegativeButton(negativeButtonText) { dialogInterface, it ->
                    dialogInterface.cancel()
                }
                .show()
        }

    }
}