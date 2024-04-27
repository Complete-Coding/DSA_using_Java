
import in.knowledgegate.dsa.binarytree.model.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Write Inorder traversal of a binary tree using
 * iterative approach
 */
class InorderTraversalIterative {
  public List<Integer> inorderTraversal(TreeNode root) {
    Stack<TreeNode> stack = new Stack<>();
    List<Integer> result = new ArrayList<>();
    TreeNode curr = root;

    while (curr != null || !stack.isEmpty()) {
      while (curr != null) {
        stack.push(curr);
        curr = curr.left;
      }
      curr = stack.pop();
      result.add(curr.val);
      curr = curr.right;
    }
    return result;
  }
}
