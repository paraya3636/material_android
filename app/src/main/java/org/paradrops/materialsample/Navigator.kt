package org.paradrops.materialsample

import android.content.Context
import org.paradrops.materialsample.view.top.TopActivity
import org.paradrops.materialsample.view.transition.TransitionActivity

class Navigator {
    companion object {
        fun goTopView(context: Context) {
            context.startActivity(TopActivity.navigateIntent(context))
        }

        fun goTransitionView(context: Context) {
            context.startActivity(TransitionActivity.navigateIntent(context))
        }
    }
}