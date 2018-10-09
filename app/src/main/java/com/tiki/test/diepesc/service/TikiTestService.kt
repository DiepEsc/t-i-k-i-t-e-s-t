package com.tiki.test.diepesc.service

import io.reactivex.Observable
import retrofit2.http.GET

interface TikiTestService {
    @GET("38b790795722e7d7b1b5db051c5786e5/raw/63380022f5f0c9a100f51a1e30887ca494c3326e/keywords.json")
    fun getKeywordList(): Observable<List<String>>
}