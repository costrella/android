package pl.example.menu;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {
	private TextView label;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		label = (TextView) findViewById(R.id.menu_label);
		registerForContextMenu(label);
		if (savedInstanceState != null) {
			int color = savedInstanceState.getInt("color");
			int background = savedInstanceState.getInt("background");
			label.setTextColor(color);
			label.setBackgroundColor(background);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.options, menu);
		return true;
	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		menu.setHeaderTitle(R.string.context_label);
		getMenuInflater().inflate(R.menu.context, menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.b_red:
			label.setBackgroundColor(getResources().getColor(R.color.red));
			break;
		case R.id.b_green:
			label.setBackgroundColor(getResources().getColor(R.color.green));
			break;
		case R.id.b_blue:
			label.setBackgroundColor(getResources().getColor(R.color.blue));
			break;
		default:
			return super.onOptionsItemSelected(item);
		}
		return true;
	}

	@Override
	public boolean onContextItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.b_white:
			label.setTextColor(getResources().getColor(R.color.white));
			return true;
		case R.id.b_black:
			label.setTextColor(getResources().getColor(R.color.black));
			return true;
		default:
			return super.onContextItemSelected(item);
		}
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		outState.putInt("color", label.getCurrentTextColor());
		outState.putInt("background",
				((ColorDrawable) label.getBackground()).getColor()); // API 11+
	}
}
