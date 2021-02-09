package com.nenartovich.example021_viewpagersimpleproject

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class SampleAdapter(mgr: FragmentManager) : FragmentPagerAdapter(mgr) {
    override fun getCount(): Int = 10
    override fun getItem(position: Int): Fragment = EditorFragment.newInstance(position)
}