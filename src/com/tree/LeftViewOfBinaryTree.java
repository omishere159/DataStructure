package com.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


class Node
{
	Node left;
	Node right;
	int val;
	public Node(int val) {
		super();
		this.val = val;
	}
	
	
}

public class LeftViewOfBinaryTree {

		
	private Node root;
	private int  maxLevel = 0;
	public void printLeftView()
	{
		if( root == null)
			return;
		
		Queue<Node> lNodeList = new LinkedList<>();
		lNodeList.add(root);
		lNodeList.add(null);
		Node ltemp;
		int count = 0;
		
		while( lNodeList.size() != 0 )
		{
			ltemp = lNodeList.poll();
			
			if( count == 0 )
			{
				if( ltemp == null)
					break;
				System.out.print( ltemp.val + " ");
				count++;
			}
			
			if( null == ltemp )
			{
				count = 0;
				lNodeList.add(null);
			}
			else
			{
				if( null != ltemp.left)
				{
					count++;
					lNodeList.add(ltemp.left);
				}
				if( null != ltemp.right)
				{
					count++;
					lNodeList.add(ltemp.right);
				}
			}
			
		}
		System.out.println();
	}
	
	
	
	public Node getRoot() {
		return root;
	}



	public static void main(String[] args) {
		
		LeftViewOfBinaryTree tree = new LeftViewOfBinaryTree();
		/*tree.root = new Node(5);
        tree.root.left = new Node(4);
        tree.root.right = new Node(2);
        tree.root.right.left = new Node(3);
        tree.root.right.right = new Node(1);
        tree.root.right.left.left = new Node(6);
        tree.root.right.left.right = new Node(7);*/
		tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.right.right = new Node(4);
        tree.root.right.right.right = new Node(5);
        tree.root.right.right.right.right = new Node(6);
        tree.printLeftView();
        System.out.println("========================== >");
        tree.recursivePrintLeftView(tree.getRoot(),1);
        System.out.println();
	}

	private void recursivePrintLeftView(Node root, int level) {
		
		if( null == root)
			return;
		
		if( maxLevel < level )
		{
			System.out.print(" "+root.val);
			maxLevel = level;
		}
		
		recursivePrintLeftView(root.left,level+1);
		recursivePrintLeftView(root.right,level+1);
	}
}
