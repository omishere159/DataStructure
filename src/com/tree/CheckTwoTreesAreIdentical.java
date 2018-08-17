package com.tree;

public class CheckTwoTreesAreIdentical {

	Node root1,root2;
	static class Node
	{
		Node left;
		Node right;
		int data;
		
		public Node(int data) {
			this.data = data;
		}
	}
	
	public boolean isIdentical(Node root1,Node root2)
	{
		if( null == root1 && null == root2)
		{
			return true;
		}
		
		if( null != root1 && null != root2)
		{
			return root1.data == root2.data && isIdentical(root1.left,root2.left) && isIdentical(root1.right, root2.right);
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		
		CheckTwoTreesAreIdentical tree = new CheckTwoTreesAreIdentical();
		
		tree.root1 = new Node(1);
        tree.root1.left = new Node(2);
        tree.root1.right = new Node(3);
        tree.root1.left.left = new Node(4);
        tree.root1.left.right = new Node(5);
        //tree.root1.right.left = new Node(6);
  
        tree.root2 = new Node(1);
        tree.root2.left = new Node(2);
        tree.root2.right = new Node(3);
        tree.root2.left.left = new Node(4);
        tree.root2.left.right = new Node(5);
  
        if (tree.isIdentical(tree.root1, tree.root2))
            System.out.println("Both trees are identical");
        else
            System.out.println("Trees are not identical");
	}
}
