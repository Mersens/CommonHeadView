package com.mersens.commonheadview.utils;

import java.util.ArrayList;
import java.util.List;

public class DatasUtils {
	private static DatasUtils datasutils;
	private List<String> list;
	private DatasUtils(){
		list=new ArrayList<String>();
		list.add("常用分类");
		list.add("潮流女装");
		list.add("品牌男装");
		list.add("内衣配饰");
		list.add("家用电器");
		list.add("手机数码");
		list.add("电脑办公");
		list.add("个护化妆");
		list.add("母婴频道");
		list.add("食物生鲜");
		list.add("酒水饮料");
		list.add("家居家纺");
		list.add("运动户外");
		list.add("整车车品");
		list.add("鞋靴箱包");
		list.add("居家生活");
		list.add("音像制品");
	}
	
	public static DatasUtils getInstance(){
		if(datasutils==null){
			datasutils=new DatasUtils();
		}
		return datasutils;
		
	}
	
	public List<String> getDatas(){
		return new ArrayList<String>(list);
		
	}

}
