package com.mersens.commonheadview.main;


import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;

import com.mersens.commonheadview.view.DialogTips;
import com.mersens.commonheadview.view.HeadView.OnRightClickListener;
import com.mersens.commonheadview.view.SVProgressHUD;
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
		
		findViewById(R.id.dialog_exit_show).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				DialogTips dialog = new DialogTips(MainActivity.this, "退出", "是否退出软件？",
						"确定", true, true);
				dialog.show();
				dialog=null;
			}
		});
		
		findViewById(R.id.dialog_hint).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			DialogTips dialog = new DialogTips(MainActivity.this, "Hello Android!", "确定");
			dialog.show();
			dialog=null;
			}
		});
		
		findViewById(R.id.btn_loading).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				SVProgressHUD.showWithStatus(MainActivity.this, "加载中...");
				
			}
		});
		
		findViewById(R.id.btn_hint).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				SVProgressHUD.showInfoWithStatus(MainActivity.this, "提示");
			}
		});
		
		findViewById(R.id.btn_success).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				SVProgressHUD.showSuccessWithStatus(MainActivity.this, "提交成功！");
			}
		});
		
		findViewById(R.id.btn_error).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				 SVProgressHUD.showErrorWithStatus(MainActivity.this, "提交失败！");
			}
		});
		
	}
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0)
        {
            if(SVProgressHUD.isShowing(this)){
                SVProgressHUD.dismiss(this);
                return false;
            }
        }

        return super.onKeyDown(keyCode, event);

    }
}
