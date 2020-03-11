package com.yoenas.sub2kade.network

import com.yoenas.sub2kade.BuildConfig

object TheSportDBApi {
    fun getDetailLeague(idLeague: String?): String{
        return BuildConfig.BASE_URL + "lookupleague.php?id=" + idLeague
    }

    fun getNextMatch(idLeague: String?): String{
        return BuildConfig.BASE_URL + "eventsnextleague.php?id=" + idLeague
    }

    fun getPrevMatch(idLeague: String?): String{
        return BuildConfig.BASE_URL + "eventspastleague.php?id=" + idLeague
    }
    fun getSearchResult(eventName: String?): String{
        return BuildConfig.BASE_URL + "searchevents.php?e=" + eventName
    }
    fun getDetailMatch(idEvent: String?): String{
        return BuildConfig.BASE_URL + "lookupevent.php?id=" + idEvent
    }
    fun getDetailTeam(idTeam: String?): String{
        return BuildConfig.BASE_URL + "lookupteam.php?id=" + idTeam
    }
}
