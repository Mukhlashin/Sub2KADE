package com.yoenas.sub2kade.mvp.search

import com.yoenas.sub2kade.model.EventsItem

interface SearchView {
    fun showSearchResult(data: List<EventsItem?>?)
}