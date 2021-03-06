package com.yoenas.sub2kade.model

import com.google.gson.annotations.SerializedName

data class LeaguesResponse(

	@field:SerializedName("leagues")
	val leagues: List<LeaguesItem>? = null
)