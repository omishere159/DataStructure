package com.tree.jp;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class BinaryTree<T extends Comparable> extends MyTree<T> {

  public BinaryTree(Node<T> root) {
    super(root);
  }

  @Override
  protected void add(T value) {
    Node lCurNode = root;
    Queue<Node> lQueue = new LinkedList();
    lQueue.add(root);
    lCurNode = lQueue.poll();
    while (Objects.nonNull(lCurNode)) {
      if (Objects.isNull(lCurNode.getLeft())) {
        lCurNode.setLeft(new Node<>(value));
        break;
      } else if (Objects.isNull(lCurNode.getRight())) {
        lCurNode.setRight(new Node<>(value));
        break;
      }
      lQueue.add(lCurNode.getLeft());
      lQueue.add(lCurNode.getRight());
      lCurNode = lQueue.poll();
    }
  }
}
