package com.yoenas.sub2kade.mvp.search

import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.ParsedRequestListener
import com.yoenas.sub2kade.model.SearchResponse
import com.yoenas.sub2kade.network.TheSportDBApi

class SearchPresenter(val view: SearchView) {

    fun getSearchResult(event: String) {
        AndroidNetworking.get(TheSportDBApi.getSearchResult(event))
            .setPriority(Priority.HIGH)
            .build()
            .getAsObject(SearchResponse::class.java, object : ParsedRequestListener<SearchResponse> {
                override fun onResponse(response: SearchResponse?) {
                    val filteredResponse = response?.events?.filter {
                        it?.strSport.equals("Soccer")
                    }
                    view.showSearchResult(filteredResponse)
                }

                override fun onError(anError: ANError?) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

            })
    }
}