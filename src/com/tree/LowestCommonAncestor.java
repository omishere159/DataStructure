package com.tree;

public class LowestCommonAncestor {

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
	
	public static void main(String[] args) {
		
		LowestCommonAncestor tree = new LowestCommonAncestor();
		tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        
        System.out.println("LCA (4,5) "+tree.printLowestCommonAncestor(tree.root,4,5).data);
	}

	private Node printLowestCommonAncestor(Node node, int n1, int n2) {
		
		if (node == null)
	         return null;

	     // If either n1 or n2 matches with root's key, report
	     // the presence by returning root (Note that if a key is
	     // ancestor of other, then the ancestor key becomes LCA
	     if (node.data == n1 || node.data == n2)
	         return node;

	     // Look for keys in left and right subtrees
	     Node left_lca = printLowestCommonAncestor(node.left, n1, n2);
	     Node right_lca = printLowestCommonAncestor(node.right, n1, n2);

	     // If both of the above calls return Non-NULL, then one key
	     // is present in once subtree and other is present in other,
	     // So this node is the LCA
	     if (left_lca!=null && right_lca!=null)
	         return node;

	     // Otherwise check if left subtree or right subtree is LCA
	     return (left_lca != null) ? left_lca : right_lca;
	}
}
