package br.com.uniftec.avaliadorpolitico.utils

import android.content.Context
import android.content.DialogInterface
import android.view.View
import androidx.appcompat.app.AlertDialog

class DialogAdapter(private val viewUtil: View?, private val context: Context, private val positiveButton: String?, private val negativeButton: String?, private val neutralButton: String?, private val positiveListener: DialogInterface.OnClickListener?, private val negativeListener: DialogInterface.OnClickListener?, private val neutralListener: DialogInterface.OnClickListener?, private val title: String, private val message: String?) {
    protected var builder: AlertDialog.Builder? = null
    fun createDialogBuilder(): AlertDialog {
        defaultBuilderInit()
        return builder!!.create()
    }

    protected fun defaultBuilderInit() {
        builder = AlertDialog.Builder(context)
        builder!!.setPositiveButton(positiveButton, positiveListener)
        builder!!.setNegativeButton(negativeButton, negativeListener)
        builder!!.setTitle(title)
        if (message != null) builder!!.setMessage(message)
        if (neutralButton != null && neutralListener != null) {
            builder!!.setNeutralButton(neutralButton, neutralListener)
        }
        if (viewUtil != null) builder!!.setView(viewUtil)
    }
}