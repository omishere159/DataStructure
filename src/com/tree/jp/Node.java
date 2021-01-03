package com.tree.jp;

public class Node<T extends Comparable> {

  private Node left;
  private Node right;
  private T value;

  public Node(T value) {
    this.value = value;
  }

  public Node getLeft() {
    return left;
  }

  public void setLeft(Node left) {
    this.left = left;
  }

  public Node getRight() {
    return right;
  }

  public void setRight(Node right) {
    this.right = right;
  }

  public T getValue() {
    return value;
  }
}
