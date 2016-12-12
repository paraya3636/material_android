package org.paradrops.materialsample

import android.app.Activity
import android.content.Context
import android.support.v4.app.ActivityOptionsCompat
import android.support.v4.util.Pair
import android.view.View
import android.widget.TextView
import org.paradrops.materialsample.view.top.TopActivity
import org.paradrops.materialsample.view.transition.MultipleSharedElementsActivity
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

        fun goMultipleSharedElementsView(context: Context, sharedImageView: View, sharedTextView: TextView) {
            val sharedImageTag = context.resources.getString(R.string.ShearedImage)
            val sharedTitleTag = context.resources.getString(R.string.ShearedTitle)

            val element1 = Pair<View, String>(sharedImageView, sharedImageTag)
            val element2 = Pair<View, String>(sharedTextView, sharedTitleTag)
            val options = ActivityOptionsCompat.makeSceneTransitionAnimation(context as Activity, element1, element2)
            context.startActivity(MultipleSharedElementsActivity.navigateIntent(context), options.toBundle())
        }
    }
}