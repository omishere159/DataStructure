package com.heap;

public enum HeapType {

	MAX_HEAP(0),  MIN_HEAP(2);
	
	private final int value;
	
	private HeapType(final int newValue) {
		value = newValue;
	}
	
	public int getValue() {
		 return value;
	}
}
