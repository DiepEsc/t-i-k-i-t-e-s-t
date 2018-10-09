package com.tiki.test.diepesc.activity

import com.tiki.test.diepesc.service.ServiceManager
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainPresenter {
    private var view: MainView? = null
    fun start(view: MainView) {
        this.view = view
    }

    fun requestKeywordList() {
        view?.requestingKeywordList = true
        ServiceManager.tikiTestService
                .getKeywordList()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(
                        { result ->
                            view?.updateKeywordList(result)
                            view?.requestingKeywordList = false
                        }
                ) { error ->
                    var message = error.message
                    if (message == null) {
                        message = error.toString()
                    }

                    view?.showError(message)
                    view?.requestingKeywordList = false
                }
    }

    fun stop() {
        view = null
    }
}
