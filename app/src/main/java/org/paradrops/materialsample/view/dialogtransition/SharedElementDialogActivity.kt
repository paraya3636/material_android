package org.paradrops.materialsample.view.dialogtransition

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.ActivityOptionsCompat
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.Window
import android.widget.Button
import android.widget.ImageView
import android.widget.RelativeLayout
import butterknife.bindView
import org.paradrops.materialsample.R

class SharedElementDialogActivity : AppCompatActivity() {
    companion object {
        private val ImageResourceId = "ImageResourceId"

        fun show(context: Context, sharedElement: View, imageResId: Int) {
            val intent = Intent(context, SharedElementDialogActivity::class.java)
            intent.putExtra(ImageResourceId, imageResId)
            val options = ActivityOptionsCompat.makeSceneTransitionAnimation(
                    context as Activity,
                    sharedElement,
                    context.getString(R.string.CommonSharedImage))
            context.startActivity(intent, options.toBundle())
        }
    }

    private val imageResId by lazy { intent.getIntExtra(ImageResourceId, 0) }
    private val contentView by bindView<RelativeLayout>(R.id.contentView)
    private val imageView by bindView<ImageView>(R.id.imageView)
    private val button by bindView<Button>(R.id.button)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.activity_shared_element_dialog)
        imageView.setImageResource(imageResId)

        contentView.setOnClickListener {
            supportFinishAfterTransition()
        }

        button.setOnClickListener {
            supportFinishAfterTransition()
        }
    }
}
