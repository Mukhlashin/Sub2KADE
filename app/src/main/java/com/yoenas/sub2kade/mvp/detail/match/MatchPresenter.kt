package com.yoenas.sub2kade.mvp.detail.match

import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.ParsedRequestListener
import com.yoenas.sub2kade.model.MatchResponse
import com.yoenas.sub2kade.network.TheSportDBApi

class MatchPresenter(val view: MatchView) {
    fun getEventDetail(idEvents: String?) {
        AndroidNetworking.get(TheSportDBApi.getDetailMatch(idEvents))
            .setPriority(Priority.HIGH)
            .build()
            .getAsObject(MatchResponse::class.java, object : ParsedRequestListener<MatchResponse> {
                override fun onResponse(response: MatchResponse?) {
                    view.showMatchDetail(response?.events)
                }

                override fun onError(anError: ANError?) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

            })
    }
}