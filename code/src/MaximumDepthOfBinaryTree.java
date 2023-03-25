public class MaximumDepthOfBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);

        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(new MaximumDepthOfBinaryTree().maxDepth(root));
    }

    public int maxDepth(TreeNode root) {
     int max = 0;
        if (root != null) {
            max = traverse(root, 1, 1);
        }

     return max;
    }

    private int traverse(TreeNode node, int depth, int max) {
        max = Math.max(depth, max);
        int l =depth;
        int r =depth;
        if(node.left != null) {
            l=traverse(node.left, depth+1, max);
        }
        if(node.right != null) {
            r=traverse(node.right, depth+1, max);
        }
        return Math.max(max,Math.max(l,r));
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return Integer.toString(val);
        }
    }
}
