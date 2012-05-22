package com.example.gonogo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class GoNoGoActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
    
    public void startClicked(View view) {
    	Intent intent = new Intent(this, GoNoGoTestActivity.class);
        startActivity(intent);
    }
}