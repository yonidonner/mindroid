package com.example.gonogo;

import android.app.Activity;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class GoNoGoTestInterface implements GoNoGoTestView {

	private ImageView imageView;
	private Button testStartButton;
	private Activity activity;
	private Drawable targetDrawable;
	private Drawable nontargetDrawable;
	
	public GoNoGoTestInterface(Activity activity) {
		super();
		this.activity = activity;
		this.imageView = (ImageView)activity.findViewById(R.id.stimulus_image);
		this.testStartButton = (Button)activity.findViewById(R.id.test_start_button);
		this.targetDrawable = activity.getResources().getDrawable(R.drawable.gonogo_target);
		this.nontargetDrawable = activity.getResources().getDrawable(R.drawable.gonogo_nontarget);
	}

	@Override
	public void showStimulus(boolean isTarget) {
		if (isTarget) {
			imageView.setImageDrawable(targetDrawable);
		}
		else {
			imageView.setImageDrawable(nontargetDrawable);
		}
		imageView.setVisibility(View.VISIBLE);

	}

	@Override
	public void hideStartButton() {
		testStartButton.setVisibility(View.GONE);
		
	}

	@Override
	public void hideStimulus() {
		imageView.setVisibility(View.INVISIBLE);

	}

	@Override
	public void initialize() {
		BitmapFactory.decodeResource(activity.getResources(), R.drawable.gonogo_nontarget);
		BitmapFactory.decodeResource(activity.getResources(), R.drawable.gonogo_target);
	}

}
