package com.yoenas.sub2kade.mvp.match.prev

import com.yoenas.sub2kade.model.EventsItem

interface PrevView {
    fun getPrevEvent(data: List<EventsItem?>?)
}