package com.yoenas.sub2kade.mvp.detail.match

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.yoenas.sub2kade.R
import com.yoenas.sub2kade.adapter.NextAdapter
import com.yoenas.sub2kade.model.EventsItem
import com.yoenas.sub2kade.mvp.match.next.NextMatchFragment
import kotlinx.android.synthetic.main.activity_detail_match.*

class MatchActivity : AppCompatActivity(), MatchView {

    private var presenter: MatchPresenter = MatchPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_match)

        val idEvent = intent.getStringExtra(NextMatchFragment.EXTRA_DATA)
        Toast.makeText(this, idEvent, Toast.LENGTH_SHORT).show()
        presenter.getEventDetail(idEvent)
    }

    override fun showMatchDetail(data: List<EventsItem?>?) {
        tv_match_date_event.text = data?.get(0)?.dateEvent
        tv_match_str_time.text = data?.get(0)?.strTime
        tv_match_score_home.text = data?.get(0)?.intHomeScore
        tv_match_score_away.text = data?.get(0)?.intAwayScore
    }
}
