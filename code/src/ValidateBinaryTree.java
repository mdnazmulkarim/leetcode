public class ValidateBinaryTree {
    public static void main(String[] args) {

        //2,1,3
//        TreeNode root = new TreeNode(2);
//        root.left = new TreeNode(1);
//        root.right = new TreeNode(3);

        // 5,4,6,null,null,3,7]
//        TreeNode root = new TreeNode(5);
//        root.left = new TreeNode(4);
//        root.right = new TreeNode(6);
//        root.right.left = new TreeNode(3);
//        root.right.right = new TreeNode(7);

//        TreeNode root = new TreeNode(2);
//        root.left = new TreeNode(2);
//        root.right = new TreeNode(2);

        TreeNode root = new TreeNode(2147483647);
        root.left = new TreeNode(2147483647);
        root.right = new TreeNode(2147483647);
//        System.out.println(root);
//        System.out.println(Integer.MAX_VALUE);

        System.out.println(new ValidateBinaryTree().isValidBST(root));
    }

    public boolean isValidBST(TreeNode root) {

        long max = Long.MAX_VALUE;
        long min = Long.MIN_VALUE;

        return isValidBST(root, min, max);
    }

    private boolean isValidBST(TreeNode root, long min, long max) {
        boolean retValue= true;

        if(root != null) {
            if ((long)root.val <= min ||  (long)root.val >= max) {
                return false;
            }
            retValue = isValidBST(root.left, min, root.val);
            retValue =  retValue && isValidBST(root.right, root.val, max);
        }
        return retValue;
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
