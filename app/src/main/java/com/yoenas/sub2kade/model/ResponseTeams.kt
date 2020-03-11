package com.yoenas.sub2kade.model

import com.google.gson.annotations.SerializedName

data class ResponseTeams(

	@field:SerializedName("teams")
	val teams: List<TeamsItem?>? = null
)