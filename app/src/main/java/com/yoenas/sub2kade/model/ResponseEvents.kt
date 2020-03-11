package com.yoenas.sub2kade.model

import com.google.gson.annotations.SerializedName

data class ResponseEvents(

	@field:SerializedName("events")
	val events: List<EventsItem?>? = null
)