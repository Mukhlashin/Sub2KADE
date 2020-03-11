package com.yoenas.sub2kade.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yoenas.sub2kade.R
import com.yoenas.sub2kade.model.EventsItem
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.match_item.*

class NextAdapter(val items: List<EventsItem?>?, private var listener: (EventsItem) -> Unit) :
    RecyclerView.Adapter<NextAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.match_item, parent, false))

    override fun getItemCount(): Int = items!!.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bindItem(items?.get(position), listener)
    }

    class MyViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView),
        LayoutContainer {

        fun bindItem(items: EventsItem?, listener: (EventsItem) -> Unit) {
            tv_str_event.text = items?.strEvent
            tv_str_league.text = items?.strLeague
            tv_str_home_score.text = items?.intHomeScore
            tv_str_away_score.text = items?.intAwayScore
            tv_str_date.text = items?.strDate
            itemView.setOnClickListener {
                listener(items!!)
            }
        }
    }
}