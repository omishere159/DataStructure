package com.heap;

public class MedianOfNumberStream {

	public static void main(String[] args) {
		int A[] = { 5, 15, 1, 3, 2, 8, 7, 9, 10, 6, 11, 4 };
		//int B[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		findMedianOfStream(A);
	}

	private static void findMedianOfStream(int[] input) {
		
		Heap lMaxHeap = new MaxHeap();
		Heap lMinHeap = new MinHeap();
		
		float lMedian = 0;
		
		int size = input.length;
		
		for( int i=0;i<size;i++)
		{
			System.out.print("Current median of "+(i+1)+" elements is : ");
			lMedian = cumputeCurrentMedian(input[i],lMedian, lMaxHeap,lMinHeap);
			System.out.print(lMedian);
			System.out.println();
		}
	}

	private static float cumputeCurrentMedian(int currentElement, float median, Heap maxHeap, Heap minHeap) {
		
		int lStat = HeapUtil.leftOrRight(maxHeap.getSize(), minHeap.getSize());
		switch( lStat)
		{
		case 1:
			// Number of elements in left (max) heap > right (min) heap
			if( currentElement < median)
			{
				// Remove top element from left heap and
				// insert into right heap
				minHeap.insert(maxHeap.remove());
				// current element fits in left (max) heap
				maxHeap.insert(currentElement);
			}
			else
			{
				// current element fits in right (min) heap
				maxHeap.insert(currentElement);
			}
			median = HeapUtil.average(maxHeap.getTop(), minHeap.getTop());
			break;
		case -1:
			// Number of elements in left (max) heap < right (min) heap
			if( currentElement < median )
			{
				minHeap.insert(currentElement);
			}
			else
			{
				// Remove top element from right heap and
				// insert into left heap
				minHeap.insert(maxHeap.remove());
				// current element fits in right (min) heap
				maxHeap.insert(currentElement);
			}
			median = HeapUtil.average(minHeap.getTop(), maxHeap.getTop());
			break;
		case 0:
			// Number of elements in left (max) heap = right (min) heap
			if( currentElement < median)
			{
				maxHeap.insert(currentElement);
				median = maxHeap.getTop();
			}
			else
			{
				minHeap.insert(currentElement);
				median = minHeap.getTop();
			}
			break;
		}
		return median;
	}
}
