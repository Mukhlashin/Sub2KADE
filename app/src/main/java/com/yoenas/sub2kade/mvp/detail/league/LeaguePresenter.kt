package com.yoenas.sub2kade.mvp.detail.league

import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.ParsedRequestListener
import com.yoenas.sub2kade.model.LeaguesResponse
import com.yoenas.sub2kade.network.TheSportDBApi

class LeaguePresenter(val view: LeagueView) {

    fun getDetailLeague(idLeague: String?){
        AndroidNetworking.get(TheSportDBApi.getDetailLeague(idLeague))
            .setPriority(Priority.HIGH)
            .build()
            .getAsObject(LeaguesResponse::class.java, object : ParsedRequestListener<LeaguesResponse>{
                override fun onResponse(response: LeaguesResponse?) {
                    response?.leagues?.let { view.showDetailLeague(it) }
                }

                override fun onError(anError: ANError?) {

                }

            })
    }
}