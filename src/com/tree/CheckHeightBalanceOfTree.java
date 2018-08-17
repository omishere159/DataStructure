package com.tree;

public class CheckHeightBalanceOfTree {

	Node root;
	static class Node
	{
		Node left;
		Node  right;
		int data;
		
		public Node(int data) {
			this.data = data;
		}
	}
	
	// A wrapper class used to modify height across
	// recursive calls.
	class Height
	{
	    int height = 0;
	}
	
	//O(n2)
	public boolean isHeightBalanced(Node root)
	{
		if( root == null)
			return true;
		
		int lh = getHeight(root.left);
		int rh = getHeight(root.right);
		
		if( Math.abs(lh - rh ) <= 1 && isHeightBalanced(root.left) && isHeightBalanced(root.right) )
			return true;
		return false;
	}

	private int getHeight(Node node) {
		if( null == node )
			return 0;
		return 1+Integer.max(getHeight(node.left),getHeight(node.right));
	}
	
	//O(n)
	public boolean isHeightBalancedOptimized(Node node,Height height)
	{
		
		if(null == node)
		{
			height.height = 0;
			return true;
		}
		
		Height lHeight = new Height(),rHeight = new Height();
		
		boolean l = isHeightBalancedOptimized(node.left,lHeight);
		boolean r = isHeightBalancedOptimized(node.right,rHeight);
		
		int lh = lHeight.height,rh=rHeight.height;
		height.height = Integer.max(lh, rh) + 1;
		if( Math.abs(lh - rh ) >= 2)
			return false;
		else return l && r;
	}
	
	public static void main(String[] args) {
		
		CheckHeightBalanceOfTree tree = new CheckHeightBalanceOfTree();
		
		tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.left.left.left = new Node(8);
  
        if(tree.isHeightBalanced(tree.root))
            System.out.println("Tree is balanced");
        else
            System.out.println("Tree is not balanced");
        
        System.out.println("=====================");
        
        if(tree.isHeightBalancedOptimized( tree.root,tree.new Height()))
            System.out.println("Tree is balanced");
        else
            System.out.println("Tree is not balanced");
	}
}
