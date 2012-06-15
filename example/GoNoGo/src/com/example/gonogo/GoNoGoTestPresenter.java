package com.example.gonogo;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.view.MotionEvent;
import android.view.View;

public class GoNoGoTestPresenter {
	protected Activity activity;
	protected GoNoGoTestView view;
	protected Timer timer1, timer2;
	protected List<GoNoGoTrial> trials;
	protected int currentTrial;
	
	protected enum GoNoGoState {
		BEFORE_TEST_START, DURING_STIMULUS_DISPLAY, AFTER_STIMULUS_DISPLAY, AFTER_TEST_END
	}
	
	protected GoNoGoState testState;
	
	public GoNoGoTestPresenter(Activity activity, GoNoGoTestView view) {
		super();
		this.view = view;
		this.timer1 = new Timer();
		this.timer2 = new Timer();
		this.activity = activity;
		this.testState = GoNoGoState.BEFORE_TEST_START;
	}
	
	public void startTest() {
		view.hideStartButton();
		view.initialize();
		view.setStatusText("");
		currentTrial = 0;
		trials = GoNoGoTrial.createExcitingTrials(108);
		startTrial();
	}
	
	public void endTest() {
		
	}

	public boolean onTouch(View v, MotionEvent event) {
		if (!((testState == GoNoGoState.DURING_STIMULUS_DISPLAY) || (testState == GoNoGoState.AFTER_STIMULUS_DISPLAY))) {
			return false;
		}
		if (trials.get(currentTrial).isTarget) {
			view.setStatusText("Correct!");
		}
		else {
			view.setStatusText("Wrong!");
		}
		return false;
	}
	
	public void startTrial() {
		activity.runOnUiThread(new Runnable() {
			public void run() {
				view.showStimulus(trials.get(currentTrial).isTarget);
				testState = GoNoGoState.DURING_STIMULUS_DISPLAY;
		    }
		});
		timer1.schedule(new TimerTask() {
			public void run() {
				activity.runOnUiThread(new Runnable() {
					public void run() {
						testState = GoNoGoState.AFTER_STIMULUS_DISPLAY;
						view.hideStimulus();
						timer2.schedule(new TimerTask() {
							public void run() {
								if (++currentTrial == trials.size()) {
									endTest();
								}
								else {
									startTrial();
								}
							}
						}, 1900);	
				    }
				});
			}
		}, 100);	
	}
}
