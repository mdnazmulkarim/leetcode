import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BinaryTreeLevelOrderTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);

        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        new BinaryTreeLevelOrderTraversal().levelOrder(root);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {

        Map<Integer, List<Integer>> map = new HashMap<>();

        List<List<Integer>> listOfList = new ArrayList<>();
        if(root!=null){
            traverse(root, 0, map);
        }

        System.out.println(map);


        for(List<Integer> list : map.values()) {
            listOfList.add(list);
        }
        return listOfList;
    }

    private void traverse(TreeNode node, int level, Map<Integer, List<Integer>> map) {
        if(!map.containsKey(level)) {
            map.put(level, new ArrayList<>());
        }
        map.get(level).add(node.val);

        if(node.left != null) {
            traverse(node.left, level+1, map);
        }
        if(node.right != null) {
            traverse(node.right, level+1, map);
        }
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
