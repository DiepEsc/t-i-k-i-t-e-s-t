package com.tiki.test.diepesc.activity

interface MainView {
    fun showError(msg: String)
    fun updateKeywordList(keywords: List<String>)
    var requestingKeywordList: Boolean
}
