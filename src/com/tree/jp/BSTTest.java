package com.tree.jp;

public class BSTTest {

  public static void main(String[] args) {

    BinaryTree<Integer> lBST = new BinaryTree<>(new Node<>(10));
    lBST.add(20);
    lBST.add(30);
    lBST.add(40);
    lBST.add(50);
    new BTInDFSTraversals<>().inorder(lBST.getRoot());
  }
}
