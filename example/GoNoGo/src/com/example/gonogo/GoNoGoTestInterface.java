package com.example.gonogo;

import android.view.View;
import android.widget.ImageView;

public class GoNoGoTestInterface implements GoNoGoTestView {

	private ImageView imageView;
	
	public GoNoGoTestInterface(ImageView imageView) {
		super();
		this.imageView = imageView;
	}

	@Override
	public void showStimulus(int stimulus) {
		imageView.setVisibility(View.VISIBLE);

	}

	@Override
	public void hideStimulus() {
		imageView.setVisibility(View.INVISIBLE);

	}

}
