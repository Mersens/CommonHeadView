package com.mersens.commonheadview.view;

import com.mersens.commonheadview.main.R;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

@SuppressLint("InflateParams")
public class HeadView extends LinearLayout {
	private LinearLayout header_leftview_container;
	private LinearLayout header_layout_rightview_container;
	private ImageView left_button;
	private ImageView right_button;
	private LayoutInflater mInflater;
	private TextView tv_title;
	private View header;
	private OnLeftClickListener onleftclicklistener;
	private OnRightClickListener onrightclicklistener;

	/**
	 * 
	 * @author Mersens ö�����͵ı�������ʾ���� DEFAULT--Ĭ����ʾ���ͼ�꣬�Ҳ�ͼ��ͱ��� ONLYTITLE--ֻ��ʾ����
	 *         LEFT--ֻ��ʾ���ͼ�� LEFTANDTITLE--ֻ��ʾ���ͼ��ͱ���
	 */
	public enum HeaderStyle {
		DEFAULT, ONLYTITLE, LEFT, LEFTANDTITLE, RIGHTANDTITLE;
	}

	public HeadView(Context context) {
		super(context);
		init(context);

	}

	public HeadView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init(context);

	}

	@SuppressLint("InflateParams")
	private void init(Context context) {
		mInflater = LayoutInflater.from(context);
		header = mInflater.inflate(R.layout.common_head, null);
		addView(header);
		initViews();
	}

	/**
	 * @author Mersens ��ʼ���ؼ�
	 */
	private void initViews() {
		header_leftview_container = (LinearLayout) header
				.findViewById(R.id.header_leftview_container);
		header_layout_rightview_container = (LinearLayout) header
				.findViewById(R.id.header_layout_rightview_container);
		tv_title = (TextView) header.findViewById(R.id.tv_title);
	}

	/**
	 * @author Mersens �������ͽ��г�ʼ��,����ͨ��addView()������̬��ӿؼ�,Ȼ��������ؼ�����ʾ
	 * @param style
	 */
	public void init(HeaderStyle style) {
		switch (style) {
		case DEFAULT:
			removeViews();
			defaultMethod();
			break;
		case ONLYTITLE:
			removeViews();
			tileMethod();
			break;
		case LEFT:
			removeViews();
			leftMethod();
			break;
		case LEFTANDTITLE:
			removeViews();
			backAndTitleMethod();
			break;
		case RIGHTANDTITLE:
			removeViews();
			rightandtitle();
			break;
		}
	}

	private void rightandtitle() {
		// ����titleΪ�ɼ�
		tv_title.setVisibility(View.VISIBLE);
		View right_button_view = mInflater.inflate(
				R.layout.common_head_right_img, null);
		right_button = (ImageView) right_button_view
				.findViewById(R.id.right_imageView);
		// ��ʼ���Ҳఴť������ӵ��Ҳุ������
		header_layout_rightview_container.addView(right_button_view);
		right_button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// �ӿڻص�
				if (onrightclicklistener != null) {
					onrightclicklistener.onClick();
				}
			}
		});
	}

	/**
	 * �Ƴ����ҿؼ�����View
	 */
	private void removeViews() {
		header_leftview_container.removeAllViews();
		header_layout_rightview_container.removeAllViews();
	}

	@SuppressLint("InflateParams")
	public void defaultMethod() {
		// ����titleΪ�ɼ�
		tv_title.setVisibility(View.VISIBLE);
		View left_button_view = mInflater.inflate(
				R.layout.common_head_left_img, null);
		left_button = (ImageView) left_button_view.findViewById(R.id.imageView);
		// ��ʼ����ఴť������ӵ���ุ������
		header_leftview_container.addView(left_button_view);
		View right_button_view = mInflater.inflate(
				R.layout.common_head_right_img, null);
		right_button = (ImageView) right_button_view
				.findViewById(R.id.right_imageView);
		// ��ʼ���Ҳఴť������ӵ��Ҳุ������
		header_layout_rightview_container.addView(right_button_view);
		left_button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// �ӿڻص�
				if (onleftclicklistener != null) {
					onleftclicklistener.onClick();
				}
			}
		});

		right_button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// �ӿڻص�
				if (onrightclicklistener != null) {
					onrightclicklistener.onClick();
				}
			}
		});
	}

	public void tileMethod() {
		tv_title.setVisibility(View.VISIBLE);
	}

	public void leftMethod() {
		// ��ʼ����ఴť������ӵ���ุ������
		View left_button_view = mInflater.inflate(
				R.layout.common_head_left_img, null);
		left_button = (ImageView) left_button_view.findViewById(R.id.imageView);
		header_leftview_container.addView(left_button_view);
		// ��Ӽ����¼�
		left_button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (onleftclicklistener != null) {
					onleftclicklistener.onClick();
				}
			}
		});
	}

	private void backAndTitleMethod() {
		tv_title.setVisibility(View.VISIBLE);
		View left_button_view = mInflater.inflate(
				R.layout.common_head_left_img, null);
		left_button = (ImageView) left_button_view.findViewById(R.id.imageView);
		header_leftview_container.addView(left_button_view);
		left_button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (onleftclicklistener != null) {
					onleftclicklistener.onClick();
				}
			}
		});
	}

	public void setDefaultViewMethod(int leftsrcid, String title,
			int rightsrcid, OnLeftClickListener onleftclicklistener,
			OnRightClickListener onrightclicklistener) {
		if (!TextUtils.isEmpty(title)) {
			tv_title.setText(title);
		}
		if (leftsrcid != 0)
			left_button.setBackgroundResource(leftsrcid);
		else
			left_button.setBackgroundResource(R.drawable.ic_menu_back);
		if (rightsrcid != 0)
			right_button.setBackgroundResource(rightsrcid);
		else
			right_button.setBackgroundResource(R.drawable.btn_more);
		setOnLeftClickListener(onleftclicklistener);
		setOnRightClickListener(onrightclicklistener);
	}

	public void setRightAndTitleMethod(String title, int rightsrcid,
			OnRightClickListener onrightclicklistener) {
		System.out.println("title===="+title+"----rightsrcid-----"+rightsrcid);
		if (!TextUtils.isEmpty(title)) {
			tv_title.setText(title);
		}
		if (rightsrcid != 0)
			right_button.setBackgroundResource(rightsrcid);
		else
			right_button.setBackgroundResource(R.drawable.btn_more);
		  setOnRightClickListener(onrightclicklistener);

	}

	public void setLeftWithTitleViewMethod(int leftsrcid, String title,
			OnLeftClickListener onleftclicklistener) {
		if (!TextUtils.isEmpty(title)) {
			tv_title.setText(title);
		}
		if (leftsrcid != 0)
			left_button.setBackgroundResource(leftsrcid);
		else
			left_button.setBackgroundResource(R.drawable.ic_menu_back);
		setOnLeftClickListener(onleftclicklistener);
	}

	public void setOnlyTileViewMethod(String title) {
		if (!TextUtils.isEmpty(title)) {
			tv_title.setText(title);
		}
	}

	public void setLeftViewMethod(int leftsrcid,
			OnLeftClickListener onleftclicklistener) {
		if (leftsrcid != 0)
			left_button.setBackgroundResource(leftsrcid);
		else
			left_button.setBackgroundResource(R.drawable.ic_menu_back);
		setOnLeftClickListener(onleftclicklistener);

	}

	public void setOnLeftClickListener(OnLeftClickListener onleftclicklistener) {
		this.onleftclicklistener = onleftclicklistener;
	}

	public void setOnRightClickListener(
			OnRightClickListener onrightclicklistener) {
		this.onrightclicklistener = onrightclicklistener;
	}

	/**
	 * @author Mersens �Զ���ӿڻص������ڴ�����ఴť�ĵ���¼�
	 */
	public interface OnLeftClickListener {
		void onClick();
	}

	/**
	 * @author Mersens �Զ���ӿڻص������ڴ����Ҳ�ఴť�ĵ���¼�
	 */
	public interface OnRightClickListener {
		void onClick();
	}
}
