package org.paradrops.materialsample.transition

import android.transition.ChangeBounds
import android.transition.ChangeImageTransform
import android.transition.ChangeTransform
import android.transition.TransitionSet

class ScaleChangeTransition : TransitionSet() {
    init {
        ordering = ORDERING_TOGETHER
        addTransition(ChangeBounds()).
                addTransition(ChangeTransform()).
                addTransition(ChangeImageTransform())
    }
}