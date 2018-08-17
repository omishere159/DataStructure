package com.tree;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

import javafx.geometry.HPos;

public class BottomViewOfBinaryTree {

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
	
	private void printBottomView(Node root,int level,int horizontalDistance,Map<Integer, Pair> pairMap)
	{
		if( root == null)
		{
			return;
		}
		
		if( !pairMap.containsKey(horizontalDistance) )
		{
			pairMap.put(horizontalDistance, new Pair(level, root.data));
		}
		else
		{
			Pair p = pairMap.get(horizontalDistance);
			if( p.height <= level)
			{
				p.height = level;
				p.data = root.data;
			}
		}
		
		printBottomView(root.left,level+1,horizontalDistance-1,pairMap);
		printBottomView(root.right,level+1,horizontalDistance+1,pairMap);
	}
	public static void main(String[] args) {
		
		BottomViewOfBinaryTree tree = new BottomViewOfBinaryTree();
		
		
		tree.root = tree.new Node(20);
        tree.root.left = tree.new Node(8);
        tree.root.right = tree.new Node(22);
        tree.root.left.left = tree.new Node(5);
        tree.root.left.right = tree.new Node(3);
        tree.root.left.right.left = tree.new Node(10);
        tree.root.right.left = tree.new Node(4);
        tree.root.left.right.right = tree.new Node(14);
        tree.root.right.right = tree.new Node(25);
        Map<Integer, Pair> lPairMap = new TreeMap<>();
        tree.printBottomView(tree.root,0,0,lPairMap);
        
        Iterator<Map.Entry<Integer, Pair>> lIt = lPairMap.entrySet().iterator();
        
        while( lIt.hasNext() )
        {
        	System.out.print( lIt.next().getValue().data+" " );
        }
        System.out.println();
	}
}
