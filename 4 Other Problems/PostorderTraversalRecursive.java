
import in.knowledgegate.dsa.binarytree.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Write Postorder traversal of a binary tree
 * using recursive approach
 */
class PostorderTraversalRecursive {
  public List<Integer> postorderTraversal(TreeNode root) {
    List<Integer> list = new ArrayList<>();
    postorderTraversal(root, list);
    return list;
  }

  private void postorderTraversal(TreeNode root,
      List<Integer> result) {
    if (root == null)
      return;
    postorderTraversal(root.left, result);
    postorderTraversal(root.right, result);
    result.add(root.val);
  }
}
