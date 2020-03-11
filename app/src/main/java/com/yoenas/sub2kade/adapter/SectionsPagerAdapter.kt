package com.yoenas.sub2kade.adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.yoenas.sub2kade.R
import com.yoenas.sub2kade.mvp.match.next.NextMatchFragment
import com.yoenas.sub2kade.mvp.match.prev.PrevMatchFragment

class SectionsPagerAdapter(private val context: Context, fm: FragmentManager) :
    FragmentPagerAdapter(fm) {

    private val PAGE_TITLES = arrayOf(
        R.string.prev_match,
        R.string.next_match
    )

    val page = listOf(
        PrevMatchFragment(),
        NextMatchFragment()
    )

    override fun getItem(position: Int): Fragment {
        return page[position]
    }

    override fun getCount(): Int {
        return 2
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return context.resources.getString(PAGE_TITLES[position])
    }
}