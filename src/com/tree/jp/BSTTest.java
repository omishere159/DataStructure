package com.tree.jp;

public class BSTTest {

  public static void main(String[] args) {

    BinaryTree<Integer> lBST = new BinaryTree<>(new Node<>(10));
    lBST.add(20);
    lBST.add(30);
    lBST.add(40);
    lBST.add(50);
    /*new BTInDFSTraversals<>().inorder(lBST.getRoot());
    new BTInDFSTraversals<>().preorder(lBST.getRoot());
    new BTInDFSTraversals<>().postorder(lBST.getRoot());*/
    //print nodes at k distance
    //new BTInDFSTraversals<>().printKthLevelNodes(lBST.getRoot(),2);
    new BTInDFSTraversals<>().printKthLevelNodes2(lBST.getRoot(),2);
  }
}
