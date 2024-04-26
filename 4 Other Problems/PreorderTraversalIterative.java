
import in.knowledgegate.dsa.binarytree.model.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Write Preorder traversal of a binary tree using
 * iterative approach
 */
class PreorderTraversalIterative {
  public List<Integer> iterativePreorder(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    if (root == null) {
      return result;
    }

    Stack<TreeNode> stack = new Stack<>();
    stack.push(root);
    while (!stack.isEmpty()) {
      TreeNode temp = stack.pop();
      result.add(temp.val);

      if (temp.right != null) {
        stack.push(temp.right);
      }
      if (temp.left != null) {
        stack.push(temp.left);
      }
    }

    return result;
  }
}
