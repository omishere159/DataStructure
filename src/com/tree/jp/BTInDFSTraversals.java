package com.tree.jp;

import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BTInDFSTraversals<T> {
  private final Logger LOGGER = Logger.getLogger(getClass().getName());
  public void inorder(Node root)
  {
    if(Objects.isNull(root))
    {
      LOGGER.log(Level.SEVERE,"Tree is empty");
      return;
    }
    in(root);
  }

  private void in(Node root) {
    if(Objects.nonNull(root))
    {
      in(root.getLeft());
      LOGGER.info("Cur Value:"+root.getValue());
      in(root.getRight());
    }
  }
}
