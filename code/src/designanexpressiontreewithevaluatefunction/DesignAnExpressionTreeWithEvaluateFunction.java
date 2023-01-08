package designanexpressiontreewithevaluatefunction;

public class DesignAnExpressionTreeWithEvaluateFunction {
    public static void main(String[] args) {
        String[] arr = {"3","4","+","2","*","7","/"};
        //String[] arr = {"4", "5", "2", "7", "+", "-", "*"};

        TreeBuilder treeBuilder = new TreeBuilder();
        Node tree = treeBuilder.buildTree(arr);
        System.out.println(tree.evaluate());
    }
}