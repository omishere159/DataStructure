package com.tree;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
public class BinaryTreeInVerticalOrder {

	Node root;
	class Node
	{
		Node left;
		Node right;
		int data;
		public Node(int data) {
			super();
			this.data = data;
		}
		
		
	}
	
	class Pair
	{
		int height;
		int data;
		
		public Pair(int height, int data) {
			super();
			this.height = height;
			this.data = data;
		}
		
		
	}
	
	private void printVerticalView(Node root,int horizontalDistance,Map<Integer, Set<Integer>> verticalColumnMap)
	{
		if( root == null)
		{
			return;
		}
		
		if( !verticalColumnMap.containsKey(horizontalDistance) )
		{
			Set<Integer> lVerticalColumnData = new TreeSet<>();
			lVerticalColumnData.add(root.data);
			verticalColumnMap.put( horizontalDistance, lVerticalColumnData );
		}
		else
		{
			verticalColumnMap.get(horizontalDistance).add(root.data);
		}
		
		printVerticalView(root.left,horizontalDistance-1,verticalColumnMap);
		printVerticalView(root.right,horizontalDistance+1,verticalColumnMap);
	}
	
	public static void main(String[] args) {
		
		BinaryTreeInVerticalOrder tree = new BinaryTreeInVerticalOrder();
		
		tree.root = tree.new Node(1);
        tree.root.left = tree.new Node(2);
        tree.root.right = tree.new Node(3);
        tree.root.left.left = tree.new Node(4);
        tree.root.left.right = tree.new Node(5);
        tree.root.right.left = tree.new Node(6);
        tree.root.right.right = tree.new Node(7);
        Map<Integer, Set<Integer>> lPairMap = new TreeMap<>();
        tree.printVerticalView(tree.root,0,lPairMap);
        
        Iterator<Map.Entry<Integer, Set<Integer>>> lIt = lPairMap.entrySet().iterator();
        
        Set<Integer> lSet;
        while( lIt.hasNext() )
        {
        	lSet = lIt.next().getValue();
        	for( Integer lCurInt: lSet)
        	{
        		System.out.print( lCurInt+" " );
        	}
        	System.out.print( "|" );
        }
        System.out.println();
	}
}
