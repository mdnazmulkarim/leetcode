public class ConstructBstFromPreorderTraversal {


    public static void main(String[] args) {
        int[] arr = {8,5,1,7,10,12};
        TreeNode tree = new ConstructBstFromPreorderTraversal().bstFromPreorder(arr);
        System.out.println(tree.val);
        System.out.println(tree.left.val);
        System.out.println(tree.right.val);

        System.out.println(tree.left.left.val);
        System.out.println(tree.left.right.val);

        //System.out.println(tree.right.left.val == 0);
        System.out.println(tree.right.right.val);
    }


    public TreeNode bstFromPreorder(int[] preorder) {
       TreeNode node = new TreeNode();

       int i = 0;

       while(i < preorder.length) {
           buildTree(node, preorder[i]);
           i++;

       }

       return node;
    }

    void buildTree(TreeNode node, int val) {
        if(node.val == 0) {
            node.val = val;
        }

        if(val < node.val) {
            if(node.left == null) {
                node.left = new TreeNode();
            }
            buildTree(node.left, val);
        } else if(val > node.val) {
            if(node.right == null) {
                node.right = new TreeNode();
            }
            buildTree(node.right, val);
        }
    }


    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode () {
        }

        TreeNode (int val) {
            this.val = val;
        }

        TreeNode (int val, TreeNode l, TreeNode r) {
            this.val = val;
            this.left =l;
            this.right = r;
        }

    }
}
