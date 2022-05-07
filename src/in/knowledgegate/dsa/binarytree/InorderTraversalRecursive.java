package in.knowledgegate.dsa.binarytree;

import in.knowledgegate.dsa.binarytree.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Write Inorder traversal of a binary tree using
 * recursive approach
 */
public class InorderTraversalRecursive {
  public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    inorderTraversal(root, result);
    return result;
  }
  private void inorderTraversal(TreeNode root,
      List<Integer> result) {
    if (root == null) return;
    inorderTraversal(root.left, result);
    result.add(root.val);
    inorderTraversal(root.right, result);
  }
}
