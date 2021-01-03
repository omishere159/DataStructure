package com.tree.jp;

import java.util.Objects;
import java.util.logging.Logger;

public class BinarySearchTree<T extends Comparable> {

  private final Logger LOGGER = Logger.getLogger(getClass().getName());
  private Node<T> root;

  public BinarySearchTree(Node<T> root) {
    this.root = root;
  }

  public void add(T value) {
    Node lCurNode = root;
    while (Objects.nonNull(lCurNode)) {
      if (value.compareTo(lCurNode.getValue()) == 0) {
        LOGGER.info("Value already exists: " + value);
        break;
      }
      if (value.compareTo(lCurNode.getValue()) > 0) {
        if (Objects.isNull(lCurNode.getRight())) {
          lCurNode.setRight(new Node<>(value));
          break;
        }
        lCurNode = lCurNode.getRight();
      } else if (value.compareTo(lCurNode.getValue()) < 0) {
        if (Objects.isNull(lCurNode.getLeft())) {
          lCurNode.setLeft(new Node<>(value));
          break;
        }
        lCurNode = lCurNode.getLeft();
      }
    }
  }

  public Node<T> getRoot() {
    return root;
  }
}
