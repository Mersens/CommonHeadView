package com.mersens.commonheadview.main;
import com.mersens.commonheadview.fragment.TestFragment;

import android.support.v4.app.Fragment;

public class TestFragmentActivity extends BaseFragmentActivity {
	@Override
	protected Fragment creatFragment() {
		return new TestFragment();
	}
	
}
