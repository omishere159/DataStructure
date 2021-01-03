package com.tree.jp;

import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BTInDFSTraversals<T> {

  private final Logger LOGGER = Logger.getLogger(getClass().getName());

  public void inorder(Node root) {
    if (Objects.isNull(root)) {
      LOGGER.log(Level.SEVERE, "Tree is empty");
      return;
    }
    LOGGER.info("In-Order Traversal output: ");
    in(root);
    System.out.println("");
    LOGGER.info("In-Order Traversal Ends");
  }

  private void in(Node root) {
    if (Objects.nonNull(root)) {
      in(root.getLeft());
      print(root.getValue());
      in(root.getRight());
    }
  }

  private void print(Comparable value) {
    System.out.print(value + " ");
  }

  public void preorder(Node root) {
    if (Objects.isNull(root)) {
      LOGGER.log(Level.SEVERE, "Tree is empty");
      return;
    }
    LOGGER.info("Pre-Order Traversal output: ");
    pre(root);
    System.out.println("");
    LOGGER.info("Pre-Order Traversal Ends");
  }

  private void pre(Node root) {
    if (Objects.nonNull(root)) {
      print(root.getValue());
      pre(root.getLeft());
      pre(root.getRight());
    }
  }

  public void postorder(Node root) {
    if (Objects.isNull(root)) {
      LOGGER.log(Level.SEVERE, "Tree is empty");
      return;
    }
    LOGGER.info("Post-Order Traversal output: ");
    post(root);
    System.out.println("");
    LOGGER.info("Post-Order Traversal Ends");
  }

  private void post(Node root) {
    if (Objects.nonNull(root)) {
      pre(root.getLeft());
      pre(root.getRight());
      print(root.getValue());
    }
  }

  public int height(Node root) {
    if (Objects.isNull(root)) {
      return 0;
    }
    return Math.max(height(root.getLeft()), height(root.getRight())) + 1;
  }

  public void printKthLevelNodes(Node root, int level) {
    if (Objects.isNull(root)) {
      LOGGER.info("Tree is empty");
      return;
    }
    if (level == 0) {
      print(root.getValue());
      return;
    }
    LOGGER.info(String.format("%d level nodes are: ", level));
    printNodes(root, 1, level + 1);
    LOGGER.info("Done");
  }

  private void printNodes(Node root, int curLevel, int level) {
    if (Objects.isNull(root)) {
      return;
    }
    if (curLevel == level) {
      print(root.getValue());
      return;
    }
    printNodes(root.getLeft(), curLevel + 1, level);
    printNodes(root.getRight(), curLevel + 1, level);
  }

  public void printKthLevelNodes2(Node root, int level) {
    if (Objects.isNull(root)) {
      LOGGER.info("Tree is empty");
      return;
    }
    if (level == 0) {
      print(root.getValue());
    } else {
      LOGGER.info(String.format("%d level nodes are: ", level));
      printKDist(root.getLeft(), level - 1);
      printKDist(root.getRight(), level - 1);
    }

    LOGGER.info("Done");
  }

  private void printKDist(Node root, int curLevel) {
    if (Objects.isNull(root)) {
      return;
    }
    if (curLevel == 0) {
      print(root.getValue());
    } else {
      printKDist(root.getLeft(), curLevel - 1);
      printKDist(root.getRight(), curLevel - 1);
    }
  }

}
