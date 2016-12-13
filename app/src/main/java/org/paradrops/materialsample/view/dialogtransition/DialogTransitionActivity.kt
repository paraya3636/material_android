package org.paradrops.materialsample.view.dialogtransition

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.transition.Fade
import android.widget.ImageButton
import butterknife.bindView
import org.paradrops.materialsample.R
import org.paradrops.materialsample.transition.ScaleChangeTransition

class DialogTransitionActivity : AppCompatActivity() {
    companion object {
        fun navigateIntent(context: Context) : Intent {
            return Intent(context, DialogTransitionActivity::class.java)
        }
    }

    private val dialogFragmentTransitionButton by bindView<ImageButton>(R.id.dialogFragmentTransitionButton)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dialog_transition)
        dialogFragmentTransitionButton.setOnClickListener {

            val dialog = SharedElementDialog()
            // enter
            dialog.sharedElementEnterTransition = ScaleChangeTransition()
            dialog.enterTransition = Fade()

            // exit
            dialog.sharedElementReturnTransition = ScaleChangeTransition()
            dialog.exitTransition = Fade()

            val sharedElementTag = getString(R.string.CommonSharedImage)
            val transaction = supportFragmentManager
                    .beginTransaction()
                    .addSharedElement(dialogFragmentTransitionButton, sharedElementTag)
                    .addToBackStack(null)
            dialog.show(transaction, "SharedElementDialog")
        }
    }
}
