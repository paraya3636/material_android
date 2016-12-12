package org.paradrops.materialsample

import android.app.Activity
import android.content.Context
import android.support.v4.app.ActivityOptionsCompat
import android.view.View
import org.paradrops.materialsample.view.top.TopActivity
import org.paradrops.materialsample.view.transition.SharedElementActivity
import org.paradrops.materialsample.view.transition.TransitionActivity

class Navigator {
    companion object {
        fun goTopView(context: Context) {
            context.startActivity(TopActivity.navigateIntent(context))
        }

        fun goTransitionView(context: Context) {
            context.startActivity(TransitionActivity.navigateIntent(context))
        }

        fun goSharedElementView(context: Context, sharedElement: View) {
            val sharedElementName = context.resources.getString(R.string.ShearedImage)
            val options = ActivityOptionsCompat.makeSceneTransitionAnimation(context as Activity, sharedElement, sharedElementName)
            context.startActivity(SharedElementActivity.navigateIntent(context), options.toBundle())
        }
    }
}