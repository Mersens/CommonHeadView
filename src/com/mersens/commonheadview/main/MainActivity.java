package com.mersens.commonheadview.main;


import android.os.Bundle;
import com.mersens.commonheadview.view.HeadView.OnRightClickListener;
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
	}

}
