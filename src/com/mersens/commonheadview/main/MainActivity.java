package com.mersens.commonheadview.main;


import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

import com.mersens.commonheadview.view.HeadView.OnRightClickListener;
import com.mersens.commonheadview.view.SpotsDialog;
public class MainActivity extends BaseActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		setRightAndTitleMethod("MainActivity", R.drawable.btn_more, new OnRightClickListener() {
			@Override
			public void onClick() {
				intentAction(MainActivity.this,ShopFragmentActivity.class);
			}
		});
		
		findViewById(R.id.progress_show_login).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				new SpotsDialog(MainActivity.this, R.style.SpotsLogin).show();
				
			}
		});
		
		findViewById(R.id.progress_show_loading).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				new SpotsDialog(MainActivity.this, R.style.SpotsDialogDefault).show();
			}
		});
		
		findViewById(R.id.dialog_show).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
		});
		
		findViewById(R.id.dialog_dimess).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
	
			}
		});
	}

}
