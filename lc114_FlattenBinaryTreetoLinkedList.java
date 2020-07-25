public class lc114_FlattenBinaryTreetoLinkedList {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void flatten(TreeNode root) {
        if (root == null) return;
        preAccess(root);
    }

    private static void preAccess(TreeNode target) {
        // exist left then go left
        if (target.left != null) {
            preAccess(target.left);
        }
        // reach the most left, exist right then go right
        if (target.right != null) {
            preAccess(target.right);
        }

        // now reach the one that null on left and right
        if (target.left != null) {
            TreeNode left = target.left;
            while (left.right != null) {
                left = left.right;
            }
            left.right = target.right;
            target.right = target.left;
            target.left = null;
        }
    }

    private void test() {

    }

}








