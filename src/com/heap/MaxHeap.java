package com.heap;

public class MaxHeap extends Heap {

	public MaxHeap() {
		super(Integer.MAX_VALUE/1000, HeapType.MAX_HEAP.getValue());
	}

}
