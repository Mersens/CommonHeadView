package com.mersens.commonheadview.main;


import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import com.mersens.commonheadview.view.HeadView.OnLeftClickListener;
import com.mersens.commonheadview.view.HeadView.OnRightClickListener;

public class MainActivity extends BaseActivity {
	private Button btn;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btn=(Button) findViewById(R.id.button1);
		setDefaultViewMethod(R.drawable.ic_menu_back, "MainActivity", R.drawable.btn_more, new OnLeftClickListener() {
			
			@Override
			public void onClick() {
				Toast.makeText(MainActivity.this, "点击了左侧按钮",Toast.LENGTH_LONG).show();
			}
		}, new OnRightClickListener() {
			
			@Override
			public void onClick() {
				Toast.makeText(MainActivity.this, "点击了右侧侧按钮",Toast.LENGTH_LONG).show();
			}
		});
		btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				intentAction(MainActivity.this,TestFragmentActivity.class);
			}
		});
	}

}
