package com.mersens.commonheadview.main;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.DisplayMetrics;
import android.widget.Toast;

import com.mersens.commonheadview.view.HeadView;
import com.mersens.commonheadview.view.HeadView.HeaderStyle;
import com.mersens.commonheadview.view.HeadView.OnLeftClickListener;
import com.mersens.commonheadview.view.HeadView.OnRightClickListener;

public class BaseActivity extends FragmentActivity{

	private int mScreenWidth;

	private int mScreenHeight;
	private  Toast mToast;
	private Activity activity;

	private HeadView mHeadView;
	@Override
	protected void onCreate(Bundle arg0) {
		// TODO Auto-generated method stub
		super.onCreate(arg0);
		//��ֹ�ֻ������ʾ
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		activity=this;
		DisplayMetrics metrics=new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(metrics);
		mScreenHeight=metrics.heightPixels;
		mScreenHeight=metrics.widthPixels;
	}

	/**
	 * @author Mersens
	 * setDefaultViewMethod--Ĭ�Ϸ�����ʾ���ͼ�꣬�Ҳ�ͼ��ͱ���
	 * @param leftsrcid
	 * @param title
	 * @param rightsrcid
	 * @param onleftclicklistener
	 * @param onrightclicklistener
	 */
	public void setDefaultViewMethod(int leftsrcid,String title,int rightsrcid, OnLeftClickListener onleftclicklistener,OnRightClickListener onrightclicklistener) {
		mHeadView=(HeadView) findViewById(R.id.common_actionbar);
		mHeadView.init(HeaderStyle.DEFAULT);
		mHeadView.setDefaultViewMethod(leftsrcid,title,rightsrcid,onleftclicklistener,onrightclicklistener);
	}
	
	
	/**
	 * @author Mersens
	 * setRightAndTitleMethod--��ʾ�Ҳఴť�ͱ���
	 * @param title
	 * @param rightsrcid
	 * @param onRightClickListener
	 */
	public void setRightAndTitleMethod(String title,int rightsrcid, OnRightClickListener onRightClickListener){
		mHeadView=(HeadView) findViewById(R.id.common_actionbar);
		mHeadView.init(HeaderStyle.RIGHTANDTITLE);
		mHeadView.setRightAndTitleMethod(title, rightsrcid, onRightClickListener);
	}
	
	
	/**
	 * @author Mersens
	 * setLeftWithTitleViewMethod--��ʾ��ఴť�ͱ���
	 * @param leftsrcid
	 * @param title
	 * @param onleftclicklistener
	 */
	public void setLeftWithTitleViewMethod(int leftsrcid,String title, OnLeftClickListener onleftclicklistener){
		mHeadView=(HeadView) findViewById(R.id.common_actionbar);
		mHeadView.init(HeaderStyle.LEFTANDTITLE);
		mHeadView.setLeftWithTitleViewMethod( leftsrcid, title,  onleftclicklistener);
	}
	
	/**
	 * @author Mersens
	 * setOnlyTileViewMethod--ֻ��ʾtitle
	 * @param title
	 */
	public void setOnlyTileViewMethod(String title) {
		mHeadView=(HeadView) findViewById(R.id.common_actionbar);
		mHeadView.init(HeaderStyle.ONLYTITLE);
		mHeadView.setOnlyTileViewMethod(title);
	}

	/**
	 * @author Mersens
	 * setLeftViewMethod--ֻ��ʾ��ఴť
	 * @param leftsrcid
	 * @param onleftclicklistener
	 */
	public void setLeftViewMethod(int leftsrcid,OnLeftClickListener onleftclicklistener) {
		mHeadView=(HeadView) findViewById(R.id.common_actionbar);
		mHeadView.init(HeaderStyle.LEFT);
		mHeadView.setLeftViewMethod( leftsrcid, onleftclicklistener);
	}
	
	
	/**
	 * @author Mersens
	 * ��ʾ��ʾ��Ϣ���������ַ���Դ
	 * @param text
	 */
	public void ShowToast(String text) {
		if (mToast == null) {
			mToast = Toast.makeText(this, text, Toast.LENGTH_SHORT);
		} else {
			mToast.setText(text);
		}
		mToast.show();
	}
	
	/**
	 * @author Mersens
	 * ��ʾ��ʾ��Ϣ����������Դ�ļ�
	 * @param srcid
	 */
	public void ShowToast(int srcid) {
		if (mToast == null) {
			mToast = Toast.makeText(this, srcid, Toast.LENGTH_SHORT);
		} else {
			mToast.setText(srcid);
		}
		mToast.show();
	}
	
	
	/**
	 * @author Mersens
	 * ͨ��NetworkInfoʵ���ж�����״̬���Ƿ��п�������
	 * @return 
	 */
	public boolean isNetworkAvailable() {
		NetworkInfo info = getNetworkInfo(activity);
		if (info != null) {
			return info.isAvailable();
		}
		return false;
	}
	
	private static NetworkInfo getNetworkInfo(Context context) {
		ConnectivityManager cm = (ConnectivityManager) context
				.getSystemService(Context.CONNECTIVITY_SERVICE);
		return cm.getActiveNetworkInfo();
	}
	
	
	/**
	 * @author Mersens
	 * ��ȡ��Ļ�Ŀ��
	 * @return mScreenWidth
	 */
	public int getScreenWidth(){
		return mScreenWidth;
	}
	
	/**
	 * @author Mersens
	 * ��ȡ��Ļ�ĸ߶�
	 * @return mScreenHeight
	 */
	public int getScreenHeight(){
		return mScreenHeight;
	}
	
	/**
	 * @author Mersens
	 * intentAction--������ת
	 * @param context
	 * @param cls
	 */
	public <T> void intentAction(Activity context, Class<T> cls) {
		Intent intent = new Intent(context, cls);
		startActivity(intent);
		context.overridePendingTransition(R.anim.left_in,
				R.anim.left_out);
	}
	
	/**
	 * @author Mersens
	 * finishActivity()--����Activity
	 */
	public void finishActivity(){
		finish();
		overridePendingTransition(R.anim.right_in,
				R.anim.right_out);
	}
}
