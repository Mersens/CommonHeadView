package com.mersens.commonheadview.adaspter;

import java.util.List;
import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.mersens.commonheadview.bean.Type;
import com.mersens.commonheadview.main.R;

public class GridAdapter extends BaseAdapter{
	private List<Type> list;
	private LayoutInflater  inflater;
	
	public GridAdapter(Context context,List<Type> list){
		this.list=list;
		inflater=LayoutInflater.from(context);
	}
 
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@SuppressLint("InflateParams")
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;
		if(convertView==null){
			holder=new ViewHolder();
			convertView=inflater.inflate(R.layout.layout_gridview_item, null);
			holder.icon=(ImageView)convertView.findViewById(R.id.typeicon);
			holder.name=(TextView)convertView.findViewById(R.id.name);
			convertView.setTag(holder);
		}else{
			holder= (ViewHolder) convertView.getTag();
		}
		if(list!=null&&list.size()>0)
		{
			Type type=list.get(position);
			holder.name.setText(type.getName());
			if(type.getName().contains("���԰칫")){
				holder.icon.setBackgroundResource(R.drawable.diannao);
			}
			else if(type.getName().contains("������ױ")){
				holder.icon.setBackgroundResource(R.drawable.huazhuang);
			}
			else if(type.getName().contains("Ьѥ���")){
				holder.icon.setBackgroundResource(R.drawable.nvxie);
			}
			else if(type.getName().contains("����Ůװ")){
				holder.icon.setBackgroundResource(R.drawable.nvzhuang);
			}
			else if(type.getName().contains("ͼ��")){
				holder.icon.setBackgroundResource(R.drawable.shuji);
			}
			else if(type.getName().contains("�������")){
				holder.icon.setBackgroundResource(R.drawable.wanju);
			}
			else if(type.getName().contains("������Ʒ")){
				holder.icon.setBackgroundResource(R.drawable.yingshi);
			}
			else if(type.getName().contains("���÷���")){
				holder.icon.setBackgroundResource(R.drawable.yiyong);
			}
			else if(type.getName().contains("Ʒ����װ")){
				holder.icon.setBackgroundResource(R.drawable.nanzhuang);
			}
			else if(type.getName().contains("��������")){
				holder.icon.setBackgroundResource(R.drawable.neiyi);
			}
			else if(type.getName().contains("���õ���")){
				holder.icon.setBackgroundResource(R.drawable.dianqi);
			}
			else if(type.getName().contains("�ֻ�����")){
				holder.icon.setBackgroundResource(R.drawable.shouji);
			}
			else{
				holder.icon.setBackgroundResource(R.drawable.nvzhuang);
			}
		}
		
        return convertView;
	}
	
	private class ViewHolder{
		private ImageView icon;		
		private TextView name;
	}
}
