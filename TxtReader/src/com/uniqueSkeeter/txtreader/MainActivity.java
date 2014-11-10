package com.uniqueSkeeter.txtreader;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.activity_main);
		Button openFileBtn = (Button) this.findViewById(R.id.openFIleBtn);
		openFileBtn.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO 打开sd card 文件列表
				Intent in = new Intent(MainActivity.this, ListAllFileActivity.class);
				MainActivity.this.startActivityForResult(in, 0);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		this.getMenuInflater().inflate(R.menu.main, menu);
		menu.removeItem(R.id.utf8);
		menu.removeItem(R.id.gb2312);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		switch (id) {
			case R.id.about:
				this.doAbout();
				break;
			default:
				break;
		}
		return super.onOptionsItemSelected(item);
	}

	// 点击关于弹出框
	private void doAbout() {
		Dialog dialog = new AlertDialog.Builder(MainActivity.this).setTitle(R.string.about_title)
				.setMessage(R.string.about_info).setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialoginterface, int i) {
						// 按钮事件
					}
				}).create();
		dialog.show();
	}
}
