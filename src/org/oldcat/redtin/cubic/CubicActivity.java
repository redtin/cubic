package org.oldcat.redtin.cubic;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Adapter;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.SimpleAdapter;

public class CubicActivity extends Activity {

	private static final String TAG = "CubalaActivity";
	private CubAdpter cubadt;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cubala);
		makeCube(9);
	}

	public void makeCube(int count) {
		GridView grid = (GridView) findViewById(R.id.gridview);
		cubadt = new CubAdpter(this);
		cubadt.setCount(count);
		int q = (int) Math.sqrt(count);
		grid.setNumColumns(q);
		grid.setAdapter(cubadt);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.cubala, menu);
		return true;
	}

}
