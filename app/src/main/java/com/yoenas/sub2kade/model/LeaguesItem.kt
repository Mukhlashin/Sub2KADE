package com.yoenas.sub2kade.model

import com.google.gson.annotations.SerializedName

data class LeaguesItem(

	@field:SerializedName("strDescriptionEN")
	val strDescriptionEN: String? = null,

	@field:SerializedName("strBadge")
	val strBadge: String? = null,

	@field:SerializedName("strSport")
	val strSport: String? = null,

	@field:SerializedName("strWebsite")
	val strWebsite: String? = null,

	@field:SerializedName("idLeague")
	val idLeague: String? = null,

	@field:SerializedName("strCountry")
	val strCountry: String? = null,

	@field:SerializedName("strLeague")
	val strLeague: String? = null

)
