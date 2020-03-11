package com.yoenas.sub2kade.mvp.search

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.yoenas.sub2kade.R
import com.yoenas.sub2kade.adapter.NextAdapter
import com.yoenas.sub2kade.model.EventsItem
import com.yoenas.sub2kade.mvp.detail.league.LeagueActivity
import com.yoenas.sub2kade.mvp.detail.match.MatchActivity
import com.yoenas.sub2kade.mvp.match.next.NextMatchFragment
import kotlinx.android.synthetic.main.activity_search.*

class SearchActivity : AppCompatActivity(), SearchView {

    private val presenter: SearchPresenter = SearchPresenter(this)
    private lateinit var searchAdapter: NextAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        val query = intent.getStringExtra(LeagueActivity.EXTRA_QUERY)
        Toast.makeText(this, query, Toast.LENGTH_LONG).show()
        presenter.getSearchResult(query)
        rv_search.layoutManager = LinearLayoutManager(applicationContext)

    }

    override fun showSearchResult(data: List<EventsItem?>?) {
        searchAdapter = NextAdapter(data, {
            val intent = Intent(applicationContext, MatchActivity::class.java)
            intent.putExtra(NextMatchFragment.EXTRA_DATA, data?.get(0)?.idEvent.toString())
            startActivity(intent)
        })
        rv_search.adapter = searchAdapter
    }

}
