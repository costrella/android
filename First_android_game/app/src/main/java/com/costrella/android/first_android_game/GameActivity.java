package com.costrella.android.first_android_game;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.util.Log;
import android.widget.TextView;

/**
 * Created by mike on 2015-08-08.
 */
public class GameActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Resources res = getResources();
        TextView tv = new TextView(this);
        Spanned text = Html.fromHtml("<u>" + res.getString(R.string.siema) + "</u>");

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        int level = (Integer) bundle.get("level");
        Log.e("onActivityResult", "Result not OK! Result code: "
                + level);
        tv.setText(text + ": " + level);
        tv.setTextColor(res.getColor(R.color.red));
        tv.setTextSize(res.getDimension(R.dimen.medium));
        setContentView(tv);
    }
}
