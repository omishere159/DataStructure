package com.tree;

public class NumberOfLeafNodesInTree {

	Node root;
	static class Node
	{
		Node left;
		Node right;
		int data;
		public Node(int data) {
			super();
			this.data = data;
		}
		
	}
	
	public int countLeafNodes(Node node)
	{
		if( null == node)
		{
			return 1;
		}
		
		if( node.left == null && node.right == null)
		{
			return 1;
		}
		
		return countLeafNodes(node.left)+countLeafNodes(node.right);
	}
	
	public static void main(String[] args) {
		
		NumberOfLeafNodesInTree tree = new NumberOfLeafNodesInTree();
		
		tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
		
        System.out.println("Number of leaf nodes : "+tree.countLeafNodes(tree.root));
	}
}
