package org.paradrops.materialsample.view.fragmenttransition

import android.os.Bundle
import android.support.v4.app.Fragment
import android.transition.Fade
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import butterknife.bindView
import org.paradrops.materialsample.R
import org.paradrops.materialsample.transition.ScaleChangeTransition

class BeforeFragment : Fragment() {

    private val transitionButton by bindView<ImageButton>(R.id.transitionButton)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_before, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        transitionButton.setOnClickListener {
            val fragment = AfterFragment()

            // enter
            fragment.sharedElementEnterTransition = ScaleChangeTransition()
            fragment.enterTransition = Fade()

            // exit
            fragment.sharedElementReturnTransition = ScaleChangeTransition()
            fragment.exitTransition = Fade()

            val sharedElementTag = getString(R.string.CommonSharedImage)
            activity.supportFragmentManager
                    .beginTransaction()
                    .addSharedElement(transitionButton, sharedElementTag)
                    .replace(R.id.fragmentContainer, fragment)
                    // FIXME: Not work before fragment click listener
                    .addToBackStack(null)
                    .commit()
        }
    }
}