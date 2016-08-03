package com.mr235.testdemo.adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.mr235.testdemo.fragment.BlankFragment;

import java.util.ArrayList;
import java.util.List;

public class TabPageIndicatorAdapter extends FragmentStatePagerAdapter {
	private List<String> tags = new ArrayList<>();
	private String mSucaiType;

	public TabPageIndicatorAdapter(FragmentManager fm) {
		super(fm);
	}

	public List<String> getTags() {
		return tags;
	}

	@Override
	public Fragment getItem(int position) {
		BlankFragment fragment = new BlankFragment();
		Bundle args = new Bundle();
		args.putString(BlankFragment.ARG_TAG, tags.get(position));
		fragment.setArguments(args);
		return fragment;
	}

	@Override
	public CharSequence getPageTitle(int position) {
		return tags.get(position % tags.size());
	}

	@Override
	public int getCount() {
		return tags.size();
	}

	@Override
	public int getItemPosition(Object object) {
		return POSITION_NONE;
	}

	public void setSucaiType(String sucaiType) {
		mSucaiType = sucaiType;
	}
}