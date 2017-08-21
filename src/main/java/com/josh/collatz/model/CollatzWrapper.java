package com.josh.collatz.model;

import java.util.List;

public class CollatzWrapper {

	private List<Long> steps;
	private long numSteps;
	private Long num;
	
	public List<Long> getSteps() {
		return steps;
	}
	public void setSteps(List<Long> steps) {
		this.steps = steps;
	}
	public long getNumSteps() {
		return numSteps;
	}
	public void setNumSteps(long numSteps) {
		this.numSteps = numSteps;
	}
	public Long getNum() {
		return num;
	}
	public void setNum(Long num) {
		this.num = num;
	}
	@Override
	public String toString() {
		return "CollatzWrapper [num=" + num + ", numSteps=" + numSteps + ", steps=" + steps + "]";
	}
}
