package com.tree;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class BinaryTreeTopView {

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
	
	private void printTopView(Node root,int horizontalDistance,Map<Integer, Integer> topViewMap)
	{
		if( root == null)
		{
			return;
		}
		
		if( !topViewMap.containsKey(horizontalDistance) )
		{
			topViewMap.put( horizontalDistance, root.data );
		}
		
		printTopView(root.left,horizontalDistance-1,topViewMap);
		printTopView(root.right,horizontalDistance+1,topViewMap);
	}
	
	public static void main(String[] args) {
		
		BinaryTreeTopView tree = new BinaryTreeTopView();
		
		tree.root = tree.new Node(1);
        tree.root.left = tree.new Node(2);
        tree.root.right = tree.new Node(3);
        tree.root.left.left = tree.new Node(4);
        tree.root.left.right = tree.new Node(5);
        tree.root.right.left = tree.new Node(6);
        tree.root.right.right = tree.new Node(7);
        tree.root.left.left.left = tree.new Node(8);
		tree.root.left.left.right = tree.new Node(9);
        Map<Integer, Integer> lPairMap = new TreeMap<>();
        tree.printTopView(tree.root,0,lPairMap);
		
        Iterator<Map.Entry<Integer, Integer>> lIt = lPairMap.entrySet().iterator();
        
        while( lIt.hasNext())
        {
        	System.out.print( lIt.next().getValue() +" " );
        }
        System.out.println();
	}
}
