package com.example.gonogo;

import android.view.View;

public interface GoNoGoTestView {
	public void showStimulus(boolean isTarget);
	public void hideStimulus();
	public void initialize();
	public void hideStartButton();
	public void setTouchView(View view, GoNoGoTestPresenter presenter);
	public void setStatusText(String status);
}
