package com.mersens.commonheadview.main;


import com.mersens.commonheadview.view.HeadView.OnLeftClickListener;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

public abstract class BaseFragmentActivity extends BaseActivity{

	@Override
	protected void onCreate(Bundle arg0) { 
		super.onCreate(arg0);
		setContentView(R.layout.layout_container);
		initDatas();
	}

	private void initDatas() {
		FragmentManager fm=getSupportFragmentManager();
		Fragment fragment=fm.findFragmentById(R.id.fragmentContainer);
		if(fragment==null){
			fragment=creatFragment();
			fm.beginTransaction().add(R.id.fragmentContainer, fragment).commit();
		}
		setLeftWithTitleViewMethod(R.drawable.ic_menu_back,"Fragment",new OnLeftClickListener() {
			@Override
			public void onClick() {
				finishActivity();
			}
		});
	}
	
	/**
	 * @author Mersens
	 * 抽象方法，返回Fragment实例
	 * @return
	 */
	protected abstract Fragment creatFragment();
}
