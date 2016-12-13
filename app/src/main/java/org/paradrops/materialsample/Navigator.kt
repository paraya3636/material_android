package org.paradrops.materialsample

import android.app.Activity
import android.content.Context
import android.support.v4.app.ActivityOptionsCompat
import android.support.v4.util.Pair
import android.view.View
import android.widget.TextView
import org.paradrops.materialsample.view.activitytransition.MultipleSharedElementsActivity
import org.paradrops.materialsample.view.activitytransition.SharedElementActivity
import org.paradrops.materialsample.view.activitytransition.TransitionActivity
import org.paradrops.materialsample.view.dialogtransition.DialogTransitionActivity
import org.paradrops.materialsample.view.fragmenttransition.FragmentTransitionActivity
import org.paradrops.materialsample.view.top.TopActivity

class Navigator {
    companion object {
        fun goTopView(context: Context) {
            context.startActivity(TopActivity.navigateIntent(context))
        }

        fun goTransitionView(context: Context) {
            context.startActivity(TransitionActivity.navigateIntent(context))
        }

        fun goFragmentTransitionView(context: Context) {
            context.startActivity(FragmentTransitionActivity.navigateIntent(context))
        }

        fun goDialogTransitionView(context: Context) {
            context.startActivity(DialogTransitionActivity.navigateIntent(context))
        }

        fun goSharedElementView(context: Context, sharedElement: View) {
            val sharedElementName = context.getString(R.string.CommonSharedImage)
            val options = ActivityOptionsCompat.makeSceneTransitionAnimation(context as Activity, sharedElement, sharedElementName)
            context.startActivity(SharedElementActivity.navigateIntent(context), options.toBundle())
        }

        fun goMultipleSharedElementsView(context: Context, sharedImageView: View, sharedTextView: TextView) {
            val sharedImageTag = context.getString(R.string.CommonSharedImage)
            val sharedTitleTag = context.getString(R.string.CommonSharedTitle)

            val element1 = Pair<View, String>(sharedImageView, sharedImageTag)
            val element2 = Pair<View, String>(sharedTextView, sharedTitleTag)
            val options = ActivityOptionsCompat.makeSceneTransitionAnimation(context as Activity, element1, element2)
            context.startActivity(MultipleSharedElementsActivity.navigateIntent(context), options.toBundle())
        }
    }
}