
import in.knowledgegate.dsa.binarytree.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Write Preorder traversal of a binary tree using
 * recursive approach
 */
class PreorderTraversalRecursive {
  public List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    preorderTraversal(root, result);
    return result;
  }

  public void preorderTraversal(TreeNode root,
      List<Integer> result) {
    if (root == null)
      return;
    result.add(root.val);
    preorderTraversal(root.left, result);
    preorderTraversal(root.right, result);
  }
}
