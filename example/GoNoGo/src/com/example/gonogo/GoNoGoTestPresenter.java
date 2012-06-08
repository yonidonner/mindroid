package com.example.gonogo;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;

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
		currentTrial = 0;
		trials = GoNoGoTrial.createExcitingTrials(108);
		startTrial();
	}
	
	public void endTest() {
		
	}
	
	public void startTrial() {
		activity.runOnUiThread(new Runnable() {
			public void run() {
				view.showStimulus(trials.get(currentTrial).isTarget);
		    }
		});
		timer1.schedule(new TimerTask() {
			public void run() {
				activity.runOnUiThread(new Runnable() {
					public void run() {
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
