package com.mersens.commonheadview.main;

import java.util.ArrayList;
import java.util.List;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.mersens.commonheadview.fragment.CommonFragment;
import com.mersens.commonheadview.utils.DatasUtils;
import com.mersens.commonheadview.view.HeadView.OnLeftClickListener;

public class ShopFragmentActivity extends BaseActivity{
	private LayoutInflater mInflater;
	private ScrollView left_scrlllview;
	private int scrllViewWidth = 0, scrollViewMiddle = 0;
	private ViewPager goods_pager;
	private int currentItem=0;
	private LinearLayout layout_titles;
	private List<String> titlesName;
	private List<TextView> textViews;
	private List<View> views;
	private ShopAdapter shopAdapter;
	
	@Override
	protected void onCreate(Bundle arg0) {
		// TODO Auto-generated method stub
		super.onCreate(arg0);
		setContentView(R.layout.activity_shop_main);
		mInflater=LayoutInflater.from(this);
		left_scrlllview=(ScrollView) findViewById(R.id.left_scrlllview);
		goods_pager=(ViewPager) findViewById(R.id.goods_pager);
		layout_titles=(LinearLayout) findViewById(R.id.layout_titles);
		shopAdapter=new ShopAdapter(getSupportFragmentManager());
		setLeftWithTitleViewMethod(R.drawable.ic_menu_back,"产品分类",new OnLeftClickListener() {
			@Override
			public void onClick() {
				finishActivity();
			}
		});
		initViews();
		initPager();
		
		
	}

	@SuppressLint("InflateParams")
	private void initViews() {
		titlesName=DatasUtils.getInstance().getDatas();
		textViews=new ArrayList<TextView>();
		views=new ArrayList<View>();
		for(int i=0;i<titlesName.size();i++){
			View view=mInflater.inflate(R.layout.layout_title_item, null);
			view.setId(i);
			view.setOnClickListener(toolsItemListener);
			TextView textView=(TextView) view.findViewById(R.id.title);
			textView.setText(titlesName.get(i));
			layout_titles.addView(view);
			textViews.add(textView);
			views.add(view);
		}
		changeTextColor(0);
		
	}
	private View.OnClickListener toolsItemListener =new View.OnClickListener() {
		@Override
		public void onClick(View v) {
			goods_pager.setCurrentItem(v.getId());
		}
	};
	
	@SuppressWarnings("deprecation")
	private void initPager() {
		goods_pager.setAdapter(shopAdapter);		
		goods_pager.setOnPageChangeListener(onPageChangeListener);
	}
	private OnPageChangeListener onPageChangeListener = new OnPageChangeListener() {
		@Override
		public void onPageSelected(int arg0) {
			if(goods_pager.getCurrentItem()!=arg0)goods_pager.setCurrentItem(arg0);
			if(currentItem!=arg0){
				changeTextColor(arg0);
				changeTextLocation(arg0);
			}
			currentItem=arg0;
		}
		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {
		}
		@Override
		public void onPageScrollStateChanged(int arg0) {
		}
	};

	private class ShopAdapter extends FragmentPagerAdapter {
		public ShopAdapter(FragmentManager fm) {
			super(fm);
		}
		@Override
		public Fragment getItem(int arg0) {
			return CommonFragment.getInstance(titlesName.get(arg0));
		}
		
		@Override
		public int getCount() {
			return titlesName.size();
		}
	}

	private void changeTextColor(int id) {
		for (int i = 0; i < textViews.size(); i++) {
			if(i!=id){
				textViews.get(i).setBackgroundResource(android.R.color.transparent);
				textViews.get(i).setTextColor(0xff000000);
			}
		}
		textViews.get(id).setBackgroundResource(android.R.color.white);
		textViews.get(id).setTextColor(0xffff5d5e);
	}
	

	private void changeTextLocation(int clickPosition) {
		
		int x = (views.get(clickPosition).getTop() - getScrollViewMiddle() + (getViewheight(views.get(clickPosition)) / 2));
		left_scrlllview.smoothScrollTo(0, x);
	}

	private int getScrollViewMiddle() {
		if (scrollViewMiddle == 0)
			scrollViewMiddle = getScrollViewheight() / 2;
		return scrollViewMiddle;
	}

	private int getScrollViewheight() {
		if (scrllViewWidth == 0)
			scrllViewWidth = left_scrlllview.getBottom() - left_scrlllview.getTop();
		return scrllViewWidth;
	}

	private int getViewheight(View view) {
		return view.getBottom() - view.getTop();
	}
}
