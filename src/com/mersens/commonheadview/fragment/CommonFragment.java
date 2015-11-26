package com.mersens.commonheadview.fragment;

import java.util.ArrayList;
import java.util.List;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.TextView;

import com.mersens.commonheadview.adaspter.GridAdapter;
import com.mersens.commonheadview.bean.Type;
import com.mersens.commonheadview.main.R;

public class CommonFragment extends LazyFragment {
	private TextView toptype;
	private GridView gridView;
	private List<Type> list;
	private String name;
	private GridAdapter adapter;
	private boolean isPrepared;
	View v;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		v=inflater.inflate(R.layout.layout_fragment, container,false);
		isPrepared=true;
		lazyLoad();
		return v;
	}
	
	public static Fragment getInstance(String params){
		CommonFragment fragment=new CommonFragment();
		Bundle bundle=new Bundle();
		bundle.putString("name",params);
		fragment.setArguments(bundle);
		return fragment;
	}
	
	
	private List<Type> getDatas(String name){
		List<Type> types=new ArrayList<Type>();
		for(int i=0;i<21;i++){
			types.add(new Type(i+"", name+(i+1)));
		}
		return types;
	}

	@Override
	protected void lazyLoad() {
		if(!isPrepared || !isVisible) {
            return;
        }
		
		toptype=(TextView) v.findViewById(R.id.toptype);
		gridView=(GridView) v.findViewById(R.id.gridView);
		name=getArguments().getString("name");
		toptype.setText(name);
		list=getDatas(name);
		adapter=new GridAdapter(getActivity().getApplicationContext(), list);
		gridView.setAdapter(adapter);
	}
}
