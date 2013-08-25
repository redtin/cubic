package org.oldcat.redtin.cubic;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class CubAdpter extends BaseAdapter {
	SparseArray<View> ary = null;
	private Activity mContext;
	private int mCount = 0;
	private int Ncol;
	private int Nrow;
	private static final String TAG = "CubAdpter";

	public CubAdpter(Activity context) {
		mContext = context;
		// DisplayMetrics met = mContext.getResources().getDisplayMetrics();

	}

	public void setCount(int cnt) {
		ary = new SparseArray<View>(cnt);
		mCount = cnt;
		int q = (int) Math.sqrt(cnt);
		Ncol = q;
		Nrow = q + ((cnt - q * q) / q);
	}

	@Override
	public int getCount() {
		return mCount;
	}

	@Override
	public Object getItem(int position) {
		return ary.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View v;
		if (null == convertView) {
			v = ary.get(position);
			if (null == v) {
				int hei = parent.getHeight()/Nrow;
				v = mContext.getLayoutInflater().inflate(R.layout.item, null);
				v.setTag(position);
				ary.put(position, v);
				Log.d(TAG, "view created!");
			}
		} else {
			v = convertView;
		}

		return v;
	}
}
