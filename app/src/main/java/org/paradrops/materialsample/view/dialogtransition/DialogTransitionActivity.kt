package org.paradrops.materialsample.view.dialogtransition

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.AdapterView
import android.widget.GridView
import butterknife.bindView
import org.paradrops.materialsample.R

class DialogTransitionActivity : AppCompatActivity() {
    companion object {
        fun navigateIntent(context: Context) : Intent {
            return Intent(context, DialogTransitionActivity::class.java)
        }
    }

    private val gridView by bindView<GridView>(R.id.gridView)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dialog_transition)
        gridView.adapter = CatsImageViewAdapter.create(this)
        gridView.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            val resId = CatsImageViewAdapter.items()[position]
            SharedElementDialogActivity.show(this, view, resId)
        }
    }
}
