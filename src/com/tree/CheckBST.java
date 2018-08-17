package com.tree;




public class CheckBST {

	Node root;
	Node prev;
	class Node
	{
		Node left;
		Node right;
		int data;
		public Node(int data) {
			this.data = data;
		}
	}

	private boolean checkBst(Node root)
	{
		if( root != null )
		{
			if( !checkBst(root.left))
			{
				return false;
			}
			if( prev != null && root.data <= prev.data)
			{
				return false;
			}
			prev = root;
			return checkBst(root.right);
		}
			
		return true;
	}
	
	public static void main(String[] args) {
		CheckBST tree = new CheckBST();
		/*tree.root = tree.new Node(1);
        tree.root.left = tree.new Node(2);
        tree.root.right = tree.new Node(3);
        tree.root.right.right = tree.new Node(4);
        tree.root.right.right.right = tree.new Node(5);
        tree.root.right.right.right.right = tree.new Node(6);*/
		
		/*tree.root = tree.new Node(11);
        tree.root.left = tree.new Node(5);
        tree.root.right = tree.new Node(16);
        tree.root.left.right = tree.new Node(8);
        tree.root.left.left = tree.new Node(4);
        tree.root.right.right = tree.new Node(18);
        tree.root.right.left = tree.new Node(14);*/
		
		tree.root = tree.new Node(3);
        tree.root.left = tree.new Node(2);
        tree.root.right = tree.new Node(5);
        tree.root.left.left = tree.new Node(1);
        tree.root.left.right = tree.new Node(4);
        
        System.out.println("Given tree is BST 0(false)/1(true) ? "+tree.checkBst(tree.root));
	}
}
