package com.tiki.test.diepesc.service

import com.tiki.test.diepesc.TikiTestApplication
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object ServiceManager {
    private val builder = Retrofit.Builder()
            .baseUrl(TikiTestApplication.TIKI_TEST_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())

    fun <S> createService(serviceClass: Class<S>): S {
        return builder.build().create(serviceClass)
    }

    val tikiTestService = createService(TikiTestService::class.java)
}
