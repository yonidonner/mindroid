package com.example.gonogo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class GoNoGoTestActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gonogotest);
    }
    
    protected GoNoGoTestPresenter presenter;
    protected ImageView imageView;
    protected GoNoGoTestInterface view;
    
	@Override
	protected void onStart() {
		super.onStart();
		view = new GoNoGoTestInterface(this);
		presenter = new GoNoGoTestPresenter(this, view);
		FrameLayout layout = (FrameLayout)findViewById(R.id.frame_layout);
		view.setTouchView(layout, presenter);
	}
	
	public void startClicked(View view) {
		presenter.startTest();
	}
}
