package com.tree;

import com.tree.CheckTwoTreesMirrorOfItself.Node;

public class HeightOfBinaryTree {

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
	
	public int getHeight(Node node)
	{
		if( null == node)
			return 0;
		
		return 1 + Integer.max(getHeight(node.left), getHeight(node.right));
	}
	
	int maxDepth(Node node) 
    {
        if (node == null)
            return 0;
        else
        {
            /* compute the depth of each subtree */
            int lDepth = maxDepth(node.left);
            int rDepth = maxDepth(node.right);
  
            /* use the larger one */
            if (lDepth > rDepth)
                return (lDepth + 1);
             else
                return (rDepth + 1);
        }
    }
	
	public static void main(String[] args) {
		
		HeightOfBinaryTree tree = new HeightOfBinaryTree();
		
		tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        
        System.out.println("Height of tree : "+tree.getHeight(tree.root));
        System.out.println("Height of tree : "+tree.maxDepth(tree.root));
	}
}
