package com.heap;

public class Heap {
	
	int[] heap;
	int size;
	int minMaxFlag;
	
	public Heap(int max,int minMaxFlag)
	{
		heap = new int[max];
		size = 0;
		this.minMaxFlag = minMaxFlag;
	}
	
	public int getSize()
	{
		return size;
	}
	
	public int getTop()
	{
		int max = Integer.MAX_VALUE;
		 if( size > 0)
		 {
			 return heap[0];
		 }
		 
		 return max;
	}
	
	public int parentIndex(int index)
	{
		return (index - 1)/2;
	}
	
	public int leftChildIndex(int index)
	{
		return (2 * index) + 1;
	}
	
	public int rightChildIndex(int index)
	{
		return (2 * index) + 2;
	}
	
	public void swap(int index1, int index2)
	{
		heap[index1] = heap[index1] ^ heap[index2];
		heap[index2] = heap[index1] ^ heap[index2];
		heap[index1] = heap[index1] ^ heap[index2];
	}
	
	public void insert(int element)
	{
		if( size == 0)
		{
			heap[size++] = element;
		}
		else
		{
			heap[size] = element;
			percolateUp(size++);
		}
	}

	private void percolateUp(int index) {
		
		int temp = heap[index];
		int parent = parentIndex(index);
		
		if( minMaxFlag == 0)
		{
			while( index > 0 && heap[parent] < temp)
			{
				heap[index] = heap[parent];
				index = parent;
				parent = parentIndex(index);
			}
		}
		else
		{
			while( index > 0 && heap[parent] > temp)
			{
				heap[index] = heap[parent];
				index = parent;
				parent = parentIndex(index);
			}
		}
		
		heap[index] = temp;
	}
	
	public int remove()
	{
		int temp = heap[0];
		heap[0] = heap[--size];
		percolateDown(0);
		return temp;
	}

	//we need to do is swap the root with its smallest/largest child less/greater than the root
	private void percolateDown(int index) {
		
		int lcIndex;
		int rcIndex;
		int temp = heap[index];
		int largeChildIndex;
		int smallChildIndex;
		
		if( minMaxFlag == 0)
		{
			while( index < (size/2))
			{
				lcIndex = leftChildIndex(index);
				rcIndex = rightChildIndex(index);
				if( rcIndex < size && heap[lcIndex] > heap[rcIndex] )
				{
					largeChildIndex = lcIndex;
				}
				else
				{
					largeChildIndex = rcIndex;
				}
				if( heap[largeChildIndex] <= temp )
				{
					break;
				}
				heap[index] = heap[largeChildIndex];
				index = largeChildIndex;
			}
		}
		else
		{
			while( index < (size /2 ) )
			{
				lcIndex = leftChildIndex(index);
				rcIndex = rightChildIndex(index);
				if( rcIndex < size && heap[lcIndex] > heap[rcIndex] )
				{
					smallChildIndex = rcIndex;
				}
				else
				{
					smallChildIndex = lcIndex;
				}
				if( heap[smallChildIndex] >= temp )
				{
					break;
				}
				heap[index] = heap[smallChildIndex];
				index = smallChildIndex;	
			}
		}
		heap[index] = temp;
	}
}
