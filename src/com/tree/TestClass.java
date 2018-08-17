package com.tree;

import java.util.*;

public class TestClass {
 
 static Node root;
 static class Node
 {
     Node left;
     Node right;
     int value;
     
     Node( int val)
     {
         this.value = val;
     }
 }
 
 public static void main(String args[] ) throws Exception {
     /* Sample code to perform I/O:
      * Use either of these methods for input

     //BufferedReader
     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
     String name = br.readLine();                // Reading input from STDIN
     System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

     */
     //Scanner
     Scanner s = new Scanner(System.in);
     int N = s.nextInt();
     while( N > 1)
     {
         add(s.nextInt(),s.nextInt());
         N--;
     }
     printMaxDistanceForNodes();
 }
 
 private static void add(int parent,int child)
 {
     if(null == root)
     {
         root = new Node(parent);
         root.left = new Node(child);
         return;
     }
     java.util.Queue<Node> lQueue = new java.util.LinkedList<>();
     lQueue.add(root);
     Node lCurNode;
     while( !lQueue.isEmpty())
     {
         lCurNode = lQueue.poll();
         if( lCurNode.value == parent)
         {
             addNode(lCurNode,child);
             return;
         }
         if( null != lCurNode.left)
         {
             lQueue.add(lCurNode.left);
         }
         if( null != lCurNode.right)
         {
             lQueue.add(lCurNode.right);
         }
     }
 }
 
 private static void addNode(Node root,int val)
 {
     if(root.left == null)
     {
         root.left = new Node(val);
         return;
     }
     root.right = new Node(val);
 }
 
 private static void printMaxDistanceForNodes()
 {
     if(null == root)
     {
         System.out.println(0);
     }
     java.util.Queue<Node> lQueue = new java.util.LinkedList<>();
     lQueue.add(root);
     Node lCurNode;
     while( !lQueue.isEmpty())
     {
         lCurNode = lQueue.poll();
         System.out.print(findMaximumDistance(lCurNode));
         
         if( null != lCurNode.left)
         {
             lQueue.add(lCurNode.left);
         }
         if( null != lCurNode.right)
         {
             lQueue.add(lCurNode.right);
         }
         if( !lQueue.isEmpty())
         {
        	 System.out.print(" ");
         }
     }
     System.out.println();
 }
 
 private static int findMaximumDistance( Node rt)
 {
     if( rt == null)
     {
         return 0;
     }
     
     if( rt.left == null  && rt.right == null)
     {
    	 return 0;
     }
     
     int lLHeight = getHeight(rt.left);
     int lRHeight = getHeight(rt.right);
     
     int lLWidth = findMaximumDistance(rt.left);
     int lRWidth = findMaximumDistance(rt.right);
     
     return java.lang.Math.max(lLHeight + lRHeight + 1, java.lang.Math.max(lLWidth,lRWidth));
 }
 
 
 
 private static int getHeight( Node node)
 {
     if( node == null)
     {
         return 0;
     }
     
     if(node.left == null && node.right == null)
    	 return 0;
     
     return Integer.max(getHeight(node.left), getHeight(node.right)) + 1;
     
 }
}

