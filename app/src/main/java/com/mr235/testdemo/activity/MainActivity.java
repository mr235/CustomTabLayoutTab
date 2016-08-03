package com.mr235.testdemo.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TextView;

import com.mr235.testdemo.R;
import com.mr235.testdemo.adapter.TabPageIndicatorAdapter;

import java.util.Arrays;

public class MainActivity extends FragmentActivity {

	private TabLayout mTabLayout;
	private ViewPager mViewPager;
	private String tagStr = "背影,小清新,霸气,长发,唯美,女神,短发,性感,网络红人,文字,侧脸,可爱,半身,非主流,伤感";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initView();
		initData();
	}

	private void initView() {
		mTabLayout = (TabLayout) findViewById(R.id.tl);
		mViewPager = (ViewPager) findViewById(R.id.vp);
	}

	private void initData() {
		mViewPager.setOffscreenPageLimit(3);
		TabPageIndicatorAdapter mAdapter = new TabPageIndicatorAdapter(getSupportFragmentManager());
		mAdapter.getTags().addAll(Arrays.asList(tagStr.split(",")));
		mViewPager.setAdapter(mAdapter);
		mTabLayout.setupWithViewPager(mViewPager);

		initCustomTab(mTabLayout);
		setTabSelected(0);
		mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
			@Override
			public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

			}

			@Override
			public void onPageSelected(int position) {
				setTabSelected(position);
			}

			@Override
			public void onPageScrollStateChanged(int state) {

			}
		});
	}

	private void initCustomTab(TabLayout tabLayout) {
		for (int i=0; i<tabLayout.getTabCount(); i++) {
			TabLayout.Tab tab = tabLayout.getTabAt(i);
			tab.setCustomView(R.layout.custom_tab);
			View customView = tab.getCustomView();
			TextView mTvText = (TextView) customView.findViewById(R.id.tv_text);
			mTvText.setText(tagStr.split(",")[i]);
			mTvText.setTextColor(ContextCompat.getColor(this, R.color.colorPrimary));
			customView.findViewById(R.id.v_indicator).setVisibility(View.INVISIBLE);
		}
	}
	private void setTabSelected(int position) {
		for (int i=0; i<mTabLayout.getTabCount(); i++) {
			TabLayout.Tab tab = mTabLayout.getTabAt(i);
			View customView = tab.getCustomView();
			TextView mTvText = (TextView) customView.findViewById(R.id.tv_text);
			int colorId = R.color.colorPrimary;
			View mVIndicator = customView.findViewById(R.id.v_indicator);
			if (i==position) {
				colorId = R.color.colorAccent;
				mVIndicator.setVisibility(View.VISIBLE);
			} else {
				mVIndicator.setVisibility(View.INVISIBLE);
			}
			mTvText.setTextColor(ContextCompat.getColor(this, colorId));
		}
	}
}
