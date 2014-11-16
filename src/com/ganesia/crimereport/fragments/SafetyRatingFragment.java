package com.ganesia.crimereport.fragments;

import java.util.ArrayList;

import com.ganesia.crimereport.R;
import com.ganesia.crimereport.R.id;
import com.ganesia.crimereport.R.layout;
import com.ganesia.crimereport.adapters.CustomListViewAdapter;
import com.ganesia.crimereport.adapters.TotalAverageAdapter;
import com.ganesia.crimereport.models.SafetyRatingItem;
import com.ganesia.crimereport.models.Tuple;

import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;

public class SafetyRatingFragment extends Fragment{
	
	private GridView mGridView;
	private ListView mListView;
	private ArrayList<SafetyRatingItem> mSafetyRatingList = new ArrayList<SafetyRatingItem>();
	private ArrayList<Tuple> mTotalCrime = new ArrayList<Tuple>();
	private CustomListViewAdapter mSafetyRatingListAdapter;
	private TotalAverageAdapter mTotalAverageAdapter;
	private static final int STATUS_SAFE = 0;
	private static final int STATUS_DANGER = 1;
	private int mSafetyState;
	
	@Override
	   public View onCreateView(LayoutInflater inflater,	
	      ViewGroup container, Bundle savedInstanceState) {		
		
		// set the safety rating state:
		mSafetyState = STATUS_SAFE;
		//mSafetyState = STATUS_DANGER;
		
		mTotalCrime.add(new Tuple("TOTAL CRIMES", "98"));
		mTotalCrime.add(new Tuple("AVERAGE", "40"));
		
		mSafetyRatingList.add(new SafetyRatingItem("Offense Involving Children", "5", "8"));
		mSafetyRatingList.add(new SafetyRatingItem("Robbery", "3", "7"));
		mSafetyRatingList.add(new SafetyRatingItem("Sex Offense", "6", "3"));
		mSafetyRatingList.add(new SafetyRatingItem("Theft", "6", "3"));

		View safetyRatingView = inflater.inflate(R.layout.fragment_safety_rating, container, false);
		
		TextView safetyStatus = (TextView) safetyRatingView.findViewById(R.id.safety_status);
		if (mSafetyState == STATUS_SAFE){
			safetyStatus.setBackgroundColor(getResources().getColor(R.color.green));
			safetyStatus.setText("YOU ARE SAFE");
		}
		else{
			safetyStatus.setBackgroundColor(getResources().getColor(R.color.red));
			safetyStatus.setText("DANGER");
		}
		
		
		mGridView = (GridView) safetyRatingView.findViewById(R.id.gridview_rating);
		mTotalAverageAdapter = new TotalAverageAdapter(getActivity(), mTotalCrime);		
		mGridView.setAdapter(mTotalAverageAdapter);
		
		mListView = (ListView) safetyRatingView.findViewById(R.id.listview);
		mSafetyRatingListAdapter = new CustomListViewAdapter(getActivity(), mSafetyRatingList);
		mListView.setAdapter(mSafetyRatingListAdapter);
		
		
		return safetyRatingView;
		
	}

}
