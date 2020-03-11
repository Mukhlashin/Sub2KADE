package com.yoenas.sub2kade.mvp.detail.match

import com.yoenas.sub2kade.model.EventsItem
import com.yoenas.sub2kade.model.MatchResponse

interface MatchView {
    fun showMatchDetail(data: List<EventsItem?>?)
}