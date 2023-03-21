public class SymmetricTree {
    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);

        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        System.out.println(new SymmetricTree().isSymmetric(root));
    }
    public boolean isSymmetric(TreeNode root) {
        if(root.left == null && root.right == null) {
            return true;
        }

        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
        boolean retValue = true;

        retValue = retValue && (left == null ? right == null : true);
        retValue = retValue && (right == null ? left == null : true);

        if(left == null || right== null && retValue == true) { return retValue;}

        retValue = retValue && left.val==right.val;
        if(!retValue){ return false;}
        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
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

        TreeNode(int val, TreeNode left,TreeNode right) {
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
