package com.yoenas.sub2kade.mvp.match.next


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.orhanobut.hawk.Hawk

import com.yoenas.sub2kade.R
import com.yoenas.sub2kade.adapter.NextAdapter
import com.yoenas.sub2kade.model.EventsItem
import com.yoenas.sub2kade.mvp.detail.league.LeagueActivity
import com.yoenas.sub2kade.mvp.detail.match.MatchActivity
import kotlinx.android.synthetic.main.fragment_next_match.*

/**
 * A simple [Fragment] subclass.
 */
class NextMatchFragment : Fragment(), NextView {

    private val presenter: NextPresenter = NextPresenter(this)
    private lateinit var nextAdapter: NextAdapter

    companion object {
        const val EXTRA_DATA = "extra_data"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_next_match, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val idLeague = Hawk.get(LeagueActivity.ID_LEAGUE, "")
        presenter.showNextEvent(idLeague)
        rv_next_match.layoutManager = LinearLayoutManager(context)
    }

    override fun getNextEvent(data: List<EventsItem?>?) {
        nextAdapter = NextAdapter(data){
            val intent = Intent(context, MatchActivity::class.java)
            intent.putExtra(EXTRA_DATA, data?.get(0)?.idEvent.toString())
            startActivity(intent)
        }
        rv_next_match.adapter = nextAdapter
    }
}
