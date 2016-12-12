package org.paradrops.materialsample.view.activitytransition

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import org.paradrops.materialsample.R

class SharedElementActivity : AppCompatActivity() {
    companion object {
        fun navigateIntent(context: Context) : Intent {
            return Intent(context, SharedElementActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_element)
    }
}
