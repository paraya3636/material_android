package org.paradrops.materialsample.view.dialogtransition

import android.app.Dialog
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v7.app.AlertDialog
import org.paradrops.materialsample.R

class SharedElementDialogFragment : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(context)
        builder.setTitle("Cat")
        builder.setPositiveButton("OK", null)
        builder.setView(R.layout.dialog_shared_element_content)
        return builder.create()
    }
}