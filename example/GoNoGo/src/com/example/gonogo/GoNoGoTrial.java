package com.example.gonogo;

import java.util.ArrayList;
import java.util.List;

public class GoNoGoTrial {
	public boolean isTarget;
	public boolean userResponse;
	public int reactionTime;
	
	public GoNoGoTrial(boolean isTarget, boolean userResponse, int reactionTime) {
		super();
		this.isTarget = isTarget;
		this.userResponse = userResponse;
		this.reactionTime = reactionTime;
	}

	static public List<GoNoGoTrial> createTrials(int numTrials, int numPositives) {
		List<GoNoGoTrial> trials = new ArrayList<GoNoGoTrial>();
		int i;
		List<Integer> list = new ArrayList<Integer>();
		for (i = 0; i < numTrials; ++i) {
			list.add(i);
			trials.add(new GoNoGoTrial(false, false, 0));
		}
		java.util.Collections.shuffle(list);
		for (i = 0; i < numPositives; ++i) {
			trials.get(list.get(i)).isTarget = true;
		}
		for (i = numPositives; i < numTrials; ++i) {
			trials.get(list.get(i)).isTarget = false;
		}
		return trials;
	}

	static public List<GoNoGoTrial> createExcitingTrials(int numTrials) {
		return createTrials(numTrials, numTrials * 14 / 18);
	}
}
