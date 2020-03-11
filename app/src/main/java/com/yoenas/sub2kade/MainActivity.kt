package com.yoenas.sub2kade

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.yoenas.sub2kade.adapter.LeagueAdapter
import com.yoenas.sub2kade.model.LeagueItem
import com.yoenas.sub2kade.mvp.detail.league.LeagueActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var items: MutableList<LeagueItem> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initData()

        rv_league_main.layoutManager = GridLayoutManager(this, 2)
        rv_league_main.adapter = LeagueAdapter(this, items) {
            Toast.makeText(this, it.idLeague, Toast.LENGTH_SHORT).show()
            val intent = Intent(this, LeagueActivity::class.java)
            startActivity(intent)
        }
    }

    fun initData() {
        val name = resources.getStringArray(R.array.data_league_name)
        val idLeague = resources.getStringArray(R.array.data_id_league)
        val image = resources.obtainTypedArray(R.array.data_league_badge)
        items.clear()

        for (i in name.indices) {
            items.add(
                LeagueItem(
                    name[i],
                    image.getResourceId(i, 0),
                    idLeague[i]
                )
            )
        }
        image.recycle()
    }
}
