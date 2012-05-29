package com.example.gonogo;

public class GoNoGoTestPresenter {
	protected GoNoGoTestView view;

	public GoNoGoTestPresenter(GoNoGoTestView view) {
		super();
		this.view = view;
	}
	
	public void startTest() {
		view.hideStimulus();
	}
}
