package com.mersens.commonheadview.utils;

import java.util.ArrayList;
import java.util.List;

public class DatasUtils {
	private static DatasUtils datasutils;
	private List<String> list;
	private DatasUtils(){
		list=new ArrayList<String>();
		list.add("���÷���");
		list.add("����Ůװ");
		list.add("Ʒ����װ");
		list.add("��������");
		list.add("���õ���");
		list.add("�ֻ�����");
		list.add("���԰칫");
		list.add("������ױ");
		list.add("ĸӤƵ��");
		list.add("ʳ������");
		list.add("��ˮ����");
		list.add("�ҾӼҷ�");
		list.add("�˶�����");
		list.add("������Ʒ");
		list.add("Ьѥ���");
		list.add("�Ӽ�����");
		list.add("������Ʒ");
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
