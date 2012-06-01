package com.example.gonogo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class GoNoGoTestActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gonogotest);
    }

	@Override
	protected void onStart() {
		super.onStart();
		ImageView imageView = (ImageView)findViewById(R.id.stimulus_image);
		GoNoGoTestInterface view = new GoNoGoTestInterface(imageView);
		GoNoGoTestPresenter presenter = new GoNoGoTestPresenter(this, view);
		presenter.startTest();
	}
}
