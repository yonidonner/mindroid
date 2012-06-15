package com.example.gonogo;

import android.app.Activity;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class GoNoGoTestInterface implements GoNoGoTestView {

	private ImageView imageView;
	private Button testStartButton;
	private Activity activity;
	private Drawable targetDrawable;
	private Drawable nontargetDrawable;
	protected GoNoGoTestPresenter presenter;
	private EditText status;
	private View touchView;
	
	public GoNoGoTestInterface(Activity activity) {
		super();
		this.activity = activity;
		this.imageView = (ImageView)activity.findViewById(R.id.stimulus_image);
		this.testStartButton = (Button)activity.findViewById(R.id.test_start_button);
		this.targetDrawable = activity.getResources().getDrawable(R.drawable.gonogo_target);
		this.nontargetDrawable = activity.getResources().getDrawable(R.drawable.gonogo_nontarget);
		this.status = (EditText)activity.findViewById(R.id.editText1);
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

	@Override
	public void setTouchView(View view, GoNoGoTestPresenter presenter1) {
		this.touchView = view;
		this.presenter = presenter1;
		touchView.setOnTouchListener(new View.OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				return presenter.onTouch(v, event);
			}
		});
	}

	@Override
	public void setStatusText(String status) {
		this.status.setText(status);
		
	}

}
