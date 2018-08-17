package com.tree;

public class ConnectNodesAtSameLevel {

	Node root;
	Node prev;
	int curlevel;
	class Node
	{
		Node left;
		Node right;
		Node nextRight;
		int data;
		
		public Node(int data) {
			this.data = data;
		}
	}
	
	public void connectNodes(Node root)
	{
		if( root == null)
			return;
		
		if( root.nextRight != null )
		{
			connectNodes(root.nextRight);
		}
		
		if( null != root.left)
		{
			if( null != root.right)
			{
				root.left.nextRight = root.right;
				root.right.nextRight = getNextRight(root);
			}
			else
			{
				root.left.nextRight = getNextRight(root);
			}
			connectNodes( root.left );
		}
		else if( null != root.right)
		{
			root.right.nextRight = getNextRight(root);
			connectNodes(root.right);
		}
		else
		{
			connectNodes( getNextRight(root));
		}
		
	}
	
	private Node getNextRight(Node root) {
		
		Node temp = root.nextRight;
		
		while( null != temp)
		{
			if( null != temp.left)
				return temp.left;
			if( null != temp.right)
				return temp.right;
			temp = temp.nextRight;
		}
		return null;
	}

	public static void main(String[] args) {
		
		ConnectNodesAtSameLevel tree = new ConnectNodesAtSameLevel();
		tree.root = tree.new Node(1);
        tree.root.left = tree.new Node(2);
        tree.root.right = tree.new Node(3);
        tree.root.left.left = tree.new Node(4);
        tree.root.left.right = tree.new Node(5);
        tree.root.right.left = tree.new Node(6);
        tree.root.right.right = tree.new Node(7);
        tree.root.left.left.left = tree.new Node(8);
        tree.root.left.left.right = tree.new Node(9);
        tree.root.right.right.left = tree.new Node(10);
        tree.root.right.right.right = tree.new Node(11);
        tree.connectNodes(tree.root);
        
        assert tree.root.left.nextRight.data == tree.root.right.data  : "Not Connected" ;
        assert tree.root.left.left.nextRight.data == tree.root.left.right.data  : "Not Connected" ;
        assert tree.root.right.left.nextRight.data == tree.root.right.right.data  : "Not Connected" ;
	}
}
