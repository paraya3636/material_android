package org.paradrops.materialsample.view.top

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.view.View
import butterknife.bindView
import org.paradrops.materialsample.Navigator
import org.paradrops.materialsample.R

class TopActivity : AppCompatActivity(), TopViewContentAdapter.OnItemClickListener {
    companion object {
        fun navigateIntent(context: Context) : Intent {
            return Intent(context, TopActivity::class.java)
        }
    }

    private val adapter = TopViewContentAdapter(this)
    private val toolbar by bindView<Toolbar>(R.id.toolbar)
    private val recyclerView by bindView<RecyclerView>(R.id.recyclerView)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_top)
        setSupportActionBar(toolbar)

        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView.adapter = adapter
        adapter.onItemClickListener = this

        val fab = findViewById(R.id.fab) as FloatingActionButton
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
    }

    override fun onItemClick(view: View, position: Int) {
        when(position) {
            0 -> Navigator.goTransitionView(this)
            else -> {
                // Do nothing
            }
        }
    }
}
