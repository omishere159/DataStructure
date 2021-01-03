package com.tree.jp;

public abstract class MyTree<T extends Comparable> {

  protected Node<T> root;

  public MyTree(Node<T> root) {
    this.root = root;
  }

  public Node<T> getRoot() {
    return root;
  }

  protected abstract void add(T value);
}
