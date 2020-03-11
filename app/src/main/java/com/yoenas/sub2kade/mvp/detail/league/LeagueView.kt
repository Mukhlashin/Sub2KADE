package com.yoenas.sub2kade.mvp.detail.league

import com.yoenas.sub2kade.model.LeaguesItem

interface LeagueView {
    fun showDetailLeague(data: List<LeaguesItem>)
}