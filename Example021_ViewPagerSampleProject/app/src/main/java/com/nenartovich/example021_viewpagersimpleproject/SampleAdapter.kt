package com.nenartovich.example021_viewpagersimpleproject

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class SampleAdapter(val ctxt: Context, mgr: FragmentManager) : FragmentPagerAdapter(mgr) {
    override fun getCount(): Int = 10
    override fun getItem(position: Int): Fragment = EditorFragment.newInstance(position)
    override fun getPageTitle(position: Int) = EditorFragment.getTitle(ctxt, position)
}