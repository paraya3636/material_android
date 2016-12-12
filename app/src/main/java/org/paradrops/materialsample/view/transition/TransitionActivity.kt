package org.paradrops.materialsample.view.transition

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ImageButton
import android.widget.TextView
import butterknife.bindView
import org.paradrops.materialsample.Navigator
import org.paradrops.materialsample.R

class TransitionActivity : AppCompatActivity() {
    companion object {
        fun navigateIntent(context: Context) : Intent {
            return Intent(context, TransitionActivity::class.java)
        }
    }

    private val activityTransitionButton by bindView<ImageButton>(R.id.activityTransitionButton)
    private val multipleSharedElementsButton by bindView<ImageButton>(R.id.multipleSharedElementsButton)
    private val multipleSharedElementsTitle by bindView<TextView>(R.id.multipleSharedElementsTitle)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transition)

        activityTransitionButton.setOnClickListener {
            Navigator.goSharedElementView(this, activityTransitionButton)
        }

        multipleSharedElementsButton.setOnClickListener {
            Navigator.goMultipleSharedElementsView(this, multipleSharedElementsButton, multipleSharedElementsTitle)
        }
    }
}
