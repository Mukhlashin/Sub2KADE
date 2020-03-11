package com.yoenas.sub2kade.mvp.match.prev

import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.ParsedRequestListener
import com.yoenas.sub2kade.model.MatchResponse
import com.yoenas.sub2kade.network.TheSportDBApi

class PrevPresenter(val view: PrevView) {

    fun showPrevEvent(idLeague: String?){
        AndroidNetworking.get(TheSportDBApi.getPrevMatch(idLeague))
            .setPriority(Priority.HIGH)
            .build()
            .getAsObject(MatchResponse::class.java, object : ParsedRequestListener<MatchResponse> {
                override fun onResponse(response: MatchResponse?) {
                    view.getPrevEvent(response?.events)
                }

                override fun onError(anError: ANError?) {

                }
            })
    }
}