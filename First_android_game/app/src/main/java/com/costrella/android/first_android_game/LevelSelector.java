package com.costrella.android.first_android_game;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

/**
 * Created by mike on 2015-08-08.
 */
public class LevelSelector extends Activity implements View.OnClickListener {
    private RadioGroup levels;
    int i = 6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.level);

        levels = (RadioGroup) findViewById(R.id.levels);
        Button btnStart = (Button) findViewById(R.id.show_button);
        btnStart.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, GameActivity.class);

        int id = levels.getCheckedRadioButtonId();
        switch (id) {
            case R.id.level1:
                intent.putExtra("level", 1);
                break;
            case R.id.level2:
                intent.putExtra("level", 2);
                break;
            case R.id.level3:
                intent.putExtra("level", 3);
                break;
            case R.id.level4:
                intent.putExtra("level", 4);
                break;
        }

//        Log.e("onActivityResult", "Result not OK! Result code: "
//                + id);
        startActivity(intent);


    }
}
