package com.yoenas.sub2kade.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.orhanobut.hawk.Hawk
import com.squareup.picasso.Picasso
import com.yoenas.sub2kade.R
import com.yoenas.sub2kade.model.LeagueItem
import com.yoenas.sub2kade.mvp.detail.league.LeagueActivity
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.league_item.*

class LeagueAdapter(
    val context: Context,
    private val leagues: List<LeagueItem>,
    private val listener: (LeagueItem) -> Unit
) :
    RecyclerView.Adapter<LeagueAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        MyViewHolder(
            LayoutInflater
                .from(context)
                .inflate(
                    R.layout.league_item,
                    parent,
                    false
                )
        )

    override fun getItemCount(): Int = leagues.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bindItem(leagues[position], listener)
    }

    class MyViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView),
        LayoutContainer {
        fun bindItem(items: LeagueItem, listener: (LeagueItem) -> Unit) {
            tv_league_name.text = items.name
            items.image?.let { Picasso.get().load(it).fit().into(img_league_badge) }

            itemView.setOnClickListener {
                listener(items)
                // mengirimkan data idLeague ke Detail Activity
                Hawk.put(LeagueActivity.ID_LEAGUE, items.idLeague)
            }
        }
    }
}
