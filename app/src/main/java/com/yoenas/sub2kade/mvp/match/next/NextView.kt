package com.yoenas.sub2kade.mvp.match.next

import com.yoenas.sub2kade.model.EventsItem

interface NextView {
    fun getNextEvent(data: List<EventsItem?>?)
}