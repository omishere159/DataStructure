package com.heap;

public class MinHeap extends Heap {

	public MinHeap() {
		super(Integer.MAX_VALUE/1000, HeapType.MIN_HEAP.getValue());
	}

}
