package com.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import com.sun.org.apache.xpath.internal.operations.Lt;
import com.tree.BinaryTreeInVerticalOrder.Node;

public class BinaryTreeSpiralView {

	Node root;
	
	class Node
	{
		Node left;
		Node right;
		int data;
		public Node(int data) {
			this.data = data;
		}
	}
	
	public void printTreeInSpiral(Node root)
	{
		Queue<Node> lQueues = new LinkedList<>();
		Queue<Integer> lTreeStack = new LinkedList<>();
		Stack<Integer> lReverseStack = new Stack<>();
		int lLevel = 0;
		lQueues.add(root);
		lQueues.add(null);
		Node lTemp;
		while( !lQueues.isEmpty() )
		{
			lTemp = lQueues.poll();
			if( lLevel %  2 == 0 && lTemp != null  )
			{
				lTreeStack.add(lTemp.data);
			}
			else if( lTemp != null )
			{
				lReverseStack.push(lTemp.data);
			}
			
			if( lTemp == null )
			{
				if( lLevel %  2 != 0)
				{
					while( !lReverseStack.isEmpty())
					{
						lTreeStack.add(lReverseStack.pop());
					}
				}
				if( !lQueues.isEmpty() )
					lQueues.add(null);
				lLevel++;
			}
			else
			{
				if( lTemp.left != null )
				{
					lQueues.add(lTemp.left);
				}
				if( lTemp.right != null )
				{
					lQueues.add(lTemp.right);
				}
			}
		}
		
		while( !lTreeStack.isEmpty())
		{
			System.out.print(lTreeStack.poll()+" ");
		}
		System.out.println();
	}
	
	public void printSpiralUsingTwoStack(Node root)
	{
		if( null == root)
		{
			return;
		}
		
		Stack<Node> lCurrentLevelStack = new Stack<>();
		Stack<Node> lNextLevelStack = new Stack<>();
		boolean lIsReverseTrue = true;
		lCurrentLevelStack.push(root);
		
		Node lTemp;
		while( !lCurrentLevelStack.isEmpty())
		{
			lTemp = lCurrentLevelStack.pop();
			System.out.print(lTemp.data + " ");
			if( lIsReverseTrue )
			{
				if( null != lTemp.left)
				{
					lNextLevelStack.push(lTemp.left);
				}
				
				if( null != lTemp.right)
				{
					lNextLevelStack.push(lTemp.right);
				}
			}
			else
			{
				if( null != lTemp.right)
				{
					lNextLevelStack.push(lTemp.right);
				}
				
				if( null != lTemp.left)
				{
					lNextLevelStack.push(lTemp.left);
				}
			}
			
			if( lCurrentLevelStack.isEmpty())
			{ 
				lIsReverseTrue = !lIsReverseTrue;
				lCurrentLevelStack = lNextLevelStack;
				lNextLevelStack = new Stack<>();
			}
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		
		BinaryTreeSpiralView tree = new BinaryTreeSpiralView();
		tree.root = tree.new Node(1);
        tree.root.left = tree.new Node(2);
        tree.root.right = tree.new Node(3);
        tree.root.left.left = tree.new Node(4);
        tree.root.left.right = tree.new Node(5);
        tree.root.right.left = tree.new Node(6);
        tree.root.right.right = tree.new Node(7);
        tree.printTreeInSpiral(tree.root);
        System.out.println("==========================");
        tree.printSpiralUsingTwoStack(tree.root);
	}
}
