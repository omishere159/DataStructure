package com.tree;

public class BinaryTreeToLinkedList {

	Node root;
	Node head;
	Node prev;
	static class Node
	{
		Node left;
		Node right;
		int data;
		public Node(int data) {
			this.data = data;
		}
	}
	
	public Node getDoubllyLinkedList()
	{
		convertTreeTiLnkedList(root);
		return head;
	}

	private void convertTreeTiLnkedList(Node root) {
		
		if( root != null)
		{
			convertTreeTiLnkedList(root.left);
			if( head == null)
			{
				head = new Node(root.data);
				prev = head;
			}
			else
			{
				Node lNextNode = new Node(root.data);
				prev.right = lNextNode;
				lNextNode.left = prev;
				prev = lNextNode;
			}
			convertTreeTiLnkedList(root.right);
		}
	}
	
	public static void main(String[] args) {
		
		BinaryTreeToLinkedList tree = new BinaryTreeToLinkedList();
		
		tree.root = new Node(10);
	     tree.root.left = new Node(12);
	     tree.root.right = new Node(15);
	     tree.root.left.left = new Node(25);
	     tree.root.left.right = new Node(30);
	     tree.root.right.left = new Node(36);
	     tree.root.right.right = new Node(37);
	     
	     printDLL(tree.getDoubllyLinkedList());
	}

	private static void printDLL(Node head) {
		
		if( null == head)
		{
			System.out.println("DLL is empty");
		}
		Node cur = head;
		while( cur != null)
		{
			System.out.print("[Prev - "+ (cur.left == null ? 0 : cur.left.data));
			System.out.print(" <> Data - "+cur.data);
			System.out.print(" <> Next - "+ (cur.right == null ? 0 : cur.right.data)+" ]=>");
			cur = cur.right;
		}
		System.out.println();
	}
	
}
