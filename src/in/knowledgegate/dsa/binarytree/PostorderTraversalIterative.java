package in.knowledgegate.dsa.binarytree;

import in.knowledgegate.dsa.binarytree.model.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Write Postorder traversal of a binary tree
 * using iterative approach
 */
public class PostorderTraversalIterative {
  public List<Integer> iterativePostorder(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    if (root == null) {
      return result;
    }

    Stack<TreeNode> s1 = new Stack<>();
    Stack<TreeNode> s2 = new Stack<>();
    s1.push(root);

    while (!s1.isEmpty()) {
      TreeNode temp = s1.pop();
      s2.push(temp);

      if (temp.left != null) {
        s1.push(temp.left);
      }
      if (temp.right != null) {
        s1.push(temp.right);
      }
    }

    while (!s2.isEmpty()) {
      result.add(s2.pop().val);
    }

    return result;
  }
}
