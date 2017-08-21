package com.josh.collatz.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service("Collatz")
@Scope("singleton")
public class Collatz {

	public CollatzWrapper calculateCollatz(long num) {
		List<Long> steps = new ArrayList<Long>();
		long numSteps = 1;
		CollatzWrapper cw = new CollatzWrapper();
		cw.setNum(num);
		
		if (num < 1) {
			cw.setSteps(steps);
			return cw;
		}
		
		steps.add(num);
		
		while (num != 1) {
			if (num % 2 == 0) {
				num /= 2;
			} else {
				num = 3*num + 1;
			}
			numSteps++;
			steps.add(num);
		}
		
		cw.setNumSteps(numSteps);
		cw.setSteps(steps);
		
		return cw;
	}
	
}
