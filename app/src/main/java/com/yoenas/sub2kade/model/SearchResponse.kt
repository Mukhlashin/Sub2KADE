package com.yoenas.sub2kade.model

import com.google.gson.annotations.SerializedName

data class SearchResponse (

    @field:SerializedName("event")
    val events: List<EventsItem?>? = null

)