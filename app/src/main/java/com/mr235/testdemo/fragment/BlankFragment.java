package com.mr235.testdemo.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mr235.testdemo.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link BlankFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BlankFragment extends Fragment {
	// TODO: Rename parameter arguments, choose names that match
	// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
	public static final String ARG_TAG = "tag";
	private static final String ARG_PARAM2 = "param2";

	// TODO: Rename and change types of parameters
	private String mTag = "";
	private String mParam2;

	/**
	 * Use this factory method to create a new instance of
	 * this fragment using the provided parameters.
	 *
	 * @param param1 Parameter 1.
	 * @param param2 Parameter 2.
	 * @return A new instance of fragment BlankFragment.
	 */
	// TODO: Rename and change types and number of parameters
	public static BlankFragment newInstance(String param1, String param2) {
		BlankFragment fragment = new BlankFragment();
		Bundle args = new Bundle();
		args.putString(ARG_TAG, param1);
		args.putString(ARG_PARAM2, param2);
		fragment.setArguments(args);
		return fragment;
	}	public BlankFragment() {
		// Required empty public constructor
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if (getArguments() != null) {
			mTag = getArguments().getString(ARG_TAG);
			mParam2 = getArguments().getString(ARG_PARAM2);
		}
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		System.out.println("-----onCreateView-------");
		return inflater.inflate(R.layout.fragment_blank, container, false);
	}

	@Override
	public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		System.out.println("-----onViewCreated-------");
		TextView mTvTag = (TextView) view.findViewById(R.id.tag);
		mTvTag.setText(mTag);
	}

	@Override
	public void onAttach(Context context) {
		super.onAttach(context);
		System.out.println("-----onAttach-------");
	}

	@Override
	public void onDetach() {
		super.onDetach();
	}
}
