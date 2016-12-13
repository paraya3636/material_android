package org.paradrops.materialsample.view.dialogtransition

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.ActivityOptionsCompat
import android.support.v7.app.AppCompatActivity
import android.view.View
import org.paradrops.materialsample.R

class SharedElementDialogActivity : AppCompatActivity() {
    companion object {
        fun show(context: Context, sharedElement: View) {
            val intent = Intent(context, SharedElementDialogActivity::class.java)
            val options = ActivityOptionsCompat.makeSceneTransitionAnimation(
                    context as Activity,
                    sharedElement,
                    context.getString(R.string.CommonSharedImage))
            context.startActivity(intent, options.toBundle())
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_element_dialog)
    }
}
