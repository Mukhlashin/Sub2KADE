package com.yoenas.sub2kade.mvp.match.next

import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.ParsedRequestListener
import com.yoenas.sub2kade.model.EventsItem
import com.yoenas.sub2kade.model.MatchResponse
import com.yoenas.sub2kade.network.TheSportDBApi

class NextPresenter(val view: NextView) {

    fun showNextEvent(idLeague: String?){
        AndroidNetworking.get(TheSportDBApi.getNextMatch(idLeague))
            .setPriority(Priority.HIGH)
            .build()
            .getAsObject(MatchResponse::class.java, object : ParsedRequestListener<MatchResponse>{
                override fun onResponse(response: MatchResponse?) {
                    view.getNextEvent(response?.events)
                }

                override fun onError(anError: ANError?) {

                }
            })
    }
}