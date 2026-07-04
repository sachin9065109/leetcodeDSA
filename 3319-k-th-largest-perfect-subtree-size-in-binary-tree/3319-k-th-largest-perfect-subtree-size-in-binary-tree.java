/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    class Info {
        boolean perfect;
        int height;

        Info(boolean perfect, int height) {
            this.perfect = perfect;
            this.height = height;
        }
    }

    List<Integer> sizes = new ArrayList<>();

    public int kthLargestPerfectSubtree(TreeNode root, int k) {
        dfs(root);

        Collections.sort(sizes, Collections.reverseOrder());

        if (k > sizes.size()) return -1;
        return sizes.get(k - 1);
    }

    private Info dfs(TreeNode node) {
        if (node == null) {
            return new Info(true, 0);
        }

        Info left = dfs(node.left);
        Info right = dfs(node.right);

        if (left.perfect && right.perfect && left.height == right.height) {
            int height = left.height + 1;
            int size = (1 << height) - 1;
            sizes.add(size);
            return new Info(true, height);
        }

        return new Info(false, Math.max(left.height, right.height) + 1);
    }
}