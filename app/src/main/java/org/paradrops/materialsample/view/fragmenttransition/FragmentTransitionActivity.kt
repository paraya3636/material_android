package org.paradrops.materialsample.view.fragmenttransition

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import org.paradrops.materialsample.R

class FragmentTransitionActivity : AppCompatActivity() {
    companion object {
        fun navigateIntent(context: Context) : Intent {
            return Intent(context, FragmentTransitionActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment_transition)

        supportFragmentManager
                .beginTransaction()
                .add(R.id.fragmentContainer, BeforeFragment())
                .commit()
    }
}
