package com.androidhive.pushnotification.database;

import java.util.ArrayList;

import com.androidhive.pushnotifications.R;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MessageAdapter extends BaseAdapter {

	Context mContext;
	ArrayList<Message> mListResult;

	public MessageAdapter(Context context, ArrayList<Message> result) {
		super();
		mContext = context;
		mListResult = result;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mListResult.size();
	}

	@Override
	public Message getItem(int arg0) {
		// TODO Auto-generated method stub
		return mListResult.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		final ViewHolder holder;

		if (convertView == null) {
			convertView = LayoutInflater.from(mContext).inflate(
					R.layout.row_message, null);
			holder = new ViewHolder();
			holder.category = (TextView) convertView.findViewById(R.id.tvCategory);
			holder.message = (TextView) convertView
					.findViewById(R.id.tvMsg);
			holder.datepost = (TextView) convertView
					.findViewById(R.id.tvDatePost);
//			holder.thumb = (ImageView) convertView.findViewById(R.id.ivThumb);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		Message msg = getItem(position);
		holder.category.setText(msg.getCategory());
		holder.message.setText(msg.getMessage());
		holder.datepost.setText(msg.getDate());
		
		if (msg.isRead == 1) {
			holder.category.setTypeface(Typeface.DEFAULT, Typeface.NORMAL);
			holder.message.setTypeface(Typeface.DEFAULT, Typeface.NORMAL);
			holder.datepost.setTypeface(Typeface.DEFAULT, Typeface.NORMAL);
		} else {
			holder.category.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
			holder.message.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
			holder.datepost.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
		}
//		imageLoader.displayImage(promos.thumbnail, holder.thumb, options);
		return convertView;
	}

	class ViewHolder {
		public TextView category;
		public TextView message;
		public TextView datepost;
	}

}
