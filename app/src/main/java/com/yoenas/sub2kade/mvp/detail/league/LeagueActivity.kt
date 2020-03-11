package com.yoenas.sub2kade.mvp.detail.league

import android.app.SearchManager
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.content.ContextCompat
import com.orhanobut.hawk.Hawk
import com.squareup.picasso.Picasso
import com.yoenas.sub2kade.R
import com.yoenas.sub2kade.adapter.SectionsPagerAdapter
import com.yoenas.sub2kade.model.LeaguesItem
import com.yoenas.sub2kade.mvp.search.SearchActivity
import kotlinx.android.synthetic.main.activity_detail_league.*

class LeagueActivity : AppCompatActivity(),
    LeagueView {

    companion object {
        const val ID_LEAGUE = "id_league"
        const val EXTRA_QUERY = "extra_query"
    }

    private var presenter: LeaguePresenter =
        LeaguePresenter(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_league)

        setSupportActionBar(detail_toolbar)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val idLeague = Hawk.get(ID_LEAGUE, "")
        presenter.getDetailLeague(idLeague)

        val sectionPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
        vp_match.adapter = sectionPagerAdapter
        tab_detail.setupWithViewPager(vp_match)

    }

    override fun showDetailLeague(data: List<LeaguesItem>) {
        Picasso.get().load(data[0].strBadge).fit().into(img_detail_league_badge)
        tv_str_country.text = data[0].strCountry
        tv_str_sport.text = data[0].strSport
        tv_str_detail_league_name.text = data[0].strLeague
        tv_str_web.text = data[0].strWebsite
        tv_detail_league_desc.text = data[0].strDescriptionEN
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.search_menu, menu)

        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        val searchView = menu?.findItem(R.id.action_search)?.actionView as? SearchView

        val edtSearchAction = searchView?.findViewById<EditText>(androidx.appcompat.R.id.search_src_text)
        edtSearchAction?.setTextColor(ContextCompat.getColor(this, android.R.color.white))
        edtSearchAction?.setHintTextColor(ContextCompat.getColor(this, android.R.color.darker_gray))
        searchView?.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                val intent = Intent(this@LeagueActivity, SearchActivity::class.java)
                intent.putExtra(EXTRA_QUERY, searchView.query.toString())
                startActivity(intent)
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }

        })
        searchView?.setSearchableInfo(searchManager.getSearchableInfo(componentName))
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
         return when (item.itemId) {
            R.id.action_search -> {
                true
            } else -> {
                super.onOptionsItemSelected(item)
            }
        }
    }
}
