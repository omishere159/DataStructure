package com.tree;

public class DaimeterOfBinaryTree {

	Node root;
	static class Node
	{
		Node left;
		Node right;
		int data;
		
		public Node(int data) {
			this.data = data;
		}
	}
	
	public int getDiameter(Node node)
	{
		if( null == node)
			return 0;
		
		int lHeight = getHeight(node.left);
		int rHeight = getHeight(node.right);
		
		int lDiameter = getDiameter(node.left);
		int rDiameter = getDiameter(node.right);
		
		return Integer.max(lHeight+rHeight+1, Integer.max(lDiameter,rDiameter));
	}

	private int getHeight(Node node) {
		if(node == null)
		{
			return 0;
		}
		return 1 + Integer.max(getHeight(node.left), getHeight(node.right));
	}
	
	public static void main(String[] args) {
		
		DaimeterOfBinaryTree tree = new DaimeterOfBinaryTree();
		tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
 
        System.out.println("The diameter of given binary tree is : "
                           + tree.getDiameter(tree.root));
	}
}
