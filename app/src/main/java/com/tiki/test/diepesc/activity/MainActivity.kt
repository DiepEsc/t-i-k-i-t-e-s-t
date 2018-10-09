package com.tiki.test.diepesc.activity

import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.tiki.test.diepesc.R
import com.tiki.test.diepesc.adapter.KeywordAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainView {
    override var requestingKeywordList: Boolean
        get() = progressbarKeyword.visibility == View.VISIBLE
        set(value) {
            if (value) {
                progressbarKeyword.visibility = View.VISIBLE
            } else{
                progressbarKeyword.visibility = View.GONE
            }
        }
    private val presenter = MainPresenter()
    private lateinit var errorDialog: AlertDialog

    override fun showError(msg: String) {
        errorDialog.setMessage(msg)
        errorDialog.show()
    }

    override fun updateKeywordList(keywords: List<String>) {
        val adapter = KeywordAdapter(keywords)
        rvKeyword.adapter = adapter
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        errorDialog = AlertDialog.Builder(this)
                .setTitle(R.string.txt_Error)
                .setPositiveButton(R.string.txt_Ok) { dialog, _ -> dialog.dismiss() }
                .create()
        rvKeyword.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        presenter.start(this)
        presenter.requestKeywordList()
        progressbarKeyword.visibility = View.VISIBLE
    }

    override fun onDestroy() {
        presenter.stop()
        super.onDestroy()
    }
}
